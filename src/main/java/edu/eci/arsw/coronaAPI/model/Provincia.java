package edu.eci.arsw.coronaAPI.model;

public class Provincia{
    String nombre;
    int numDeaths; 
    int numInfected;
    int numCured;
    public Provincia(String nombre, int numDeaths, int numInfected, int numCured){
        this.nombre = nombre;
        this.numInfected = numInfected;
        this.numDeaths = numDeaths;
        this.numCured = numCured;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setNumDeaths(int numDeaths){
        this.numDeaths = numDeaths;
    }

    public void setInfected(int numInfected){
        this.numInfected = numInfected;
    }

    public void setNumCured(int numCured){
        this.numCured = numCured;
    }
    public String getNombre(){
        return nombre;
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