package edu.eci.arsw.coronaAPI.model;

import java.util.ArrayList;

public class Pais {
    String nombre;
    int numDeaths; 
    int numInfected;
    int numCured;
    ArrayList<Provincia> provincias = new ArrayList<>();
    public Pais(String nombre){
        this.nombre = nombre;
    }

    public void addProvincia(Provincia p){
        numInfected += p.numInfected;
        numDeaths += p.numDeaths;
        numCured += p.numCured;
        provincias.add(p);
    }

    public void setNumInfected(int val){
        this.numInfected = val;
    }

    public void setDeaths(int val){
        this.numDeaths = val;
    }

    public void setNumCured(int val){
        this.numCured = val;
    }

    public String getNombre(){
        return this.nombre;
    }

    public ArrayList<Provincia> getProvincias(){
        return this.provincias;
    }
    public int getNumDeaths(){
        return numDeaths;
    }
    public int getNumInfected(){
        return numInfected;
    }
    public int getNumCured(){
        return numCured;
    }

}