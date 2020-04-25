package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.Outlet;
import batchfour.teamtwo.renttrailservice.repositories.OutletRepository;
import batchfour.teamtwo.renttrailservice.services.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OutletServiceImpl extends EntityServiceImpl<Outlet, Integer> implements OutletService {

    @Autowired
    private OutletRepository outletRepository;

    @Override
    protected JpaRepository<Outlet, Integer> getRepository() {
        return outletRepository;
    }
}
