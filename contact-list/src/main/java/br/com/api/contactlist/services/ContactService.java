package br.com.api.contactlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.contactlist.models.ContactModel;
import br.com.api.contactlist.models.ModelResponse;
import br.com.api.contactlist.repository.ContactRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository cr;

    @Autowired
    private ModelResponse mr;

    //List all contacts
    public Iterable<ContactModel> listar() {
        return cr.findAll();
    }

}
