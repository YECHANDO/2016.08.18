package kr.co.kosta.passvalidator.service;

import static kr.co.kosta.passvalidator.util.PasswordComplexityContants.*;

public class Validator {

	public int passwordValidate(String passwd) {
		
		if (passwd.length() <= 8) {
			//매우약함, 약함
			try {
				Integer.parseInt(passwd);
				return TYPE_VERY_WEAK;
			}
			catch (NumberFormatException e) {
				return TYPE_WEAK;
			}
		}
		else {
			if (containsSpecialChar(passwd)) {
				return TYPE_VERY_STRONG;
			}
			else {
				return TYPE_STRONG;
				
			}
		}
	}

	private boolean containsSpecialChar(String passwd) {
		
		String[] specialChar = {"!", "@", "#", "$", "%", "^", "&", "*", "(", "0", "-", "="};
		
		for (String item : specialChar) {
			if (passwd.indexOf(item) > 0) {
				return true;
			}
		}
		return false;
	}
}
