package com.ventoday.util;

import com.ventoday.model.ToDo;

public class PayloadValidator {
	
	public static boolean validateCreatePayload(ToDo toDo){
		return toDo.getId() <= 0;

		/*if (toDo.getId() > 0){
			return false;
		}
		return true;*/
	}

}
