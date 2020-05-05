package batchfour.teamtwo.renttrailservice.repositories;

import batchfour.teamtwo.renttrailservice.models.ItemSummaryRequest;

import java.sql.SQLException;
import java.util.List;

public interface ItemRepoCustom {

    List<ItemSummaryRequest> itemSummary() throws SQLException;

}
