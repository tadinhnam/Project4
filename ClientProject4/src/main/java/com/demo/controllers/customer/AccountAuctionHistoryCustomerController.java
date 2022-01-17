package com.demo.controllers.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"customer/view/account/auctionhistory" })
public class AccountAuctionHistoryCustomerController {

	@RequestMapping(value = {"", "index" }, method = RequestMethod.GET)
	public String index() {
		return "customer/account/auctionhistory/index";
	}
}
