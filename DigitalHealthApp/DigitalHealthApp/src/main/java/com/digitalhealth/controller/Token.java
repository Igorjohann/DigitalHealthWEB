package com.digitalhealth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Token {
	private static List<Double> tokenList;
	
	
	public static double generateToken() {
		return new Random().nextDouble();
	}
	
	public static void addToken(double token) {
		if(tokenList == null) {	
			tokenList = new ArrayList<Double>();
		}
		tokenList.add(token); 
	}

	public static List<Double> getTokenList() {
		return tokenList;
	}

}
