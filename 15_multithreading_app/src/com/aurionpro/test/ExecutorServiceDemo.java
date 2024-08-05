package com.aurionpro.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.aurionpro.model.Task;

public class ExecutorServiceDemo {
	public static void main(String[] args) {
		int coreCount = Runtime.getRuntime().availableProcessors();	//for cpu intensive task
		
		System.out.println("available process "+coreCount);
		
		ExecutorService service=Executors.newCachedThreadPool();
		
		for(int i=0;i<100;i++) {
			service.execute(new Task());
		}
	}
	

}
