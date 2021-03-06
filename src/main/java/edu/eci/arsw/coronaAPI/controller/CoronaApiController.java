package edu.eci.arsw.coronaAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.arsw.coronaAPI.exceptions.ServiceException;
import edu.eci.arsw.coronaAPI.services.CoronaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/CoronaVirus")
public class CoronaApiController {

    @Autowired
    CoronaServices coronaServices;

    @RequestMapping(path = "/countries", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(this.coronaServices.getPaises(), HttpStatus.OK);
        } catch (ServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }

    @RequestMapping(path = "/countries/{pais}", method = RequestMethod.GET)
    public ResponseEntity<?> getOne(@PathVariable("pais") String pais) {
        try {
            return new ResponseEntity<>(this.coronaServices.getPais(pais), HttpStatus.OK);
        } catch (ServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }

    @RequestMapping(path = "/countries/{pais}/coordinate", method = RequestMethod.GET)
    public ResponseEntity<?> getCoordenada(@PathVariable("pais") String pais){
        try {
            return new ResponseEntity<>(this.coronaServices.getCoordenada(pais), HttpStatus.OK);
        } catch (ServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }
}