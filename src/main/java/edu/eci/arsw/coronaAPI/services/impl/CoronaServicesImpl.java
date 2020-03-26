package edu.eci.arsw.coronaAPI.services.impl;

//import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.coronaAPI.services.CoronaServices;
import edu.eci.arsw.coronaAPI.exceptions.ServiceException;
import edu.eci.arsw.coronaAPI.httpConnector.HttpConnectionService;
import edu.eci.arsw.coronaAPI.model.*;
import edu.eci.arsw.coronaAPI.persistence.CoronaCache;

@Service
public class CoronaServicesImpl implements CoronaServices {

    @Autowired
    CoronaCache coronaCache;
    @Autowired
    HttpConnectionService httpConnectionService;
    
    public HashMap<String, Pais> getPaises() throws ServiceException{
        try{
            if (!coronaCache.getLista()){
                coronaCache.traerData(httpConnectionService.getAllCountries());
            }
            return coronaCache.getPaises();
        } catch (Exception e){
            throw new ServiceException("Error al consultar paises");
        }

    }

    public Pais getPais(String pais) throws ServiceException{
        try{
            return coronaCache.getPais(pais);
        } catch (Exception e){
            throw new ServiceException("Error al consultar pais");
        }
    }
}