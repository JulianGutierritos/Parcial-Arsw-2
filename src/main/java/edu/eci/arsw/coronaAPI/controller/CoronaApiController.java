package edu.eci.arsw.coronaAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;

import edu.eci.arsw.coronaAPI.exceptions.ServiceException;
import edu.eci.arsw.coronaAPI.services.CoronaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/treecore")
public class CoronaApiController {

    @Autowired
    CoronaServices coronaServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        try {
            return new ResponseEntity<>(this.coronaServices.getPaises(), HttpStatus.OK);
        } catch (ServiceException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
    }

}