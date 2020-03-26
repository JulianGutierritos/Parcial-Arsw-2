package edu.eci.arsw.coronaAPI.persistence;

import java.util.HashMap;

import edu.eci.arsw.coronaAPI.model.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class CoronaCache {


    private boolean lista = false;
    private HashMap <String, Pais> paises = new HashMap<>();
    public void traerData(HttpResponse<JsonNode> response) {
        lista = false;
        try {
            JSONObject object;
            String pais;
            Provincia p;
            JSONArray a = (JSONArray) ((JSONObject) response.getBody().getObject().get("data")).get("covid19Stats");
			for (int i = 0; i < a.length(); i++) {
                object = a.getJSONObject(i);
                p = new Provincia((String) object.get("province"), (int) object.get("deaths"), (int) object.get("confirmed"), (int) object.get("recovered"));     
                pais = (String) object.get("country");
                if (paises.containsKey(pais)){
                    paises.get(pais).addProvincia(p);
                }
                else{
                    Pais paisO = new Pais(pais);
                    paisO.addProvincia(p);
                    paises.put(pais, paisO);
                }
            }
		} catch (JSONException e) {
			e.printStackTrace();
        } 
        lista = true; 
    }

    public HashMap<String, Pais> getPaises(){
        return this.paises;
    }

    public Pais getPais(String pais){
        if (paises.containsKey(pais)){
            return paises.get(pais);
        }
        else{
            return null;
        }
    }

    public boolean getLista(){
        return this.lista;
    }

}