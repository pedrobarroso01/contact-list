package br.com.api.contactlist.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.contactlist.models.ContactModel;
import br.com.api.contactlist.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@RestController
public class ContactController {

    @Autowired
    private ContactService cs;

    @RequestMapping(path = "/listar", method=RequestMethod.GET)
    public Iterable<ContactModel> listar() {
        return cs.listar();
    }
    
    
    


}
