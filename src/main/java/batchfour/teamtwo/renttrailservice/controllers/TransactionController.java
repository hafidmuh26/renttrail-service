 package batchfour.teamtwo.renttrailservice.controllers;

 import batchfour.teamtwo.renttrailservice.entities.*;
 import batchfour.teamtwo.renttrailservice.models.*;
 import org.modelmapper.ModelMapper;
 import org.modelmapper.TypeToken;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Sort;
 import org.springframework.web.bind.annotation.*;

 import batchfour.teamtwo.renttrailservice.services.RentService;
 import batchfour.teamtwo.renttrailservice.services.TransactionService;

 import javax.validation.Valid;
 import java.lang.reflect.Type;
 import java.util.List;

 @RequestMapping("/transaction")
 @RestController
 public class TransactionController {

     @Autowired
     private TransactionService transactionService;

     @Autowired
     private RentService rentService;


     @PostMapping
     public ResponseMessage<TransactionModel> add(@RequestBody @Valid TransactionRequest request) {
         ModelMapper modelMapper = new ModelMapper();

         Rent rent = rentService.findById(request.getRentId());

         Transaction entity = transactionService.save(new Transaction(request.getGrandTotal(),
                 StatusTransaction.fromValue(request.getStatus()), rent));

         TransactionModel data = modelMapper.map(entity, TransactionModel.class);
         return ResponseMessage.successAdd(data);
     }

     @PutMapping("/{id}")
     public ResponseMessage<TransactionModel> edit(@PathVariable Integer id, @RequestBody @Valid TransactionRequest request){
         ModelMapper modelMapper = new ModelMapper();

         Transaction entity = transactionService.findById(id);

         entity.setGrandTotal(request.getGrandTotal());
         entity.setStatus(StatusTransaction.fromValue(request.getStatus()));
         entity.setRent(rentService.findById(request.getRentId()));

         entity = transactionService.save(entity);

         TransactionModel data = modelMapper.map(entity, TransactionModel.class);
         return ResponseMessage.successEdit(data);
     }

     @DeleteMapping("/{id}")
     public ResponseMessage<TransactionModel> removeById(@PathVariable Integer id) {
         ModelMapper modelMapper = new ModelMapper();

         Transaction entity = transactionService.removeById(id);

         TransactionModel data = modelMapper.map(entity, TransactionModel.class);

         return ResponseMessage.successDelete(data);
     }

     @GetMapping("/{id}")
     public ResponseMessage<TransactionModel> findById(@PathVariable Integer id) {
         Transaction entity = transactionService.findById(id);

         ModelMapper modelMapper = new ModelMapper();
         TransactionModel data = modelMapper.map(entity, TransactionModel.class);

         return ResponseMessage.success(data);
     }

     @GetMapping
     public ResponseMessage<PageableList<TransactionModel>> findAll(
             @RequestParam(required = false) Integer grandTotal,
             @RequestParam(required = false) StatusTransaction status,
             @RequestParam(required = false) Rent rent,
             @RequestParam(defaultValue = "asc") String sort,
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size
     ) {
         if (size > 100) {
             size = 100;
         }

         Transaction entity = new Transaction(grandTotal, status, rent);
         Sort.Direction direction = Sort.Direction
                 .fromOptionalString(sort.toUpperCase())
                 .orElse(Sort.Direction.ASC);
         Page<Transaction> pageTransactions = transactionService.findAll(entity, page, size, direction);
         List<Transaction> transactions = pageTransactions.toList();

         ModelMapper modelMapper = new ModelMapper();
         Type type = new TypeToken<List<TransactionModel>>() {
         }.getType();
         List<TransactionModel> transactionModels = modelMapper.map(transactions, type);
         PageableList<TransactionModel> data = new PageableList(transactionModels, pageTransactions.getNumber(),
                 pageTransactions.getSize(), pageTransactions.getTotalElements());

         return ResponseMessage.success(data);
     }

 }
