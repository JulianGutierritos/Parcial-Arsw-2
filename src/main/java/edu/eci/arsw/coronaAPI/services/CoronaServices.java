package edu.eci.arsw.coronaAPI.services;

import java.util.HashMap;


import edu.eci.arsw.coronaAPI.exceptions.ServiceException;
import edu.eci.arsw.coronaAPI.model.Pais;
public interface CoronaServices {

    public HashMap<String, Pais> getPaises() throws ServiceException;
    public Pais getPais(String pais) throws ServiceException;
    public String getCoordenada(String pais) throws ServiceException;
}
