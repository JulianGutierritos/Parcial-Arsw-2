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
}