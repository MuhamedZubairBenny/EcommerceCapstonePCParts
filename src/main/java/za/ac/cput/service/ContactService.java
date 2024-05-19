package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService implements IContactService{
    private ContactRepository repository;

    @Autowired
    ContactService(ContactRepository repository){
        this.repository = repository;
    }

    @Override
    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public Contact read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        return repository.save(contact);
    }

    @Override
    public void delete(String id) {repository.deleteById(id);
    }

    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }
}
