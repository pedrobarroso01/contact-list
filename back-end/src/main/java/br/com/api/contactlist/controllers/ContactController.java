package br.com.api.contactlist.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.contactlist.models.ContactModel;
import br.com.api.contactlist.models.ModelResponse;
import br.com.api.contactlist.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService cs;

    @RequestMapping(path = "/list", method=RequestMethod.GET)
    public Iterable<ContactModel> listar() {
        return cs.listar();
    }
    
    @RequestMapping(path = "/create", method=RequestMethod.POST)
    public ResponseEntity<?> cadastrar(@RequestBody ContactModel cm) {
        return cs.cadastrarAlterar(cm, "cadastrar");
    }
    
    @RequestMapping(path = "/alter", method=RequestMethod.PUT)
    public ResponseEntity<?> alterar(@RequestBody ContactModel cm) {
        return cs.cadastrarAlterar(cm, "alterar");
    }
    
    @RequestMapping(path = "/remove", method=RequestMethod.DELETE)
    public ResponseEntity<ModelResponse> excluir(@RequestParam(name = "id")Long codigo) {
        return cs.remover(codigo);
    }
    


}
