package com.mastercard.billingrequestreport.exception.model;

import lombok.Data;

@Data
public class ErrorHandler {
	
	Errors errors;

	public ErrorHandler(Errors errorsObject) {
		super();
		errors = errorsObject;
	}
}
