package com.thepurpleblock.allenmg.shopassistant;

public class BuildSystemTestFile {

	public static void main(String[] args){
		//Check to see how the static code analysis is working
		String string = "I'm a string!";
		
		System.out.println("I'm a string!");
		
		doComplicatedThings();

	}
	
	public static boolean doComplicatedThings() {
		for(int i = 0; i < Integer.valueOf(500).intValue(); i++) {
			if(i < 5 || i > 250){
				if(i % 2 == 0){
					if(i % 4 == 0){
						break;
					}
				} else {
					if(i % 3 == 0){
						break;
					}
				}
			} else {
				if(i % 2 == 0){
					if(i % 4 == 0){
						break;
					}
				} else {
					if(i % 3 == 0){
						break;
					}
				}
			}
		}
		
		boolean result = true;
		return result;
	}

}
