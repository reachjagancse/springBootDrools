package com.websystique.springboot.service;


import com.websystique.springboot.model.Discount;

import java.util.List;

public interface DiscountService {
	
	Discount findById(Long id);

	Discount findByName(String name);

	void saveDiscount(Discount discount);

	void updateDiscount(Discount discount);

	void deleteDiscountById(Long id);

	void deleteAllDiscounts();

	List<Discount> findAllDiscounts();

	boolean isDiscountExist(Discount discount);
	
	void saveDiscount(List<Discount> discounts);
}