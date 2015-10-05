/**
 * 
 */
package com.demo.testng;

import java.util.HashMap;
import java.util.Map;

/**
 * @author etouch
 *
 */
public class RecordDataSet {

	private Map<String, String> datasetMap = new HashMap<String, String>();

	public RecordDataSet(Map<String, String> testDataMap) {
		this.datasetMap = testDataMap;
	}

	/**
	 * @return the datasetMap
	 */
	public Map<String, String> getDatasetMap() {
		return datasetMap;
	}

	/**
	 * @param datasetMap the datasetMap to set
	 */
	public void setDatasetMap(Map<String, String> datasetMap) {
		this.datasetMap = datasetMap;
	}
	
}
