package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.User;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.models.UserRequest;
import batchfour.teamtwo.renttrailservice.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseMessage<UserRequest> save(@RequestBody @Valid UserRequest model) {
        User entity = service.save(new User(model.getName(), model.getNik(), model.getNoHp(), model.getAddress(), model.getGender(), model.getPicture()));

        ModelMapper modelMapper = new ModelMapper();
        UserRequest data = modelMapper.map(entity, UserRequest.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<UserRequest> edit(@PathVariable Integer id,
                                             @RequestBody @Valid UserRequest userRequest) {

        ModelMapper modelMapper = new ModelMapper();

        userRequest.setId(id);
        User entity = service.finById(id);

        entity.setName(userRequest.getName());
        entity.setAddress(userRequest.getAddress());
        entity.setNik(userRequest.getNik());
        entity.setNoHp(userRequest.getNoHp());
        entity.setGender(userRequest.getGender());

        UserRequest data = modelMapper.map(entity, UserRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<UserRequest> findById(@PathVariable Integer id) {

        User entity = service.finById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserRequest data = modelMapper.map(entity, UserRequest.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<UserRequest> removeById(@PathVariable Integer id) {

        User entity = service.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        UserRequest model = modelMapper.map(entity, UserRequest.class);

        return ResponseMessage.success(model);
    }

    @GetMapping
    public ResponseMessage<PageableList<UserRequest>> findAll(
            @RequestParam(required = false) String name, String nik, String noHp, String address,
                                            String email, String gender,String picture,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }
        User entity = new User(name, nik, noHp, address,gender, picture);
        Sort.Direction direction = Sort.Direction
                                .fromOptionalString(sort.toUpperCase())
                                .orElse(Sort.Direction.ASC);

        Page<User> pageUser = service.findAll(entity,page,size, direction);
        List<User> users = pageUser.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<UserRequest>>() {
        }.getType();
        List<UserRequest> userRequests = modelMapper.map(users,type);
        PageableList<UserRequest> data = new PageableList(userRequests, pageUser.getNumber(), pageUser.getSize(), pageUser.getTotalPages());

        return ResponseMessage.success(data);


    }


}
