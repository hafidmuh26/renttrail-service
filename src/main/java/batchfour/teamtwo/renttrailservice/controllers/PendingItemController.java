package batchfour.teamtwo.renttrailservice.controllers;


import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.entities.PendingItem;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.PendingItemRequest;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.PartnerService;
import batchfour.teamtwo.renttrailservice.services.PendingItemService;
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
    private PendingItemService service;

    @Autowired
    private PartnerService partnerService;

    @PostMapping
    public ResponseMessage<PendingItemRequest> save(@RequestBody @Valid PendingItemRequest model) {

        Partner partner = partnerService.findById(model.getPartner());

        PendingItem entity = new PendingItem(model.getName(), model.getQuantity(), model.getAge(),
                                             model.getStatus(), model.getDescription(), partner);
        service.save(entity);

        ModelMapper modelMapper = new ModelMapper();
        PendingItemRequest data = modelMapper.map(entity, PendingItemRequest.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<PendingItemRequest> edit(@PathVariable Integer id, @RequestBody @Valid PendingItemRequest model) {

        ModelMapper modelMapper = new ModelMapper();

        PendingItem entity = service.findById(id);

        entity.setName(model.getName());
        entity.setQuantity(model.getQuantity());
        entity.setAge(model.getAge());
        entity.setStatus(model.getStatus());
        entity.setDescription(model.getDescription());
        entity.setPartner(partnerService.findById(model.getPartner()));
        entity = service.save(entity);

        PendingItemRequest data = modelMapper.map(entity, PendingItemRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<PendingItemRequest> findById(@PathVariable Integer id) {

        PendingItem entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        PendingItemRequest data = modelMapper.map(entity, PendingItemRequest.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<PendingItemRequest> removeById(@PathVariable Integer id) {
        PendingItem entity = service.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        PendingItemRequest data = modelMapper.map(entity, PendingItemRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<PendingItemRequest>> findAll(
            @RequestParam(required = false) String name, Integer quantity, String age,
                                            String status, String description, Partner partner,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {

        if (size > 100) {
            size = 100;
        }

        PendingItem entity = new PendingItem(name, quantity, age, status, description, partner);

        Sort.Direction direction = Sort.Direction.fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<PendingItem> pagePendingItem = service.findAll(entity, page, size, direction);
        List<PendingItem> pendingItems = pagePendingItem.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<PendingItemRequest>>() {
        }.getType();

        List<PendingItemRequest> models = modelMapper.map(pendingItems, type);
        PageableList<PendingItemRequest> data = new PageableList<>(models,pagePendingItem.getNumber(),
                                            pagePendingItem.getSize(), pagePendingItem.getTotalElements());

        return ResponseMessage.success(data);
    }


}
