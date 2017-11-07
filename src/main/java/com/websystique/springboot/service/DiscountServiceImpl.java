package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.Discount;
import com.websystique.springboot.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("discountService")
@Transactional
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	private DiscountRepository discountRepository;

	public Discount findById(Long id) {
		return discountRepository.findOne(id);
	}

	public Discount findByName(String name) {
		return discountRepository.findByName(name);
	}

	public void saveDiscount(Discount discount) {
		discountRepository.save(discount);
	}

	public void updateDiscount(Discount discount){
		saveDiscount(discount);
	}

	public void deleteDiscountById(Long id){
		discountRepository.delete(id);
	}

	public void deleteAllDiscounts(){
		discountRepository.deleteAll();
	}

	public List<Discount> findAllDiscounts(){
		return discountRepository.findAll();
	}

	public boolean isDiscountExist(Discount discount) {
		return false;/*findByName(Discount.getName()) != null*/
	}

	public void saveDiscount(List<Discount> discounts) {
	 discountRepository.save(discounts);
	 
		
	}

}
