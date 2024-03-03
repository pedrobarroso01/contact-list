package br.com.api.contactlist.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.api.contactlist.models.ContactModel;
import br.com.api.contactlist.models.ModelResponse;
import br.com.api.contactlist.services.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ContactController {

    @Autowired
    private ContactService cs;

    @RequestMapping(path = "/listar", method=RequestMethod.GET)
    public Iterable<ContactModel> listar() {
        return cs.listar();
    }
    
    @RequestMapping(path = "/cadastrar", method=RequestMethod.POST)
    public ResponseEntity<?> cadastrar(@RequestBody ContactModel cm) {
        return cs.cadastrarAlterar(cm, "cadastrar");
    }
    
    @RequestMapping(path = "/alterar", method=RequestMethod.PUT)
    public ResponseEntity<?> alterar(@RequestBody ContactModel cm) {
        return cs.cadastrarAlterar(cm, "alterar");
    }
    
    @RequestMapping(path = "/remover", method=RequestMethod.DELETE)
    public ResponseEntity<ModelResponse> excluir(@RequestParam(name = "id")String codigo) {
        return cs.remover(codigo);
    }
    


}
