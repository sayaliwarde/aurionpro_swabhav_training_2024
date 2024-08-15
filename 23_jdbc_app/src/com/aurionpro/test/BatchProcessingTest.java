package com.aurionpro.test;

import com.aurionpro.model.BatchProcessing;

public class BatchProcessingTest {
	public static void main(String[] args) {
		BatchProcessing batchProcessing = new BatchProcessing();
		batchProcessing.connectTo();
		batchProcessing.addStudentDetail();
		batchProcessing.getStudentDetails();
		
	}

}
