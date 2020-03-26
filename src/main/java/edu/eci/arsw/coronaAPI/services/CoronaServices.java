package edu.eci.arsw.coronaAPI.services;

import java.util.HashMap;

import edu.eci.arsw.coronaAPI.model.Pais;
public interface CoronaServices {

    public HashMap<String, Pais> getPaises();
    public Pais getPais(String pais);
}
