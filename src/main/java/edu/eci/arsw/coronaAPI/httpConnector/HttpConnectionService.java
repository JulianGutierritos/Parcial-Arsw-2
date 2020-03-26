package edu.eci.arsw.coronaAPI.httpConnector;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

    public class HttpConnectionService {

        public HttpResponse<JsonNode> getAllCountries() throws UnirestException{
            HttpResponse<JsonNode> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                        .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                        .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8").asJson();
            return response;
        }

        public HttpResponse<JsonNode> getCountry() throws UnirestException {
            HttpResponse<JsonNode> response = Unirest
                    .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=China")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8").asJson();
            return response;
        }
        
    }
