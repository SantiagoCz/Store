package santiagoczarny.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santiagoczarny.store.entities.Person;
import santiagoczarny.store.entities.Product;
import santiagoczarny.store.entities.Status;
import santiagoczarny.store.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void delete(Product product){
        productRepository.delete(product);
    }

    public void deactivate(Product product) {
        product.setStatus(Status.INACTIVE);
        save(product);
    }

}
