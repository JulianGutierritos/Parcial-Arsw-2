package edu.eci.arsw.coronaAPI.persistence;

import java.util.HashMap;
import edu.eci.arsw.coronaAPI.exceptions.CacheException;
import edu.eci.arsw.coronaAPI.model.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.json.JSONArray;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

@Component
public class CoronaCache {
    

    private boolean lista = false;
    private HashMap<String, Pais> paises = new HashMap<>();
    private HashMap<String, String> ubicaciones = new HashMap<>();

    public void traerData(HttpResponse<JsonNode> response) throws CacheException {
        try {
            JSONObject object;
            String pais;
            Provincia p;
            JSONArray a = (JSONArray) ((JSONObject) response.getBody().getObject().get("data")).get("covid19Stats");
            for (int i = 0; i < a.length(); i++) {
                object = a.getJSONObject(i);
                p = new Provincia((String) object.get("province"), (int) object.get("deaths"),
                        (int) object.get("confirmed"), (int) object.get("recovered"));
                pais = (String) object.get("country");
                if (paises.containsKey(pais)) {
                    paises.get(pais).addProvincia(p);
                } else {
                    Pais paisO = new Pais(pais);
                    paisO.addProvincia(p);
                    paises.put(pais, paisO);
                }
            }
        } catch (JSONException e) {
            throw new CacheException("Error al cargar data");
        } 
        lista = true; 
    }

    public HashMap<String, Pais> getPaises() throws CacheException{
        return this.paises;
    }

    public Pais getPais(String pais)  throws CacheException{
        if (paises.containsKey(pais)){
            return paises.get(pais);
        }
        else{
            throw new CacheException("Pais no existente");
        }
    }

    public String getUbicacion(String pais) throws CacheException{
        if (ubicaciones.containsKey(pais)){
            return ubicaciones.get(pais);
        }
        else{
            throw new CacheException("No existe ubicación");
        }
    }
    public void putUbicacion(String pais, String u){
        ubicaciones.put(pais, u);
    }

    public boolean getLista(){
        return this.lista;
    }

}