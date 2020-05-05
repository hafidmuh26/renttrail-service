package batchfour.teamtwo.renttrailservice.services.impl;

import batchfour.teamtwo.renttrailservice.entities.User;
import batchfour.teamtwo.renttrailservice.repositories.UserRepository;
import batchfour.teamtwo.renttrailservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }

    @Override
    public User finById(Integer id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User removeById(Integer id) {
        User entity = finById(id);
        repository.delete(entity);

        return entity;
    }

    @Override
    public Page<User> findAll(User entity, int page, int size, Sort.Direction sort) {
        Sort s = Sort.Direction.DESC.equals(sort) ? Sort.by(sort, "id").descending() :
                Sort.by("id");

        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
                                 .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));
    }
}
