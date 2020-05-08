package batchfour.teamtwo.renttrailservice.controllers;


import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.models.PartnerRequest;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.models.UserRequest;
import batchfour.teamtwo.renttrailservice.services.AccountService;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import batchfour.teamtwo.renttrailservice.services.PartnerService;
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

@RequestMapping("/partners")
@RestController
@Validated
public class PartnerController {

    @Autowired
    private PartnerService service;

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseMessage<PartnerRequest> save(@RequestBody @Valid PartnerRequest model) {
        Account account = accountService.findById(model.getAccount().getId());

        Partner entity = service.save(new Partner(model.getOutlet(), model.getOwner() ,model.getTelp(), model.getAddress(),model.getPicture(), account));

        ModelMapper modelMapper = new ModelMapper();
        PartnerRequest data = modelMapper.map(entity, PartnerRequest.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<PartnerRequest> edit(@PathVariable Integer id,
                                                @RequestBody @Valid PartnerRequest model) {

        ModelMapper modelMapper = new ModelMapper();
        Account account = accountService.findById(model.getAccount().getId());
        model.setId(id);
        Partner entity = service.findById(id);

        entity.setOutlet(model.getOutlet());
        entity.setOwner(model.getOwner());
        entity.setAddress(model.getAddress());
        entity.setTelp(model.getTelp());
        entity.setPicture(model.getPicture());
        entity.setAccount(account);

        PartnerRequest data = modelMapper.map(entity, PartnerRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<PartnerRequest> findById(@PathVariable Integer id) {
        Partner entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        PartnerRequest data = modelMapper.map(entity, PartnerRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("account/{id}")
    public ResponseMessage<PartnerRequest> findByAccountId(@PathVariable Long id) {
        Account account = accountService.findById(id);

        Partner partner = service.findByAccount(account);
        ModelMapper modelMapper = new ModelMapper();

        PartnerRequest data = modelMapper.map(partner, PartnerRequest.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<PartnerRequest> removeById(@PathVariable Integer id) {

        Partner entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        PartnerRequest data = modelMapper.map(entity, PartnerRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<PartnerRequest>> findAll(
            @RequestParam(required = false) String outlet, String telp, String address,
            String picture, Account account, String owner,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size ) {

    if (size > 100 ) {
        size = 100;
    }

        Partner entity = new Partner(outlet, owner, telp,address, picture, account);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);

        Page<Partner> pageOutlet = service.findAll(entity,page,size, direction);
        List<Partner> partners = pageOutlet.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<PartnerRequest>>() {
        }.getType();
        List<PartnerRequest> partnerRequests = modelMapper.map(partners,type);
        PageableList<PartnerRequest> data = new PageableList(partnerRequests, pageOutlet.getNumber(), pageOutlet.getSize(), pageOutlet.getTotalPages());

        return ResponseMessage.success(data);

    }


}
