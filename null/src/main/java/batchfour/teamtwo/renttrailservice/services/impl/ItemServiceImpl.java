package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.repositories.ItemRepository;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends EntityServiceImpl<Item, Integer> implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    protected JpaRepository<Item, Integer> getRepository() {
        return itemRepository;
    }

}
