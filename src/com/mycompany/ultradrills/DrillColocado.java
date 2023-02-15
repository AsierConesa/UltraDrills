/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ultradrills;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;

/**
 *
 * @author asier
 */

@SerializableAs("Drill")
public class DrillColocado implements ConfigurationSerializable{
    
    UltraDrills plugin;

    //VARIABLES
    private String id;
    private String uuid;

    //CONSTRUCTORES
    public DrillColocado(String id, String uuid) {
        plugin = UltraDrills.getInstance();
        
        this.id = id;
        this.uuid = uuid;
    }

    public DrillColocado(String uuid) {
        plugin = UltraDrills.getInstance();
        
        this.uuid = uuid;
        
    }
    
    //ABSTRACT METHODS IMPLEMENTED
    public Map<String, Object> serialize() {
        LinkedHashMap result = new LinkedHashMap();
        result.put("id", this.getId());
        result.put("uuid", this.getUuid());
        
        return result;
    }
    
    public static DrillColocado deserialize(Map<String, Object> args) {
        
        String id = "";
        String uuid = "";
        
        if(args.containsKey("id")){
            id = (String) args.get("id");
        }
        if(args.containsKey("uuid")){
            uuid = (String) args.get("uuid");
        }
        
        
        return new DrillColocado(id, uuid);
    }

    //SETTERS AND GETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    
    // Methods
    
    public String insert(){
        List<DrillColocado> drillsColocados = (List<DrillColocado>) plugin.getConfig().getList("drillsColocados");

        drillsColocados = (drillsColocados == null) ? new ArrayList<>() : drillsColocados;

        if(this.exists())
            return ChatColor.RED+"La UUID de ese taladro está actualmente en uso, esto es un error, reportelo en spigot";
        else{
            drillsColocados.add(this);
            plugin.getConfig().set("drillsColocados", drillsColocados);
            plugin.saveConfig();
            return ChatColor.GREEN+"El taladro se ha generado correctamente";
        }
    }
    
    public DrillColocado getDrillColocado(){
    
        List<DrillColocado> drillsColocados = (List<DrillColocado>) plugin.getConfig().getList("drillsColocados");
        
        drillsColocados = (drillsColocados == null) ? new ArrayList<>() : drillsColocados;
        
        var optDrill = drillsColocados.stream()
                .filter(x -> x.getUuid().equals(this.getUuid()))
                .findFirst();
        DrillColocado drillColocado = (optDrill.isPresent()) ? optDrill.get() : null;

        return drillColocado;
        
    }
    
    public boolean exists(){
        List<DrillColocado> drillsColocados = (List<DrillColocado>) plugin.getConfig().getList("drillsColocados");
        
        drillsColocados = (drillsColocados == null) ? new ArrayList<>() : drillsColocados;
        
        return drillsColocados.stream()
                .filter(x -> x.getUuid().equals(this.getUuid()))
                .count() != 0;
    }
    
    public String delete(){
        List<DrillColocado> drillsColocados = (List<DrillColocado>) plugin.getConfig().getList("drillsColocados");
        
        drillsColocados = (drillsColocados == null) ? new ArrayList<>() : drillsColocados;
        
        if(this.exists()){
            drillsColocados.remove(this);
            plugin.getConfig().set("drillsColocados", drillsColocados);
            plugin.saveConfig();
            return ChatColor.GREEN+"Se ha descolocado el taladro correctamente";
        }
        else{
            return ChatColor.RED+"No se ha encontrado el taladro";
        }
            
        
        
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DrillColocado drillColocado)) return false;

        return getUuid().equals(drillColocado.getUuid());
    }

    @Override
    public int hashCode() {
        return getUuid().hashCode();
    }

    
}
