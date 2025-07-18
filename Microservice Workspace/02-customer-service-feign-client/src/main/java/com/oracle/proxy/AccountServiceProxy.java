package com.oracle.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oracle.model.Account;

@FeignClient(name = "ACCOUNT-SERVICE", path = "/account-api")
public interface AccountServiceProxy {
	// http://ACCOUNT-SERVICE/account-api/account/customer/{customerId}
	@GetMapping("/account/customer/{customerId}")
	public Account findAccountByCustomerId(@PathVariable("customerId") String customerId);
}
