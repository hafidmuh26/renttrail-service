package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.models.ItemRequest;
import batchfour.teamtwo.renttrailservice.models.ItemSummaryRequest;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import batchfour.teamtwo.renttrailservice.services.ItemSummaryService;
import batchfour.teamtwo.renttrailservice.services.PartnerService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private ItemSummaryService summaryService;

    @PostMapping
    public ResponseMessage<ItemRequest> add(@RequestBody @Valid ItemRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        Partner partner = partnerService.findById(request.getPartner().getId());

        Item entity = itemService.save(new Item(request.getName(), request.getPrice(), request.getBrand(),
                request.getVariety(), request.getPicture(), partner));

        ItemRequest data = modelMapper.map(entity, ItemRequest.class);
        return ResponseMessage.successAdd(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ItemRequest> edit(@PathVariable Integer id, @RequestBody @Valid ItemRequest request){
        ModelMapper modelMapper = new ModelMapper();

        Item entity = itemService.findById(id);

        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setBrand(request.getBrand());
        entity.setVariety(request.getVariety());
        entity.setPicture(request.getPicture());
        entity.setPartner(partnerService.findById(request.getPartner().getId()));

        entity = itemService.save(entity);

        ItemRequest data = modelMapper.map(entity, ItemRequest.class);
        return ResponseMessage.successEdit(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<ItemRequest> removeById(@PathVariable Integer id) {
        Item entity = itemService.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        ItemRequest data = modelMapper.map(entity, ItemRequest.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ItemRequest> findById(@PathVariable Integer id) {
        Item entity = itemService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        ItemRequest data = modelMapper.map(entity, ItemRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<ItemRequest>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String variety,
            @RequestParam(required = false) String picture,
            @RequestParam(required = false) Integer partner,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }

        Partner partnerEntity = new Partner();
        if(partner != null ) {
            partnerEntity = partnerService.findById(partner);
        }

        Item entity = new Item(name, price, brand, variety, picture, partnerEntity);
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

    @GetMapping("/summary")
    public ResponseMessage<List<ItemSummaryRequest>> itemSummary() throws SQLException {
        List<ItemSummaryRequest> entities = summaryService.itemSummary();

        return ResponseMessage.success(entities);
    }

}
