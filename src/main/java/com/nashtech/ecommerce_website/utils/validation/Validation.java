package com.nashtech.ecommerce_website.utils.validation;



import java.util.regex.Pattern;

public class Validation {
	/**
	 * Function hasSpecialCharacter is used to check input string,which contains special character or does not special character.
	 * 
	 * @param $valueInput is input string
	 * @return true: input string has special character, false:input string does not have special character
	 * 
	 */
	public static boolean hasSpecialCharacter(String valueInput) {
		if (Pattern.compile("(?=.*[!@#&()–[{}]:;',?/*~$^+=<>])").matcher(valueInput) != null) {
			return false;
		}
		return true;
	}

	/**
	 * Function isEmpty is used to check input string, which is empty or not empty.
	 * 
	 * @param $valueInput is input string
	 * @return true: input string is empty, false:input string is not empty
	 * 
	 */
	public static boolean isEmpty(String valueInput) {
		if (valueInput.length() == 0 || valueInput == null) {
			return true;
		}
		return false;
	}
}
