/**
 * 
 */
package com.demo.testng;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;

/**
 * @author etouch
 *
 */
public class TestObjectFactory {

	private String[] testActionNames = {"LoadLoginPage", "LoginTest", "SuccessLogout"};
	
	private String[] testDataLabels = {"LoginDataSet", "SearchDataSet"};
	
	@Parameters({"testBed"})
	@Factory
	public Object[] createInstances(String testBed){
		
		Collection<Record> recordColls = getRecordList();
		List<CustomTestNG> customTestNGColls = new ArrayList<CustomTestNG>();

		for (Record record : recordColls){
			if(record.getDataSetColls() != null && record.getDataSetColls().size() > 0){
				
				for( RecordDataSet recordDataSet : record.getDataSetColls()){
					CustomTestNG customTestNG = new CustomTestNG(testBed, record.getName(), recordDataSet);
					customTestNGColls.add(customTestNG);
				}
			}
			else{
				
				CustomTestNG customTestNG = new CustomTestNG(testBed, record.getName(), null);
				customTestNGColls.add(customTestNG);
			}
				
		}
		
		return customTestNGColls.toArray();
	}

	private Collection<Record> getRecordList(){
		Collection<Record> recordColls = new ArrayList<Record>();
		
		recordColls.add( new Record(testActionNames[0], getTestDataColls ( testDataLabels[0] )));
		recordColls.add( new Record(testActionNames[1], getTestDataColls ( testDataLabels[1] )));
		recordColls.add( new Record(testActionNames[2], null));
	
		return recordColls;
	}

	private Collection<RecordDataSet> getTestDataColls(String testDataLabel) {

		Collection<RecordDataSet> testDataColls = new ArrayList<RecordDataSet>();
		
		if (testDataLabel.equalsIgnoreCase("LoginDataSet")){
			
			testDataColls.add(getLoginDataSetMap("rajeshp.etouch@gmail.com","eTouch123$$"));
			testDataColls.add(getLoginDataSetMap("laxmi","1312321"));
			testDataColls.add(getLoginDataSetMap("vijaya","abc"));
			
		}
		else if ( testDataLabel.equalsIgnoreCase("SearchDataSet")){
			Map<String, String> testDataMap = new HashMap<String, String>();
			testDataMap.put("SearchBox", "iphone5cases");
			
			RecordDataSet recordDataSet = new RecordDataSet(testDataMap);
			
			testDataColls.add(recordDataSet);
		}
		
		return testDataColls;
	}

	/**
	 * @param password 
	 * @param userName 
	 * @return
	 */
	private RecordDataSet getLoginDataSetMap(String userName, String password) {
		Map<String, String> testDataMap = new HashMap<String, String>();
		testDataMap.put("usename", userName);
		testDataMap.put("passwd", password);
		
		RecordDataSet recordDataSet = new RecordDataSet(testDataMap);
		return recordDataSet;
	}
	
	
}
