package com.tew.beans;

public class Counter {

	private int value;
	
	public Counter() {
        // Constructor por defecto 
        this.value = 0;
    }
	
	public int getIncrementedValue() {
		return ++value;
	}
}
