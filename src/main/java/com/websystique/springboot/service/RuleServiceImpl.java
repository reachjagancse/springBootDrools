package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.Rule;
import com.websystique.springboot.repositories.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("ruleService")
@Transactional
public class RuleServiceImpl implements RuleService{

	@Autowired
	private RuleRepository ruleRepository;

	public Rule findById(Long id) {
		return ruleRepository.findOne(id);
	}

	public Rule findByName(String name) {
		return ruleRepository.findByName(name);
	}

	public void saveRule(Rule rule) {
		ruleRepository.save(rule);
	}

	public void updateRule(Rule rule){
		saveRule(rule);
	}

	public void deleteRuleById(Long id){
		ruleRepository.delete(id);
	}

	public void deleteAllRules(){
		ruleRepository.deleteAll();
	}

	public List<Rule> findAllRules(){
		return ruleRepository.findAll();
	}


}
