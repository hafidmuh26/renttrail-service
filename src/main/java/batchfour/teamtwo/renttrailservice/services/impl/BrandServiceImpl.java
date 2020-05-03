package batchfour.teamtwo.renttrailservice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import batchfour.teamtwo.renttrailservice.entities.Brand;
import batchfour.teamtwo.renttrailservice.repositories.BrandRepository;
import batchfour.teamtwo.renttrailservice.services.BrandService;

@Service
public class BrandServiceImpl extends EntityServiceImpl<Brand, Integer> implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    protected JpaRepository<Brand, Integer> getRepository() {
        return brandRepository;
    }

}