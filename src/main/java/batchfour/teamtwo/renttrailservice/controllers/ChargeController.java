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

import batchfour.teamtwo.renttrailservice.entities.Charge;
import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.entities.User;
import batchfour.teamtwo.renttrailservice.models.ChargeModel;
import batchfour.teamtwo.renttrailservice.models.ChargeRequest;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.ChargeService;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import batchfour.teamtwo.renttrailservice.services.UserService;

@RequestMapping("charges")
@RestController
public class ChargeController {

    @Autowired
    private ChargeService chargeService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseMessage<ChargeModel> add(@RequestBody @Valid ChargeRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        Item item = itemService.findById(request.getItemId());
        User user = userService.finById(request.getUserId());
        
        Charge entity = chargeService.save(new Charge(request.getDescription(), request.getPrice(), user, item));

        ChargeModel data = modelMapper.map(entity, ChargeModel.class);
        return ResponseMessage.successAdd(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<ChargeModel> edit(@PathVariable Integer id, @RequestBody @Valid ChargeRequest request){
        ModelMapper modelMapper = new ModelMapper();

        Charge entity = chargeService.findById(id);

        entity.setDescription(request.getDescription());
        entity.setPrice(request.getPrice());
        entity.setUser(userService.finById(request.getUserId()));
        entity.setItem(itemService.findById(request.getItemId()));

        entity = chargeService.save(entity);

        ChargeModel data = modelMapper.map(entity, ChargeModel.class);
        return ResponseMessage.successEdit(data);        
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<ChargeModel> removeById(@PathVariable Integer id) {
        Charge entity = chargeService.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        ChargeModel data = modelMapper.map(entity, ChargeModel.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<ChargeModel> findById(@PathVariable Integer id) {
        Charge entity = chargeService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        ChargeModel data = modelMapper.map(entity, ChargeModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<ChargeModel>> findAll(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Item item,
            @RequestParam(required = false) User user,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }

        Charge entity = new Charge(description, price, user, item);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Charge> pageCharges = chargeService.findAll(entity, page, size, direction);
        List<Charge> items = pageCharges.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<ChargeModel>>() {
        }.getType();
        List<ChargeModel> itemModels = modelMapper.map(items, type);
        PageableList<ChargeModel> data = new PageableList(itemModels, pageCharges.getNumber(),
                pageCharges.getSize(), pageCharges.getTotalElements());

        return ResponseMessage.success(data);
    }


}