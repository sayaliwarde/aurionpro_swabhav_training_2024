package com.aurionpro.interthreadcommunication;

import com.aurionpro.interthreadcommunication.Q;

class Producer implements Runnable {
	 Q q;
	 Producer(Q q) {
	 this.q = q;
	 new Thread(this, "Producer").start();
	 }
	 public void run() {
	 int i = 0;
	 while(true) {
	 q.put(i++);
	 }
	 }
	}