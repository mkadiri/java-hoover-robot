package com.mkadiri.repository;

import com.mkadiri.entity.HooverHistory;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface HooverHistoryRepository extends CrudRepository<HooverHistory, Long> {

}