package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalciCalculator {

	@Autowired
	CalciService calcuService;

	@GetMapping("/")
	String home() {
		return "calci";
	}

	@RequestMapping("/calculate")
	String calculate(@RequestParam("n1") double n1, @RequestParam("n2") double n2,
			@RequestParam("operation") String operation, Model model) {

		double result = 0;

		switch (operation) {
		case "add":
			result = calcuService.addition(n1, n2);
			break;

		case "sub":
			result = calcuService.subtraction(n1, n2);
			break;

		case "mul":
			result = calcuService.multiplication(n1, n2);
			break;

		case "div":
			if (n2 != 0) {
				result = calcuService.division(n1, n2);
			} else {
				model.addAttribute("operation", operation);
				model.addAttribute("result", " Division by zero is not allowed.");
				return "resultpage";
			}
			break;

		default:
			model.addAttribute("error", "Invalid operation.");
			return "result";
		}

		model.addAttribute("operation", operation);
		model.addAttribute("result", result);

		return "resultpage";
	}
}
