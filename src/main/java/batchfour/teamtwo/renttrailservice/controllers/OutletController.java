package batchfour.teamtwo.renttrailservice.controllers;


import batchfour.teamtwo.renttrailservice.entities.Outlet;
import batchfour.teamtwo.renttrailservice.models.OutletModel;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.OutletService;
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

@RequestMapping("/outlets")
@RestController
@Validated
public class OutletController {

    @Autowired
    private OutletService service;

    @PostMapping
    public ResponseMessage<OutletModel> save(@RequestBody @Valid OutletModel model) {
        Outlet entity = service.save(new Outlet(model.getName(), model.getTelp(), model.getAddress()));

        ModelMapper modelMapper = new ModelMapper();
        OutletModel data = modelMapper.map(entity, OutletModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<OutletModel> edit(@PathVariable Integer id,
                                             @RequestBody @Valid OutletModel model) {

        ModelMapper modelMapper = new ModelMapper();

        model.setId(id);
        Outlet entity = service.findById(id);

        entity.setName(model.getName());
        entity.setAddress(model.getAddress());
        entity.setTelp(model.getTelp());

        OutletModel data = modelMapper.map(entity, OutletModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<OutletModel> findById(@PathVariable Integer id) {
        Outlet entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        OutletModel data = modelMapper.map(entity, OutletModel.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<OutletModel> removeById(@PathVariable Integer id) {

        Outlet entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        OutletModel data = modelMapper.map(entity, OutletModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<OutletModel>> findAll(
            @RequestParam(required = false) String name, String telp, String address,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size ) {

    if (size > 100 ) {
        size = 100;
    }

        Outlet entity = new Outlet(name, telp,address);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);

        Page<Outlet> pageOutlet = service.findAll(entity,page,size, direction);
        List<Outlet> outlets = pageOutlet.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<OutletModel>>() {
        }.getType();
        List<OutletModel> outletModels = modelMapper.map(outlets,type);
        PageableList<OutletModel> data = new PageableList(outletModels, pageOutlet.getNumber(), pageOutlet.getSize(), pageOutlet.getTotalPages());

        return ResponseMessage.success(data);

    }


}
