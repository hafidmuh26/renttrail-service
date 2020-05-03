package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.Brand;
import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.entities.Variety;
import batchfour.teamtwo.renttrailservice.models.ItemModel;
import batchfour.teamtwo.renttrailservice.models.ItemRequest;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.BrandService;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import batchfour.teamtwo.renttrailservice.services.VarietyService;

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
    private ItemService itemService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private VarietyService varietyService;

    @PostMapping
    public ResponseMessage<ItemModel> add(@RequestBody @Valid ItemRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        Brand brand = brandService.findById(request.getBrandId());
        Variety variety = varietyService.findById(request.getVarietyId());
    
        Item entity = itemService.save(new Item(request.getName(), request.getPrice(), brand, variety, request.getPicture()));

        ItemModel data = modelMapper.map(entity, ItemModel.class);
        return ResponseMessage.successAdd(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ItemModel> edit(@PathVariable Integer id, @RequestBody @Valid ItemRequest request){
        ModelMapper modelMapper = new ModelMapper();

        Item entity = itemService.findById(id);

        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setPicture(request.getPicture());
        entity.setBrand(brandService.findById(request.getBrandId()));
        entity.setVariety(varietyService.findById(request.getVarietyId()));

        entity = itemService.save(entity);

        ItemModel data = modelMapper.map(entity, ItemModel.class);
        return ResponseMessage.successEdit(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<ItemModel> removeById(@PathVariable Integer id) {
        Item entity = itemService.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        ItemModel data = modelMapper.map(entity, ItemModel.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ItemModel> findById(@PathVariable Integer id) {
        Item entity = itemService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        ItemModel data = modelMapper.map(entity, ItemModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<ItemRequest>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Brand brand,
            @RequestParam(required = false) Variety variety,
            @RequestParam(required = false) String picture,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }

        Item entity = new Item(name, price, brand, variety, picture);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Item> pageItems = itemService.findAll(entity, page, size, direction);
        List<Item> items = pageItems.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<ItemRequest>>() {
        }.getType();
        List<ItemRequest> itemModels = modelMapper.map(items, type);
        PageableList<ItemRequest> data = new PageableList(itemModels, pageItems.getNumber(),
                pageItems.getSize(), pageItems.getTotalElements());

        return ResponseMessage.success(data);
    }

}
