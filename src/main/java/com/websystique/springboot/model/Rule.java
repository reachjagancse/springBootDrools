package com.websystique.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="RULE")
public class Rule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Transient
	private List<String> rulesSelection;
	
	
	@Column(name="RULESSELECTED")
	private String rulesSelected;
	
	
	private String rulesToApply;
	
	
	

	public String getRulesToApply() {
		return rulesToApply;
	}

	public void setRulesToApply(String rulesToApply) {
		this.rulesToApply = rulesToApply;
	}

	public List<String> getRulesSelection() {
		return rulesSelection;
	}

	public void setRulesSelection(List<String> rulesSelection) {
		this.rulesSelection = rulesSelection;
	}

	public String getRulesSelected() {
		return rulesSelected;
	}

	public void setRulesSelected(String rulesSelected) {
		this.rulesSelected = rulesSelected;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	

}
