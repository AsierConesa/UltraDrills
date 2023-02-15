/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ultradrills;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.configuration.serialization.SerializableAs;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author asier
 */

@SerializableAs("Drill")
public class Drill implements ConfigurationSerializable{
    
    UltraDrills plugin;

    //VARIABLES
    private String id;
    private ItemStack item;
    private double ratio; //number of seconds per item in level 1
    private int umlcoinsV; // UMLCoins de subir velocidad a lvl 2
    private int ecoinsV; // ECoins de subir velocidad a lvl 2
    private int umlcoinsA; // UMLCoins de subir almacenamiento a lvl 2
    private int ecoinsA; // ECoins de subir almacenamiento a lvl 2
    private int pieza1V; // n pieza1 de subir velocidad a lvl 2
    private int pieza2V; // n pieza2 de subir velocidad a lvl 2
    private int pieza3V; // n pieza3 de subir velocidad a lvl 2
    private int pieza1A; // n pieza1 de subir almacenamiento a lvl 2
    private int pieza2A; // n pieza2 de subir almacenamiento a lvl 2
    private int pieza3A; // n pieza3 de subir almacenamiento a lvl 2

    //CONSTRUCTORES
    public Drill(String id, ItemStack item, double ratio, int umlcoinsV, int ecoinsV, int umlcoinsA, int ecoinsA, int pieza1V, int pieza2V, int pieza3V, int pieza1A, int pieza2A, int pieza3A) {
        plugin = UltraDrills.getInstance();
        
        this.id = id;
        this.item = item;
        this.ratio = ratio;
        this.umlcoinsV = umlcoinsV;
        this.ecoinsV = ecoinsV;
        this.umlcoinsA = umlcoinsA;
        this.ecoinsA = ecoinsA;
        this.pieza1V = pieza1V;
        this.pieza2V = pieza2V;
        this.pieza3V = pieza3V;
        this.pieza1A = pieza1A;
        this.pieza2A = pieza2A;
        this.pieza3A = pieza3A;
    }

    public Drill(String id) {
        plugin = UltraDrills.getInstance();
        
        this.id = id;
        this.item = null;
        this.ratio = -1;
        this.umlcoinsV = -1;
        this.ecoinsV = -1;
        this.umlcoinsA = -1;
        this.ecoinsA = -1;
        this.pieza1V = -1;
        this.pieza2V = -1;
        this.pieza3V = -1;
        this.pieza1A = -1;
        this.pieza2A = -1;
        this.pieza3A = -1;
    }
    
    //ABSTRACT METHODS IMPLEMENTED
    public Map<String, Object> serialize() {
        LinkedHashMap result = new LinkedHashMap();
        result.put("id", this.getId());
        result.put("item", this.getItem());
        result.put("ratio", this.getRatio());
        result.put("umlcoinsV", this.getUmlcoinsV());
        result.put("ecoinsV", this.getEcoinsV());
        result.put("umlcoinsA", this.getUmlcoinsA());
        result.put("ecoinsA", this.getEcoinsA());
        result.put("pieza1V", this.getPieza1V());
        result.put("pieza2V", this.getPieza2V());
        result.put("pieza3V", this.getPieza3V());
        result.put("pieza1A", this.getPieza1A());
        result.put("pieza2A", this.getPieza2A());
        result.put("pieza3A", this.getPieza3A());
        
        return result;
    }
    
    public static Drill deserialize(Map<String, Object> args) {
        
        String id = "";
        ItemStack item = null;
        double ratio = -1;
        int umlcoinsV = -1;
        int ecoinsV = -1;
        int umlcoinsA = -1;
        int ecoinsA = -1;
        int pieza1V = -1;
        int pieza2V = -1;
        int pieza3V = -1;
        int pieza1A = -1;
        int pieza2A = -1;
        int pieza3A = -1;
        
        if(args.containsKey("id")){
            id = (String) args.get("id");
        }
        if(args.containsKey("item")){
            item = (ItemStack) args.get("item");
        }
        if(args.containsKey("ratio")){
            ratio = (double) args.get("ratio");
        }
        if(args.containsKey("umlcoinsV")){
            umlcoinsV = (int) args.get("umlcoinsV");
        }
        if(args.containsKey("ecoinsV")){
            ecoinsV = (int) args.get("ecoinsV");
        }
        if(args.containsKey("umlcoinsA")){
            umlcoinsA = (int) args.get("umlcoinsA");
        }
        if(args.containsKey("ecoinsA")){
            ecoinsA = (int) args.get("ecoinsA");
        }
        if(args.containsKey("pieza1V")){
            pieza1V = (int) args.get("pieza1V");
        }
        if(args.containsKey("pieza2V")){
            pieza2V = (int) args.get("pieza2V");
        }
        if(args.containsKey("pieza3V")){
            pieza3V = (int) args.get("pieza3V");
        }
        if(args.containsKey("pieza1A")){
            pieza1A = (int) args.get("pieza1A");
        }
        if(args.containsKey("pieza2A")){
            pieza2A = (int) args.get("pieza2A");
        }
        if(args.containsKey("pieza3A")){
            pieza3A = (int) args.get("pieza3A");
        }
        
        return new Drill(id, item, ratio, umlcoinsV, ecoinsV, umlcoinsA, ecoinsA, pieza1V, pieza2V, pieza3V, pieza1A, pieza2A, pieza3A);
    }

