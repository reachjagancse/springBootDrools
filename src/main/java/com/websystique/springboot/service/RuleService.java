package com.websystique.springboot.service;


import com.websystique.springboot.model.Rule;

import java.util.List;

public interface RuleService {
	
	Rule findById(Long id);

	Rule findByName(String name);

	void saveRule(Rule rule);

	void updateRule(Rule rule);

	void deleteRuleById(Long id);

	void deleteAllRules();

	List<Rule> findAllRules();

}