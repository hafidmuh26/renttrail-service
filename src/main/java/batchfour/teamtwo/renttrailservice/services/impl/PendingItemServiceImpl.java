package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.PendingItem;
import batchfour.teamtwo.renttrailservice.exceptions.EntityNotFoundException;
import batchfour.teamtwo.renttrailservice.repositories.PendingItemRepository;
import batchfour.teamtwo.renttrailservice.services.PendingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PendingItemServiceImpl extends EntityServiceImpl<PendingItem, Integer> implements PendingItemService {

    @Autowired
    private PendingItemRepository pendingItemRepository;

    @Override
    protected JpaRepository<PendingItem, Integer> getRepository() {
        return pendingItemRepository;
    }
}
