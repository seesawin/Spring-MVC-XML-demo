package com.seesawin.ch03.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.seesawin.ch03.model.ProductBeam;
import com.seesawin.ch03.service.impl.ProductServiceImpl;

public class CH003Servlet2 {
	private String viewPath;

	private ProductServiceImpl productServiceImpl;

	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}

	public void setProductServiceImpl(ProductServiceImpl productServiceImpl) {
		this.productServiceImpl = productServiceImpl;
	}

	public ModelAndView initialize(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();

		return new ModelAndView(viewPath, "model", model);
	}

	public ModelAndView selectProduct(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();

		String name = request.getParameter("name");
		System.out.println("name : " + name);

		List<ProductBeam> products = null;
		if (name == null || name.isEmpty()) {
			products = productServiceImpl.selectProducts();
		} else {
			products = productServiceImpl.searchProducts(name);
		}
		model.put("products", products);
		model.put("name", name);

		return new ModelAndView(viewPath, "model", model);
	}
}
