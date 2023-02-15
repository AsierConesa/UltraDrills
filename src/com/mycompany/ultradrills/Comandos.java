/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ultradrills;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author asier
 */
public class Comandos implements CommandExecutor {

    private final UltraDrills instance;

    public Comandos(UltraDrills instance) {
        this.instance = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equals("drill")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                // /drill create (id) (ratio) (UMLCoinsV) (ECoinsV) (UMLCoinsA) (ECoinsA) (Pieza1V) (Pieza2V) (Pieza3V) (Pieza1A) (Pieza2A) (Pieza3A) **RQEUIERE ITEM EN LA MANO**
                // /drill delete (id)
                
                if(args.length == 0){
                    player.sendMessage(ChatColor.GOLD+"/drill create (id) (ratio) (UMLCoinsV) (ECoinsV) (UMLCoinsA) (ECoinsA) (Pieza1V) (Pieza2V) (Pieza3V) (Pieza1A) (Pieza2A) (Pieza3A) **RQEUIERE ITEM EN LA MANO**");
                    player.sendMessage(ChatColor.GOLD+"/drill delete (id)");
                }
                
                else if(args.length == 2){
                    if(args[0].equals("delete")){
                        String id = args[1];
                        Drill drill = new Drill(id);
                        drill.getDrill();
                        String result = drill.delete();
                        player.sendMessage(result);
                    }
                    else if(args[0].equals("generate")){
                        ArmorStand armorStand = (ArmorStand) ((Player)sender).getWorld().spawnEntity(((Player)sender).getLocation(), EntityType.ARMOR_STAND);
                        String uuid = armorStand.getUniqueId().toString();
                        String id = args[1];
                        DrillColocado drillColocado = new DrillColocado(uuid ,id);
                        drillColocado.insert();
                    }
                    else if(args[0].equals("kill")){
                        String uuid = args[1];
                        ArmorStand armorStand = getArmorStandByUniqueId(uuid);
                        DrillColocado drillColocado = new DrillColocado(uuid);
                        drillColocado.delete();
                        armorStand.remove();
                    }
                }
                else if(args.length == 13){
                    if(args[0].equals("create")){
                        String id = args[1];
                        double ratio = -1;
                        int umlcoinsV;
                        int ecoinsV;
                        int umlcoinsA;
                        int ecoinsA;
                        int pieza1V;
                        int pieza2V;
                        int pieza3V;
                        int pieza1A;
                        int pieza2A;
                        int pieza3A;
                        
                        if(isDouble(args[2]) && isPositiveInteger(args[3]) && isPositiveInteger(args[4]) && isPositiveInteger(args[5]) && isPositiveInteger(args[6]) && isPositiveInteger(args[7]) && isPositiveInteger(args[8]) && isPositiveInteger(args[9]) && isPositiveInteger(args[10]) && isPositiveInteger(args[11]) && isPositiveInteger(args[12])){
                           ItemStack item = player.getInventory().getItemInMainHand();
                           if (item != null){
                                ratio = Double.parseDouble(args[2]);
                                umlcoinsV = Integer.parseInt(args[3]);
                                ecoinsV = Integer.parseInt(args[4]);
                                umlcoinsA = Integer.parseInt(args[5]);
                                ecoinsA = Integer.parseInt(args[6]);
                                pieza1V = Integer.parseInt(args[7]);
                                pieza2V = Integer.parseInt(args[8]);
                                pieza3V = Integer.parseInt(args[9]);
                                pieza1A = Integer.parseInt(args[10]);
                                pieza2A = Integer.parseInt(args[11]);
                                pieza3A = Integer.parseInt(args[12]);
                                
                                Drill drill = new Drill(id, item, ratio, umlcoinsV, ecoinsV, umlcoinsA, ecoinsA, pieza1V, pieza2V, pieza3V, pieza1A, pieza2A, pieza3A);
                                String result = drill.insert();
                                player.sendMessage(result);
                           }
                        }
                        if(ratio <= 0){
                            player.sendMessage(ChatColor.RED+"los segundos/item deben ser mayor que 0");
                        }
                    }
                    else{
                        player.sendMessage(ChatColor.RED+"Los datos son incoherentes, usa /drill para ver la lista de comandos");
                    }
                }
                else{
                    player.sendMessage(ChatColor.RED+"Los datos son incoherentes, usa /drill para ver la lista de comandos");
                }
            } else {
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Drill no permite comandos desde la consola");
            }
        }

        return true;
    }

    public static boolean isDouble(String str){
        try
        {
          Double.parseDouble(str);
          return true;
        }
        catch(NumberFormatException e)
        {
          return false;
        }
    }
    
    public static boolean isPositiveInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    public ArmorStand getArmorStandByUniqueId(String uuid){
    for (World world : Bukkit.getWorlds()) {
        for (Chunk chunk : world.getLoadedChunks()) {
            for (Entity entity : chunk.getEntities()) {
                if (entity.getUniqueId().toString().equals(uuid)){
                    return (ArmorStand) entity;
                }
            }
        }
    }

    return null;
}
}
