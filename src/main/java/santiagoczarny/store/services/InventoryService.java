package santiagoczarny.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santiagoczarny.store.entities.Inventory;
import santiagoczarny.store.repositories.InventoryRepository;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory save(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> findAll(){
        return inventoryRepository.findAll();
    }

    public void delete(Inventory inventory){
        inventoryRepository.delete(inventory);
    }

}
