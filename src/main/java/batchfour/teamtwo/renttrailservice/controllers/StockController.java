package batchfour.teamtwo.renttrailservice.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import batchfour.teamtwo.renttrailservice.entities.PendingItem;
import batchfour.teamtwo.renttrailservice.services.PendingItemService;
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

import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.entities.Stock;
import batchfour.teamtwo.renttrailservice.models.PageableList;
import batchfour.teamtwo.renttrailservice.models.ResponseMessage;
import batchfour.teamtwo.renttrailservice.models.StockModel;
import batchfour.teamtwo.renttrailservice.models.StockRequest;
import batchfour.teamtwo.renttrailservice.services.ItemService;
import batchfour.teamtwo.renttrailservice.services.StockService;

@RequestMapping("/stocks")
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private PendingItemService pendingItemService;

    @PostMapping
    public ResponseMessage<StockModel> add(@RequestBody @Valid StockRequest request) {
        ModelMapper modelMapper = new ModelMapper();

        PendingItem pendingItem = pendingItemService.findById(request.getItemId());

        Stock entity = stockService.save(new Stock(pendingItem, request.getQuantity()));

        StockModel data = modelMapper.map(entity, StockModel.class);
        return ResponseMessage.successAdd(data);
    }

    @PutMapping("/{id}")
    public ResponseMessage<StockModel> edit(@PathVariable Integer id, @RequestBody @Valid StockRequest request){
        ModelMapper modelMapper = new ModelMapper();

        Stock entity = stockService.findById(id);

        entity.setPendingItem(pendingItemService.findById(request.getItemId()));
        entity.setQuantity(request.getQuantity());

        entity = stockService.save(entity);

        StockModel data = modelMapper.map(entity, StockModel.class);
        return ResponseMessage.successEdit(data);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage<StockModel> removeById(@PathVariable Integer id) {
        Stock entity = stockService.removeById(id);

        ModelMapper modelMapper = new ModelMapper();
        StockModel data = modelMapper.map(entity, StockModel.class);

        return ResponseMessage.successDelete(data);
    }

    @GetMapping("/{id}")
    public ResponseMessage<StockModel> findById(@PathVariable Integer id) {
        Stock entity = stockService.findById(id);

        ModelMapper modelMapper = new ModelMapper();
        StockModel data = modelMapper.map(entity, StockModel.class);

        return ResponseMessage.success(data);
    }

    @GetMapping
    public ResponseMessage<PageableList<StockModel>> findAll(
            @RequestParam(required = false) PendingItem item,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(defaultValue = "asc") String sort,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (size > 100) {
            size = 100;
        }

        Stock entity = new Stock(item, quantity);
        Sort.Direction direction = Sort.Direction
                .fromOptionalString(sort.toUpperCase())
                .orElse(Sort.Direction.ASC);
        Page<Stock> pageStocks = stockService.findAll(entity, page, size, direction);
        List<Stock> items = pageStocks.toList();

        ModelMapper modelMapper = new ModelMapper();
        Type type = new TypeToken<List<StockModel>>() {
        }.getType();
        List<StockModel> stockModels = modelMapper.map(items, type);
        PageableList<StockModel> data = new PageableList(stockModels, pageStocks.getNumber(),
                pageStocks.getSize(), pageStocks.getTotalElements());

        return ResponseMessage.success(data);
    }

}
