package batchfour.teamtwo.renttrailservice.controllers;

import batchfour.teamtwo.renttrailservice.entities.User;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.models.UserModel;
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
    public ResponseMessage<UserModel> save(@RequestBody @Valid UserModel model) {
        User entity = service.save(new User(model.getName(), model.getNik(), model.getNoHp(), model.getAddress(), model.getGender()));

        ModelMapper modelMapper = new ModelMapper();
        UserModel data = modelMapper.map(entity, UserModel.class);

        return ResponseMessage.success(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<UserModel> edit(@PathVariable Integer id,
                                           @RequestBody @Valid UserModel userModel) {

        ModelMapper modelMapper = new ModelMapper();

        userModel.setId(id);
        User entity = service.finById(id);

        entity.setName(userModel.getName());
        entity.setAddress(userModel.getAddress());
        entity.setNik(userModel.getNik());
        entity.setNoHp(userModel.getNoHp());
        entity.setGender(userModel.getGender());

        UserModel data = modelMapper.map(entity, UserModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<UserModel> findById(@PathVariable Integer id) {

        User entity = service.finById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserModel data = modelMapper.map(entity, UserModel.class);

        return ResponseMessage.success(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<UserModel> removeById(@PathVariable Integer id) {

        User entity = service.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        UserModel model = modelMapper.map(entity, UserModel.class);

        return ResponseMessage.success(model);
    }

    @GetMapping
    public ResponseMessage<PageableList<UserModel>> findAll(
            @RequestParam(required = false) String name, String nik, String noHp, String address, String email, String gender,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }
        User entity = new User(name, nik, noHp, address,gender);
        Sort.Direction direction = Sort.Direction
                                .fromOptionalString(sort.toUpperCase())
                                .orElse(Sort.Direction.ASC);

        Page<User> pageUser = service.findAll(entity,page,size, direction);
        List<User> users = pageUser.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<UserModel>>() {
        }.getType();
        List<UserModel> userModels = modelMapper.map(users,type);
        PageableList<UserModel> data = new PageableList(userModels, pageUser.getNumber(), pageUser.getSize(), pageUser.getTotalPages());

        return ResponseMessage.success(data);


    }


}
