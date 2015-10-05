/**
 * 
 */
package com.demo.testng;

import java.util.Collection;

/**
 * @author etouch
 *
 */
public class Record {
	
	private String name;
	
	private Collection<RecordDataSet> dataSetColls;	

	/**
	 * @param name
	 * @param collection
	 */
	public Record(String name, Collection<RecordDataSet> dataSetColls) {
		this.name = name;
		this.dataSetColls = dataSetColls;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dataSetColls
	 */
	public Collection<RecordDataSet> getDataSetColls() {
		return dataSetColls;
	}

	/**
	 * @param dataSetColls the dataSetColls to set
	 */
	public void setDataSetColls(Collection<RecordDataSet> dataSetColls) {
		this.dataSetColls = dataSetColls;
	}

	
	
	
}
