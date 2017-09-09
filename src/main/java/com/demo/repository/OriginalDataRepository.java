package com.demo.repository;

import com.demo.domain.OriginalData;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OriginalDataRepository extends PagingAndSortingRepository<OriginalData, Integer> {
}
