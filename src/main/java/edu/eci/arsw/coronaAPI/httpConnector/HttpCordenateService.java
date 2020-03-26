package edu.eci.arsw.coronaAPI.httpConnector;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.stereotype.Service;

@Service
public class HttpCordenateService {

    public String getCoordenadas(String pais) throws UnirestException{
        HttpResponse<String> response = Unirest
            .get("https://restcountries-v1.p.rapidapi.com/name/"+ pais)
            .header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
            .header("x-rapidapi-key", "4a71d98902mshebb28f37a4e303ep14be52jsn5e65fb31a9e2")
            .asString();
            return response.getBody();
    }
}
