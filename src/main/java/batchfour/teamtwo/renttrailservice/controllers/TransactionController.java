//package batchfour.teamtwo.renttrailservice.controllers;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import batchfour.teamtwo.renttrailservice.entities.Charge;
//import batchfour.teamtwo.renttrailservice.entities.Rent;
//import batchfour.teamtwo.renttrailservice.entities.Transaction;
//import batchfour.teamtwo.renttrailservice.models.PageableList;
//import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
//import batchfour.teamtwo.renttrailservice.models.TransactionModel;
//import batchfour.teamtwo.renttrailservice.services.ChargeService;
//import batchfour.teamtwo.renttrailservice.services.RentService;
//import batchfour.teamtwo.renttrailservice.services.TransactionService;
//
//@RequestMapping("/transaction")
//@RestController
//public class TransactionController {
//
//    @Autowired
//    private TransactionService transactionService;
//
//    @Autowired
//    private RentService rentService;
//
//    @Autowired
//    private ChargeService chargeService;
//
//    @GetMapping("/{id}")
//    public ResponseMessage<TransactionModel> findById(@PathVariable Integer id) {
//        Transaction entity = transactionService.findById(id);
//
//        ModelMapper modelMapper = new ModelMapper();
//        TransactionModel data = modelMapper.map(entity, TransactionModel.class);
//
//        return ResponseMessage.success(data);
//    }
//
//    @GetMapping
//    public ResponseMessage<PageableList<TransactionModel>> findAll(
//            @RequestParam(required = false) Integer grandTotal,
//            @RequestParam(required = false) String status,
//            @RequestParam(required = false) Rent rent,
//            @RequestParam(required = false) Charge charge,
//            @RequestParam(defaultValue = "asc") String sort,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size
//    ) {
//        if (size > 100) {
//            size = 100;
//        }
//
//        Transaction entity = new Transaction(name, price, brand, variety, picture);
//        Sort.Direction direction = Sort.Direction
//                .fromOptionalString(sort.toUpperCase())
//                .orElse(Sort.Direction.ASC);
//        Page<Transaction> pageTransactions = itemService.findAll(entity, page, size, direction);
//        List<Transaction> transactions = pageTransactions.toList();
//
//        ModelMapper modelMapper = new ModelMapper();
//        Type type = new TypeToken<List<TransactionModel>>() {
//        }.getType();
//        List<TransactionModel> transactionModels = modelMapper.map(transactions, type);
//        PageableList<TransactionModel> data = new PageableList(transactionModels, pageTransactions.getNumber(),
//                pageTransactions.getSize(), pageTransactions.getTotalElements());
//
//        return ResponseMessage.success(data);
//    }
//
//}