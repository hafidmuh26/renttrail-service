// package batchfour.teamtwo.renttrailservice.controllers;


// import batchfour.teamtwo.renttrailservice.entities.Item;
// import batchfour.teamtwo.renttrailservice.entities.Rent;
// import batchfour.teamtwo.renttrailservice.models.PageableList;
// import batchfour.teamtwo.renttrailservice.models.RentModel;
// import batchfour.teamtwo.renttrailservice.models.RentRequest;
// import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
// import batchfour.teamtwo.renttrailservice.services.ItemService;
// import batchfour.teamtwo.renttrailservice.services.RentService;
// import org.modelmapper.ModelMapper;
// import org.modelmapper.TypeToken;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Sort;
// import org.springframework.web.bind.annotation.*;

// import javax.validation.Valid;
// import java.lang.reflect.Type;
// import java.util.List;

// @RequestMapping("/rents")
// @RestController
// public class RentController {

//     @Autowired
//     RentService rentService;

//     @Autowired
//     ItemService itemService;

//     @PostMapping
//     public ResponseMessage<RentModel> add(@RequestBody @Valid RentRequest model) {
//         ModelMapper modelMapper = new ModelMapper();

//         Item item = itemService.findById(model.getItemId());

//         Rent entity = rentService.save(new Rent(item, model.getPrice(), model.getTotalPrice(), model.getStatus()));

//         RentModel data = modelMapper.map(entity, RentModel.class);
//         return ResponseMessage.successAdd(data);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseMessage<RentModel> removeById(@PathVariable Integer id) {
//         Rent entity = rentService.removeById(id);

//         ModelMapper modelMapper = new ModelMapper();
//         RentModel data = modelMapper.map(entity, RentModel.class);

//         return ResponseMessage.successDelete(data);
//     }

//     @GetMapping("/{id}")
//     public ResponseMessage<RentModel> findById(@PathVariable Integer id) {
//         Rent entity = rentService.findById(id);

//         ModelMapper modelMapper = new ModelMapper();
//         RentModel data = modelMapper.map(entity, RentModel.class);

//         return ResponseMessage.success(data);
//     }

//     @GetMapping
//     public ResponseMessage<PageableList<RentModel>> findAll(
//             @RequestParam(required = false) Item item,
//             @RequestParam(required = false) Integer price,
//             @RequestParam(required = false) Integer totalPrice,
//             @RequestParam(required = false) String status,
//             @RequestParam(defaultValue = "asc") String sort,
//             @RequestParam(defaultValue = "0") int page,
//             @RequestParam(defaultValue = "10") int size
//     ) {
//         if (size > 100) {
//             size = 100;
//         }
//         Rent entity = new Rent(item, price, totalPrice, status);
//         Sort.Direction direction = Sort.Direction
//                 .fromOptionalString(sort.toUpperCase())
//                 .orElse(Sort.Direction.ASC);
//         Page<Rent> pageRents = rentService.findAll(entity, page, size, direction);
//         List<Rent> items = pageRents.toList();

//         ModelMapper modelMapper = new ModelMapper();
//         Type type = new TypeToken<List<RentModel>>() {
//         }.getType();
//         List<RentModel> itemModels = modelMapper.map(items, type);
//         PageableList<RentModel> data = new PageableList(itemModels, pageRents.getNumber(),
//                 pageRents.getSize(), pageRents.getTotalElements());

//         return ResponseMessage.success(data);
//     }
// }
