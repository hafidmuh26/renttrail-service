package batchfour.teamtwo.renttrailservice.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import batchfour.teamtwo.renttrailservice.entities.Variety;
import batchfour.teamtwo.renttrailservice.models.ExtraItemRequest;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.VarietyService;

@RequestMapping("/varieties")
@RestController
public class VarietyController {

    @Autowired
    private VarietyService service;

    @PostMapping
    public ResponseMessage<ExtraItemRequest> add(@RequestBody @Valid ExtraItemRequest request) {
        Variety entity = service.save(new Variety(request.getName()));

        ModelMapper modelMapper = new ModelMapper();
        ExtraItemRequest data = modelMapper.map(entity, ExtraItemRequest.class);
        return ResponseMessage.successAdd(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ExtraItemRequest> edit(@PathVariable Integer id,
            @RequestBody @Valid ExtraItemRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        request.setId(id);
        Variety entity = service.findById(id);
        modelMapper.map(request, entity);

        entity = service.save(entity);

        ExtraItemRequest data = modelMapper.map(entity, ExtraItemRequest.class);
        return ResponseMessage.successEdit(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<ExtraItemRequest> removeById(@PathVariable Integer id) {
        Variety entity = service.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        ExtraItemRequest data = modelMapper.map(entity, ExtraItemRequest.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ExtraItemRequest> findById(@PathVariable Integer id) {
        Variety entity = service.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        ExtraItemRequest data = modelMapper.map(entity, ExtraItemRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<ExtraItemRequest>> findAll(@RequestParam(required = false) String name,
            @RequestParam(defaultValue = "asc") String sort, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        if (size > 100) {
            size = 100;
        }
        Variety entity = new Variety(name);
        Sort.Direction direction = Sort.Direction.fromOptionalString(sort.toUpperCase()).orElse(Sort.Direction.ASC);
        Page<Variety> pageVarietys = service.findAll(entity, page, size, direction);
        List<Variety> brands = pageVarietys.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<ExtraItemRequest>>() {
        }.getType();
        List<ExtraItemRequest> brandModels = modelMapper.map(brands, type);
        PageableList<ExtraItemRequest> data = new PageableList(brandModels, pageVarietys.getNumber(),
                pageVarietys.getSize(), pageVarietys.getTotalElements());

        return ResponseMessage.success(data);
    }

}