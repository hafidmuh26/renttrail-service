package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.Account;
import batchfour.teamtwo.renttrailservice.entities.Partner;
import batchfour.teamtwo.renttrailservice.repositories.PartnerRepository;
import batchfour.teamtwo.renttrailservice.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl extends EntityServiceImpl<Partner, Integer> implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    protected JpaRepository<Partner, Integer> getRepository() {
        return partnerRepository;
    }


    @Override
    public Partner findByAccount(Account account) {
        return partnerRepository.findByAccount(account);
    }
}
