package com.aurionpro.threads;

public class RunnableThread implements Runnable{
	Thread thread;
	
	public RunnableThread(String name) {
		thread = new Thread(this);
		thread.start();
		thread.setName(name);
	}

	@Override
	public void run() {
		for(int i=5;i>0;i--) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

}
