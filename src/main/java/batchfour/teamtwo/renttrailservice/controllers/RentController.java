package batchfour.teamtwo.renttrailservice.controllers;


import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.entities.Rent;
import batchfour.teamtwo.renttrailservice.entities.User;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.RentModel;
import batchfour.teamtwo.renttrailservice.models.RentRequest;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import batchfour.teamtwo.renttrailservice.services.RentService;
import batchfour.teamtwo.renttrailservice.services.UserService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/rents")
@RestController
public class RentController {

    @Autowired
    RentService rentService;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseMessage<RentModel> add(@RequestBody @Valid RentRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        Item item = itemService.findById(request.getItemId());
        User user = userService.finById(request.getUserId());

        Rent entity = rentService.save(new Rent(request.getTotalRent(), request.getTotalPrice(), 
        request.getDateStart(), request.getDateEnd(), item, user));

        RentModel data = modelMapper.map(entity, RentModel.class);
        return ResponseMessage.successAdd(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<RentModel> edit(@PathVariable Integer id, @RequestBody @Valid RentRequest request){
        ModelMapper modelMapper = new ModelMapper();

        Rent entity = rentService.findById(id);

        entity.setTotalRent(request.getTotalRent());
        entity.setTotalPrice(request.getTotalPrice());
        entity.setDateStart(request.getDateStart());
        entity.setDateEnd(request.getDateEnd());
        entity.setItem(itemService.findById(request.getItemId()));
        entity.setUser(userService.finById(request.getUserId()));

        entity = rentService.save(entity);

        RentModel data = modelMapper.map(entity, RentModel.class);
        return ResponseMessage.successEdit(data);        
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<RentModel> removeById(@PathVariable Integer id) {
        ModelMapper modelMapper = new ModelMapper();

        Rent entity = rentService.removeById(id);

        RentModel data = modelMapper.map(entity, RentModel.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<RentModel> findById(@PathVariable Integer id) {
        Rent entity = rentService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        RentModel data = modelMapper.map(entity, RentModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<RentModel>> findAll(
            @RequestParam(required = false) Integer totalRent,
            @RequestParam(required = false) Integer totalPrice,
            @RequestParam(required = false) LocalDate dateStart,
            @RequestParam(required = false) LocalDate dateEnd,
            @RequestParam(required = false) Item item,
            @RequestParam(required = false) User user,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }
        Rent entity = new Rent(totalRent, totalPrice, dateStart, dateEnd, item, user);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Rent> pageRents = rentService.findAll(entity, page, size, direction);
        List<Rent> rents = pageRents.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<RentModel>>() {
        }.getType();
        List<RentModel> rentModels = modelMapper.map(rents, type);
        PageableList<RentModel> data = new PageableList(rentModels, pageRents.getNumber(),
                pageRents.getSize(), pageRents.getTotalElements());

        return ResponseMessage.success(data);
    }
}
