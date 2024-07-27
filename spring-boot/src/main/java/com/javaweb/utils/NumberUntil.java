package com.javaweb.utils;

public class NumberUntil {
	public static boolean isNumber(String values) {
		try {
			Long number = Long.parseLong(values);
		}catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
