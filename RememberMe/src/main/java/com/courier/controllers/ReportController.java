package com.courier.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.courier.dto.TransactionDTO;
import com.courier.service.TransactionService;

@Controller
public class ReportController {

	@Autowired
	TransactionService service;

	@GetMapping("report.htm")
	public String report(ModelMap map) {

		TransactionDTO trans = new TransactionDTO();
		map.addAttribute("transaction", trans);
		return "/report";
	}

	@PostMapping("report.htm")
	public String generateReports(@ModelAttribute TransactionDTO transactionDTO, HttpServletRequest request) {
		List<TransactionDTO> transactionsDTO = service.getTransactions(transactionDTO.getSenderCity(),
				transactionDTO.getReceiverCity());

		request.setAttribute("tranasactionsList", transactionsDTO);

		return "success";

	}

}
