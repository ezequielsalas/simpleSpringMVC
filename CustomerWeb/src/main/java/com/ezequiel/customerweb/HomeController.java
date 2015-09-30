package com.ezequiel.customerweb;


import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezequiel.customerweb.customer.CustomerDomain;
import com.ezequiel.customerweb.service.CustomerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private CustomerService customerService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "index";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String result(Model model){
		List<CustomerDomain> customers = customerService.getAllCustomer();
		model.addAttribute("customers",customers);
		return "customer";
	}
	
	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public String loadResult(Model model){
		List<CustomerDomain> customers = customerService.getAllCustomer();
		model.addAttribute("customers",customers);
		return "fragments/customerResult";
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public String filter(Model model,@RequestParam("code") Long code,@RequestParam("name") String name,@RequestParam("lastname") String lastName){
		model.addAttribute("customers",customerService.filterCustomer(code, name, lastName));
		return "fragments/customerResult::customerTR";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(Model model,@RequestParam("code") Long code,@RequestParam("name") String name,@RequestParam("lastname") String lastName){
		CustomerDomain domain = new CustomerDomain(name, lastName, code);
		model.addAttribute("customer",customerService.register(domain));
		return "fragments/customerRow::customerAddedTR";
	}
	
}
