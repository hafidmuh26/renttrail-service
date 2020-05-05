package batchfour.teamtwo.renttrailservice.services;

import batchfour.teamtwo.renttrailservice.models.ItemSummaryRequest;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface ItemSummaryService {

    List<ItemSummaryRequest> itemSummary() throws SQLException;
}
