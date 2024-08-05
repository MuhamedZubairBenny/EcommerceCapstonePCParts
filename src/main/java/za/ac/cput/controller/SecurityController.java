package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Security;
import za.ac.cput.service.SecurityService;

import java.util.List;
@RestController
@RequestMapping("/security")
public class SecurityController {
    @Autowired
    private SecurityService securityService;
    @PostMapping("/create")
    public Security create(@RequestBody Security security){
        return securityService.create(security);
    }

    @GetMapping("/read/{username}")
    public Security read(@PathVariable String username){
        return securityService.read(username);
    }

    @PostMapping("/update")
    public Security update(@RequestBody Security security){
        return securityService.update(security);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        securityService.delete(id);
    }

    @GetMapping("/getall")
    public List<Security> getall(){
        return securityService.getAll();
    }
}
