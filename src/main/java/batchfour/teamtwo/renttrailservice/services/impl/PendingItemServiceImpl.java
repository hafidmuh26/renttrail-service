package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.PendingItem;
import batchfour.teamtwo.renttrailservice.exeptions.EntityNotFoundException;
import batchfour.teamtwo.renttrailservice.repositories.PendingItemRepository;
import batchfour.teamtwo.renttrailservice.services.PendingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class PendingItemServiceImpl implements PendingItemService {

    @Autowired
    private PendingItemRepository repository;


    @Override
    public PendingItem save(PendingItem entity) {
        return repository.save(entity);
    }

    @Override
    public PendingItem removeById(Integer id) {
        PendingItem entity = findById(id);
        repository.delete(entity);

        return entity;
    }

    @Override
    public PendingItem findById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<PendingItem> findAll(PendingItem entity, int page, int size, Sort.Direction sort) {
        Sort s = Sort.Direction.DESC.equals(sort) ? Sort.by(sort, "id").descending() :
                Sort.by("id");

        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));
    }
}
