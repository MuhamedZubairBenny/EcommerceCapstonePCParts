//package za.ac.cput.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import za.ac.cput.domain.Delivery;
//import za.ac.cput.repository.DeliveryRepository;
//import java.util.List;
//@Service
//public class DeliveryService implements IDeliveryService {
//    private DeliveryRepository repository;
//
//    @Autowired
//    DeliveryService(DeliveryRepository repository){
//        this.repository = repository;
//    }
//
//    @Override
//    public Delivery create(Delivery delivery){
//        return repository.save(delivery);
//    }
//
//    @Override
//    public Delivery read(String id){
//        return repository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Delivery update(Delivery delivery){
//        return repository.save(delivery);
//    }
//
//    @Override
//    public void delete(String id) { repository.deleteById(id);}
//
//    @Override
//    public List<Delivery> getAll(){
//        return repository.findAll();
//    }
//}
