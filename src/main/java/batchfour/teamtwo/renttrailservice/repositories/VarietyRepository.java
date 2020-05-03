package batchfour.teamtwo.renttrailservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import batchfour.teamtwo.renttrailservice.entities.Variety;

public interface VarietyRepository extends JpaRepository<Variety, Integer> {

}