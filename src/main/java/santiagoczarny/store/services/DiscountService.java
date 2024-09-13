package santiagoczarny.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santiagoczarny.store.entities.Discount;
import santiagoczarny.store.repositories.DiscountRepository;

import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public Discount save(Discount discount){
        return discountRepository.save(discount);
    }

    public List<Discount> findAll(){
        return discountRepository.findAll();
    }

    public void delete(Discount discount){
        discountRepository.delete(discount);
    }

}
