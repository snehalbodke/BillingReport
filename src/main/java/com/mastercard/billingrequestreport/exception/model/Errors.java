package com.mastercard.billingrequestreport.exception.model;

import lombok.Data;
import java.util.List;

@Data
public class Errors {

	List<Error> error;
}
