package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.models.ItemSummaryRequest;
import batchfour.teamtwo.renttrailservice.repositories.ItemRepository;
import batchfour.teamtwo.renttrailservice.services.ItemSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ItemSummaryServiceImpl implements ItemSummaryService {

    @Autowired
    private ItemRepository repository;

    @Override
    public List<ItemSummaryRequest> itemSummary() throws SQLException {
        return repository.itemSummary();
    }
}
