package com.poseidoncapitalsolutions.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poseidoncapitalsolutions.trading.model.BidList;

@Repository
public interface BidListRepository extends JpaRepository<BidList, Integer> {

}
