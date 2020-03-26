package edu.eci.arsw.coronaAPI.httpConnector;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public interface HttpCoordenateService {

    public String getCoordenadas(String pais) throws UnirestException;
}