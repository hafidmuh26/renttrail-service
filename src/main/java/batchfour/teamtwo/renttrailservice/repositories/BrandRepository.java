package batchfour.teamtwo.renttrailservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import batchfour.teamtwo.renttrailservice.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{

}