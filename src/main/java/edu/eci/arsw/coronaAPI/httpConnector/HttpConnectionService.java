package edu.eci.arsw.coronaAPI.httpConnector;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.stereotype.Service;

@Service
public interface HttpConnectionService {
    public HttpResponse<JsonNode> getAllCountries() throws UnirestException;

    public HttpResponse<JsonNode> getCountry(String pais) throws UnirestException;
}
