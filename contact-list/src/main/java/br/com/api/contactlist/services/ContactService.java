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

    //Register and alter contacts
    public ResponseEntity<?> cadastrarAlterar(ContactModel cm, String action){
        if (cm.getFirstname() == ""  || cm.getLastname() == "") {
            mr.setMensagem("Por favor, digite um nome completo!");
            return new ResponseEntity<ModelResponse>(mr,HttpStatus.BAD_REQUEST);
        }
        else if (cm.getPhone() == "") {
            mr.setMensagem("Por favor, digite um número válido!");
            return new ResponseEntity<ModelResponse>(mr,HttpStatus.BAD_REQUEST);
        }else {
            if (action == "cadastrar"){
            return new ResponseEntity<ContactModel>(cr.save(cm),HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<ContactModel>(cr.save(cm),HttpStatus.OK);
            }
        }
    }

    //Remove products



}

    