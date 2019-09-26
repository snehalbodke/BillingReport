package com.mastercard.billingrequestreport.exception.model;

import lombok.Data;

@Data
public class Error {
	private String source;
	private String reasonCode;
	private String description;
	private boolean recoverable;
	private String details;

}
