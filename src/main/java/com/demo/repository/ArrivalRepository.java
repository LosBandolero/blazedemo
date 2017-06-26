package com.demo.repository;

import com.demo.domain.Arrival;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ArrivalRepository extends PagingAndSortingRepository<Arrival, Integer> {
    List<Arrival> findAll();

    Arrival findAllById(int id);
}
