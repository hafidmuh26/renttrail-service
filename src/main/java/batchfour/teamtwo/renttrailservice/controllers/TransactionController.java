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
    public ResponseMessage<TransactionRequest> add(@RequestBody @Valid TransactionRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        Rent rent = rentService.findById(request.getRent().getId());

        Transaction entity = transactionService.save(new Transaction(request.getGrandTotal(),
                StatusTransaction.fromValue(request.getStatus()), rent));

        TransactionRequest data = modelMapper.map(entity, TransactionRequest.class);
        return ResponseMessage.successAdd(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<TransactionRequest> edit(@PathVariable Integer id, @RequestBody @Valid TransactionRequest request){
        ModelMapper modelMapper = new ModelMapper();

        Transaction entity = transactionService.findById(id);

        entity.setGrandTotal(request.getGrandTotal());
        entity.setStatus(StatusTransaction.fromValue(request.getStatus()));
        entity.setRent(rentService.findById(request.getRent().getId()));

        entity = transactionService.save(entity);

        TransactionRequest data = modelMapper.map(entity, TransactionRequest.class);
        return ResponseMessage.successEdit(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<TransactionRequest> removeById(@PathVariable Integer id) {
        ModelMapper modelMapper = new ModelMapper();

        Transaction entity = transactionService.removeById(id);

        TransactionRequest data = modelMapper.map(entity, TransactionRequest.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<TransactionRequest> findById(@PathVariable Integer id) {
        Transaction entity = transactionService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        TransactionRequest data = modelMapper.map(entity, TransactionRequest.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<TransactionRequest>> findAll(
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
        Type type = new TypeToken<List<TransactionRequest>>() {
        }.getType();
        List<TransactionRequest> transactionModels = modelMapper.map(transactions, type);
        PageableList<TransactionRequest> data = new PageableList(transactionModels, pageTransactions.getNumber(),
                pageTransactions.getSize(), pageTransactions.getTotalElements());

        return ResponseMessage.success(data);
    }

}
