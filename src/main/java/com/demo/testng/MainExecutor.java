/**
 * 
 */
package com.demo.testng;

/**
 * @author etouch
 *
 */
public class MainExecutor {

	public static void main(String args[]){
		System.out.println("Initiating MainExecutor...");
		
		TestNGImpl testNGImpl = new TestNGImpl();
		testNGImpl.run();
		
	}
}
