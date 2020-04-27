package batchfour.teamtwo.renttrailservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import batchfour.teamtwo.renttrailservice.entities.Variety;
import batchfour.teamtwo.renttrailservice.repositories.VarietyRepository;
import batchfour.teamtwo.renttrailservice.services.VarietyService;

@Service
public class VarietyServiceImpl extends EntityServiceImpl<Variety, Integer> implements VarietyService {

    @Autowired
    private VarietyRepository varietyRepository;

    @Override
    protected JpaRepository<Variety, Integer> getRepository() {
        return varietyRepository;
    }

}