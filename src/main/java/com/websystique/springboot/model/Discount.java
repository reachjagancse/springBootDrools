package com.websystique.springboot.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISCOUNT")
public class Discount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	/*
	 * @Column(name="INCENTIVETYPE") private String incentiveType;
	 */

	@Column(name = "CURRENTYEAR")
	private String currentYear;

	@Column(name = "PREVIOUSYEAR")
	private String previousYear;

	@Column(name = "MONTH")
	private String month;

	@Column(name = "TARGET")
	private BigDecimal target;

	@Column(name = "NETINVOICECURYEAR")
	private BigDecimal netInvoiceCurYear;

	@Column(name = "SUMOFNETVALUECURYEAR")
	private BigDecimal sumOfNetValueCurYear;

	@Column(name = "SUMOFNETVALUELASTYEAR")
	private BigDecimal sumOfNetValueLastYear;

	@Column(name = "SUMOFBILLEDQTYCURYEAR")
	private BigDecimal sumOfBilledQtyCurYear;

	@Column(name = "SUMOFBILLEDQTYLASTYEAR")
	private BigDecimal sumOfBilledQtyLastYear;

	@Column(name = "GROWTH")
	private BigDecimal growth;

	private BigDecimal incentivePercentage;

	public BigDecimal getIncentivePercentage() {
		return incentivePercentage;
	}

	public BigDecimal getSumOfBilledQtyCurYear() {
		return sumOfBilledQtyCurYear;
	}

	public void setSumOfBilledQtyCurYear(BigDecimal sumOfBilledQtyCurYear) {
		this.sumOfBilledQtyCurYear = sumOfBilledQtyCurYear;
	}

	public BigDecimal getSumOfBilledQtyLastYear() {
		return sumOfBilledQtyLastYear;
	}

	public void setSumOfBilledQtyLastYear(BigDecimal sumOfBilledQtyLastYear) {
		this.sumOfBilledQtyLastYear = sumOfBilledQtyLastYear;
	}

	public BigDecimal getGrowth() {
		return growth;
	}

	public void setGrowth(BigDecimal growth) {
		this.growth = growth;
	}

	public void setIncentivePercentage(BigDecimal incentivePercentage) {
		this.incentivePercentage = incentivePercentage;
	}

	private BigDecimal incentive;

	public BigDecimal getIncentive() {
		return incentive;
	}

	public void setIncentive(BigDecimal incentive) {
		this.incentive = incentive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTarget() {
		return target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}

	public BigDecimal getNetInvoiceCurYear() {
		return netInvoiceCurYear;
	}

	public void setNetInvoiceCurYear(BigDecimal netInvoiceCurYear) {
		this.netInvoiceCurYear = netInvoiceCurYear;
	}

	public BigDecimal getSumOfNetValueCurYear() {
		return sumOfNetValueCurYear;
	}

	public void setSumOfNetValueCurYear(BigDecimal sumOfNetValueCurYear) {
		this.sumOfNetValueCurYear = sumOfNetValueCurYear;
	}

	public BigDecimal getSumOfNetValueLastYear() {
		return sumOfNetValueLastYear;
	}

	public void setSumOfNetValueLastYear(BigDecimal sumOfNetValueLastYear) {
		this.sumOfNetValueLastYear = sumOfNetValueLastYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public String getIncentiveType() { return incentiveType; }
	 * 
	 * public void setIncentiveType(String incentiveType) { this.incentiveType =
	 * incentiveType; }
	 */

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getPreviousYear() {
		return previousYear;
	}

	public void setPreviousYear(String previousYear) {
		this.previousYear = previousYear;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
