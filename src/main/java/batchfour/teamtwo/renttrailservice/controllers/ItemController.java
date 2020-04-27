package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.models.ItemRequest;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping
    public ResponseMessage<ItemRequest> add(@RequestBody @Valid ItemRequest model) {
        Item entity = service.save(new Item(model.getName(), model.getDescription(), model.getQuantity(), model.getPicture()));

        ModelMapper modelMapper = new ModelMapper();
        ItemRequest data = modelMapper.map(entity, ItemRequest.class);
        return ResponseMessage.successAdd(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<ItemRequest> removeById(@PathVariable Integer id) {
        Item entity = service.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        ItemRequest data = modelMapper.map(entity, ItemRequest.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ItemRequest> findById(@PathVariable Integer id) {
        Item entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        ItemRequest data = modelMapper.map(entity, ItemRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<ItemRequest>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) String picture,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }
        Item entity = new Item(name, description, quantity, picture);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Item> pageItems = service.findAll(entity, page, size, direction);
        List<Item> items = pageItems.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<ItemRequest>>() {
        }.getType();
        List<ItemRequest> itemRequests = modelMapper.map(items, type);
        PageableList<ItemRequest> data = new PageableList(itemRequests, pageItems.getNumber(),
                pageItems.getSize(), pageItems.getTotalElements());

        return ResponseMessage.success(data);
    }


}
