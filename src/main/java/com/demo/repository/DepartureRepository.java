package com.demo.repository;

import com.demo.domain.Departure;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface DepartureRepository extends PagingAndSortingRepository<Departure, Integer> {
    List<Departure> findAll();

    Departure findAllById(int id);
}
