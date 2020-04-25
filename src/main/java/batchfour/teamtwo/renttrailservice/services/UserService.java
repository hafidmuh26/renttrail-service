package batchfour.teamtwo.renttrailservice.services;

import batchfour.teamtwo.renttrailservice.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService  {

    public User save(User entity);

    public User finById(Integer id);

    public User removeById(Integer id);

    public Page<User> findAll(User entity, int page, int size, Sort.Direction sort);

}
