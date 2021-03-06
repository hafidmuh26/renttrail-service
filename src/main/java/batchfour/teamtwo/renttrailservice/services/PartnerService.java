package batchfour.teamtwo.renttrailservice.services;

import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.entities.Partner;
import org.springframework.beans.factory.annotation.Autowired;

public interface PartnerService extends EntityService<Partner, Integer> {

    Partner findByAccount(Account account);
}
