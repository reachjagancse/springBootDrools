package com.websystique.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.websystique.springboot.model.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {

    Rule findByName(String name);

}
