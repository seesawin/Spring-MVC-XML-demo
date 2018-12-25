package com.seesawin.ch03.service;

import java.util.List;

import com.seesawin.ch03.model.ProductBeam;

public interface ProductService {
	List<ProductBeam> selectProducts();

	List<ProductBeam> searchProducts(String name);

	ProductBeam selectOneProducts(String name);
}
