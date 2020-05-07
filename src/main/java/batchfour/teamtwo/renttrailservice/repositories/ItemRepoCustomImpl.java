package batchfour.teamtwo.renttrailservice.repositories;

import batchfour.teamtwo.renttrailservice.entities.Item;
import batchfour.teamtwo.renttrailservice.models.ItemSummaryRequest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.List;

public class ItemRepoCustomImpl implements ItemRepoCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ItemSummaryRequest> itemSummary() throws SQLException {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ItemSummaryRequest> criteria = builder.createQuery(ItemSummaryRequest.class);
        Root<Item> root = criteria.from(Item.class);

        criteria.multiselect(builder.count(root.get("name")))
                .groupBy(root.get("name")) ;

        return entityManager.createQuery(criteria).getResultList();
    }
}
