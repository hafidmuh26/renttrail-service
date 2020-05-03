package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.Rent;
import batchfour.teamtwo.renttrailservice.repositories.RentRepository;
import batchfour.teamtwo.renttrailservice.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl extends EntityServiceImpl<Rent, Integer> implements RentService {

    @Autowired
    RentRepository rentRepository;

    @Override
    protected JpaRepository<Rent, Integer> getRepository() {
        return rentRepository;
    }
}
