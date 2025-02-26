package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CalciService {

	double addition(double a, double b) {
		return a + b;
	}

	double subtraction(double a, double b) {
		return a - b;
	}

	double multiplication(double a, double b) {
		return a * b;
	}

	double division(double a, double b) {
		if (b == 0) {
			throw new ArithmeticException("Division by zero is not allowed");
		}
		return a / b;
	}
}
