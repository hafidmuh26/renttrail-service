package batchfour.teamtwo.renttrailservice.controllers;


import batchfour.teamtwo.renttrailservice.entities.*;
import batchfour.teamtwo.renttrailservice.models.*;
import batchfour.teamtwo.renttrailservice.services.PartnerService;
import batchfour.teamtwo.renttrailservice.services.PendingItemService;
import batchfour.teamtwo.renttrailservice.services.VarietyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RequestMapping("/pendings")
@RestController
@Validated
public class PendingItemController {

    @Autowired
    private PendingItemService pendingItemService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private VarietyService varietyService;

    @PostMapping
    public ResponseMessage<PendingItemRequest> add(@RequestBody @Valid PendingItemRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        Partner partner = partnerService.findById(request.getPartner().getId());
        Variety variety = varietyService.findById(request.getVariety().getId());

        PendingItem entity = pendingItemService.save(new PendingItem(request.getName(), request.getBrand(),
                request.getAge(), request.getPrice(), StatusItem.fromValue(request.getStatus()), request.getPicture(),
                partner, variety));

        PendingItemRequest data = modelMapper.map(entity, PendingItemRequest.class);
        return ResponseMessage.successAdd(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<PendingItemRequest> edit(@PathVariable Integer id, @RequestBody @Valid PendingItemRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        PendingItem entity = pendingItemService.findById(id);

        entity.setName(request.getName());
        entity.setBrand(request.getBrand());
        entity.setAge(request.getAge());
        entity.setPrice(request.getPrice());
        entity.setStatus(StatusItem.fromValue(request.getStatus()));
        entity.setPicture(request.getPicture());
        entity.setPartner(partnerService.findById(request.getPartner().getId()));
        entity.setVariety(varietyService.findById(request.getVariety().getId()));

        entity = pendingItemService.save(entity);

        PendingItemRequest data = modelMapper.map(entity, PendingItemRequest.class);
        return ResponseMessage.successEdit(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<PendingItemRequest> removeById(@PathVariable Integer id) {
        PendingItem entity = pendingItemService.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        PendingItemRequest data = modelMapper.map(entity, PendingItemRequest.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<PendingItemRequest> findById(@PathVariable Integer id) {
        PendingItem entity = pendingItemService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        PendingItemRequest data = modelMapper.map(entity, PendingItemRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<PendingItemRequest>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) StatusItem status,
            @RequestParam(required = false) String picture,
            @RequestParam(required = false) Partner partner,
            @RequestParam(required = false) Variety variety,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }

        PendingItem entity = new PendingItem(name, brand, age, price, status, picture, partner, variety);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<PendingItem> pagePendingItems = pendingItemService.findAll(entity, page, size, direction);
        List<PendingItem> items = pagePendingItems.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<PendingItemRequest>>() {
        }.getType();
        List<PendingItemRequest> itemModels = modelMapper.map(items, type);
        PageableList<PendingItemRequest> data = new PageableList(itemModels, pagePendingItems.getNumber(),
                pagePendingItems.getSize(), pagePendingItems.getTotalElements());

        return ResponseMessage.success(data);
    }


}
