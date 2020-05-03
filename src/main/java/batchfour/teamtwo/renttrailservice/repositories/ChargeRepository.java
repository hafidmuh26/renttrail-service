package batchfour.teamtwo.renttrailservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import batchfour.teamtwo.renttrailservice.entities.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Integer> {

}