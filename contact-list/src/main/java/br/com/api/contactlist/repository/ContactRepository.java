package br.com.api.contactlist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.contactlist.models.ContactModel;

@Repository
public interface ContactRepository extends CrudRepository<ContactModel, String>{

}
