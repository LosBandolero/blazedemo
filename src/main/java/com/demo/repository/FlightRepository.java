package com.demo.repository;

import com.demo.domain.Flight;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Integer> {
    List<Flight> findAll();

    Flight findAllById(int id);
}
