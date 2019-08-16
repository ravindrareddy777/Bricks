package org.building.blocks.util;

import java.util.regex.Pattern;

public enum ValidationRule {
	
	NAME("^[a-zA-Z][a-zA-Z0-9_ ]{5,29}$");
	
	private final Pattern pattern; 
	
	private ValidationRule(String patternstr){
		this.pattern = Pattern.compile(patternstr);
	}
	
	
	public Pattern getPattern() { 
		return this.pattern;
	}	

}
