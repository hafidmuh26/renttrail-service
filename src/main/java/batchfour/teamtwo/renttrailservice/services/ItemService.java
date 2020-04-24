package batchfour.teamtwo.renttrailservice.services;

import batchfour.teamtwo.renttrailservice.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface ItemService {

    public Item save(Item entity);

    public Item removeById(Integer id);

    public Item findById(Integer id);

    public Page<Item> findAll(Item entity, int page, int size, Sort.Direction direction);

}
