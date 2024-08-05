package com.aurionpro.threads;

public class CallerThread implements Runnable {
	
	private String message;
	private CallMe target;
	private Thread thread;
	
	
		
public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

public CallerThread(String message, CallMe target) {
	super();
	this.message = message;
	this.target = target;
	this.thread = new Thread(this);
	this.thread.start();
}

public void run() {
	target.call(message);
	}

}
