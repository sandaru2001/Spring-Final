package com.example.cw_spring.repository;

import com.example.cw_spring.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SizeDAO extends JpaRepository<SizeEntity, String> {

    @Query(value = "SELECT size_id FROM size_entity ORDER BY size_id DESC LIMIT 1", nativeQuery = true)
    String findLastId();
}
