package com.demo.repository;

import com.demo.domain.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsersRepository extends PagingAndSortingRepository<Users, Integer> {
    List<Users> findAll();

    Users findAllById(int id);

    @Transactional
    void deleteById(int id);
}
