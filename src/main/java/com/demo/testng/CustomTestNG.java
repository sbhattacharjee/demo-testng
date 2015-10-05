/**
 * 
 */
package com.demo.testng;


import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author etouch
 *
 */
public class CustomTestNG {

	private String testBed, testAction; 
	
	private RecordDataSet recordDataSet;
	
	public CustomTestNG(String testBed, String testAction, RecordDataSet recordDataSet){
		
		this.testBed = testBed;
		this.testAction = testAction;
		this.recordDataSet = recordDataSet;
		
		System.out.println("[init: "+testBed+"] Running CustomTestNG class...");
	}
	
	@BeforeClass()
	public void init(){
		System.out.println("[Before: "+testBed+"] executing test method for ==>"+testAction);
	}
	
	@Test()
	public void dummyTest(){
		System.out.println("[Executing: "+testBed+"] Executing test method for ==>"+testAction);
		
		Map<String, String> dataSetMap = recordDataSet.getDatasetMap();
		
		for(Map.Entry<String, String> dataSet : dataSetMap.entrySet()){
			System.out.println("[Executing: "+testBed+" & "+ testAction +"] **** "+dataSet.getKey()+" :: "+dataSet.getValue()+" *****");
		}
	}
	
	@AfterClass
	public void deinit(){
		System.out.println("[After: "+testBed+"] finished executing test method for ==>"+testAction);
	}

}
