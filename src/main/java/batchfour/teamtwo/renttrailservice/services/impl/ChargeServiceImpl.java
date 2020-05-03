package batchfour.teamtwo.renttrailservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import batchfour.teamtwo.renttrailservice.entities.Charge;
import batchfour.teamtwo.renttrailservice.repositories.ChargeRepository;
import batchfour.teamtwo.renttrailservice.services.ChargeService;

@Service
public class ChargeServiceImpl extends EntityServiceImpl<Charge, Integer> implements ChargeService {

    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    protected JpaRepository<Charge, Integer> getRepository() {
        return chargeRepository;
    }

}