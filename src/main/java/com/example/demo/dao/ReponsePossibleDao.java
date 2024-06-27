package com.example.demo.dao;

import com.example.demo.model.ReponsePossible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReponsePossibleDao extends JpaRepository<ReponsePossible, Integer> {

}
