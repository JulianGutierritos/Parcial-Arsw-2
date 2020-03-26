package edu.eci.arsw.coronaAPI.services.impl;

import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimerTask;

import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.arsw.coronaAPI.services.CoronaServices;
import edu.eci.arsw.coronaAPI.exceptions.CacheException;
import edu.eci.arsw.coronaAPI.exceptions.ServiceException;
import edu.eci.arsw.coronaAPI.httpConnector.HttpConnectionService;
import edu.eci.arsw.coronaAPI.httpConnector.HttpCoordenateService;
import edu.eci.arsw.coronaAPI.model.*;
import edu.eci.arsw.coronaAPI.persistence.CoronaCache;

@Service
public class CoronaServicesImpl implements CoronaServices {

    @Autowired
    CoronaCache coronaCache;
    @Autowired
    HttpConnectionService httpConnectionService;
    @Autowired
    HttpCoordenateService httpCordenateService;

    public HashMap<String, Pais> getPaises() throws ServiceException {
        try {
            if ((!coronaCache.getLista()) || (LocalDateTime.now().isAfter(coronaCache.getUltimaEjecucion().plusMinutes(5)))) {
                coronaCache.traerData(httpConnectionService.getAllCountries());
            }
            return coronaCache.getPaises();
        } catch (Exception e) {
            throw new ServiceException("Error al consultar paises");
        }

    }

    public Pais getPais(String pais) throws ServiceException {
        try {
            return coronaCache.getPais(pais);
        } catch (Exception e) {
            throw new ServiceException("Error al consultar pais");
        }
    }

    public String getCoordenada(String pais) throws ServiceException {
        try {
            return coronaCache.getUbicacion(pais);
        } catch (CacheException e1) {
            try {
                coronaCache.putUbicacion(pais, httpCordenateService.getCoordenadas(pais));
                return httpCordenateService.getCoordenadas(pais);
            } catch (UnirestException e) {
                throw new ServiceException("Coordenada no encontrada");
            }
        }
    }
}