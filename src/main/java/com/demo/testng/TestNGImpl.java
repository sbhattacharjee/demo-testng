/**
 * 
 */
package com.demo.testng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

/**
 * @author etouch
 *
 */
public class TestNGImpl {

	public TestNGImpl(){
		System.out.println("Initializing TestNGImpl...");
	}
	
	private String[] testBeds = {"Chrome", "Firefox", "IE"};
	
	private TestNG getTestNG() {
		System.out.println("Creating TestNG suites and classes...");
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		
		for(String testBed : testBeds){
			
			XmlSuite suite = new XmlSuite();
			suite.setName("Suite_"+testBed);
			
			XmlTest test = new XmlTest(suite);
			test.setName("Test_"+testBed);
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("testBed", testBed);
			test.setParameters(params);
			
			List<XmlClass> classes = new ArrayList<XmlClass>();
			classes.add(new XmlClass("com.demo.testng.TestObjectFactory"));
			test.setXmlClasses(classes);
			
			System.out.println(suite.toXml());
			suites.add(suite);
		}
		
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);

		System.out.println("Returning TestNG object [Default Name ]==>"+tng.getDefaultSuiteName()+ " :: ");
		return tng;
	}

	public void run() {
		TestNG testng = this.getTestNG();

		TestListenerAdapter tla = new TestListenerAdapter();
		testng.addListener(tla);
		testng.setParallel("parallel");
		testng.setSuiteThreadPoolSize(testBeds.length);
		testng.run();
		
	}

}
