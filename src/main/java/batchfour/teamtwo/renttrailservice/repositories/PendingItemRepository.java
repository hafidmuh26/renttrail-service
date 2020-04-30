package batchfour.teamtwo.renttrailservice.repositories;

import batchfour.teamtwo.renttrailservice.entities.PendingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingItemRepository extends JpaRepository<PendingItem, Integer> {
}
