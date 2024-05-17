package za.ac.cput.repository;

import za.ac.cput.domain.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepository implements IContactRepository{
    private static IContactRepository repository = null;
    private List<Contact> contactList;
    private ContactRepository(){ contactList = new ArrayList<Contact>();}

    public static IContactRepository getRepository(){
        if (repository == null){
            repository = new ContactRepository();
        }
        return repository;
    }

    @Override
    public Contact create(Contact contact) {
        boolean success = contactList.add(contact);
        if (success)
            return contact;
        return null;
    }

    @Override
    public Contact read(String id) {
        for (Contact c : contactList){
            if (c.getEmail().equals(id))
                return c;
        }
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        Contact contactOld = read(contact.getEmail());

        boolean success = contactList.remove(contactOld);
        if (success){
            if (contactList.add(contact))
                return contact;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Contact contactToDelete = read(id);
        boolean success = contactList.remove(contactToDelete);
        return success;
    }

    @Override
    public List<Contact> getAll() {
        return contactList;
    }
}
