package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Security;
import za.ac.cput.repository.SecurityRepository;

import java.util.List;

@Service
public class SecurityService implements ISecurityService {
    private final SecurityRepository repository;
    @Autowired
    SecurityService(SecurityRepository repository){this.repository = repository;}
    @Override
    public Security create(Security security){ return repository.save(security);}
    @Override
    public Security read(String username){ return repository.findByUsername(username);}
    @Override
    public void delete(String id) {repository.deleteById(id);
    }
    @Override
    public Security update(Security security){return repository.save(security);}

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Security> getAll() {
        return repository.findAll();
    }
}
