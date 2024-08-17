package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Brand;
import za.ac.cput.service.BrandService;

import java.util.List;

@RestController
@RequestMapping("api/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    public Brand create(@RequestBody Brand brand){return brandService.create(brand);}

    @PostMapping("/read/{id}")
    public Brand read(@PathVariable String brandId){return brandService.read(brandId);}

   @PostMapping("/update")
   public Brand update(@RequestBody Brand brand){return brandService.update(brand);}

   @DeleteMapping("/detele/{id}")
    public void delete(@PathVariable String brandId){brandService.delete(brandId);}

    @GetMapping("/getAll")
    public List<Brand> getAll(){return brandService.getAll();}
}