    //SETTERS AND GETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public int getUmlcoinsV() {
        return umlcoinsV;
    }

    public void setUmlcoinsV(int umlcoinsV) {
        this.umlcoinsV = umlcoinsV;
    }

    public int getEcoinsV() {
        return ecoinsV;
    }

    public void setEcoinsV(int ecoinsV) {
        this.ecoinsV = ecoinsV;
    }

    public int getUmlcoinsA() {
        return umlcoinsA;
    }

    public void setUmlcoinsA(int umlcoinsA) {
        this.umlcoinsA = umlcoinsA;
    }

    public int getEcoinsA() {
        return ecoinsA;
    }

    public void setEcoinsA(int ecoinsA) {
        this.ecoinsA = ecoinsA;
    }

    public int getPieza1V() {
        return pieza1V;
    }

    public void setPieza1V(int pieza1V) {
        this.pieza1V = pieza1V;
    }

    public int getPieza2V() {
        return pieza2V;
    }

    public void setPieza2V(int pieza2V) {
        this.pieza2V = pieza2V;
    }

    public int getPieza3V() {
        return pieza3V;
    }

    public void setPieza3V(int pieza3V) {
        this.pieza3V = pieza3V;
    }

    public int getPieza1A() {
        return pieza1A;
    }

    public void setPieza1A(int pieza1A) {
        this.pieza1A = pieza1A;
    }

    public int getPieza2A() {
        return pieza2A;
    }

    public void setPieza2A(int pieza2A) {
        this.pieza2A = pieza2A;
    }

    public int getPieza3A() {
        return pieza3A;
    }

    public void setPieza3A(int pieza3A) {
        this.pieza3A = pieza3A;
    }

    
    
    // Methods
    
    public String insert(){
        if(this.ratio > 0){
            List<Drill> drills = (List<Drill>) plugin.getConfig().getList("drills");
            
            drills = (drills == null) ? new ArrayList<>() : drills;

            if(this.exists())
                return ChatColor.RED+"El nombre de ese taladro está actualmente en uso, utilice otro";
            else{
                drills.add(this);
                plugin.getConfig().set("drills", drills);
                plugin.saveConfig();
                return ChatColor.GREEN+"El taladro se ha creado correctamente";
            }
        }
        return ChatColor.RED+"Se ha producido un error";
    }
    
    public Drill getDrill(){
    
        List<Drill> drills = (List<Drill>) plugin.getConfig().getList("drills");
        
        drills = (drills == null) ? new ArrayList<>() : drills;
        
        var optDrill = drills.stream()
                .filter(x -> x.getId().equals(this.getId()))
                .findFirst();
        Drill drill = (optDrill.isPresent()) ? optDrill.get() : null;

        return drill;
        
    }
    
    public boolean exists(){
    
        List<Drill> drills = (List<Drill>) plugin.getConfig().getList("drills");
        
        drills = (drills == null) ? new ArrayList<>() : drills;
        
        return drills.stream()
                .filter(x -> x.getId().equals(this.getId()))
                .count() != 0;
    }
    
    public String delete(){
        List<Drill> drills = (List<Drill>) plugin.getConfig().getList("drills");
        
        drills = (drills == null) ? new ArrayList<>() : drills;
        
        if(this.exists()){
            drills.remove(this);
            plugin.getConfig().set("drills", drills);
            plugin.saveConfig();
            return ChatColor.GREEN+"Se ha eliminado el taladro correctamente";
        }
        else
            return ChatColor.RED+"No se ha encontrado el taladro";
        
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drill drill)) return false;

        return getId().equals(drill.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    
}
