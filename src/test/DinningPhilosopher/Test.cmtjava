package test.DinningPhilosopher;

import stm.*;

class Test{
	
	public static void main (String args[])throws Exception {
		Fork f1 = new Fork();
		Fork f2 = new Fork();
		Fork f3 = new Fork();
		Fork f4 = new Fork();
		Fork f5 = new Fork();
	
		Philosopher p1 = new Philosopher(1,f1,f2);
		Philosopher p2 = new Philosopher(2,f2,f3);
		Philosopher p3 = new Philosopher(3,f3,f4);
		Philosopher p4 = new Philosopher(4,f4,f5);
		Philosopher p5 = new Philosopher(5,f5,f1);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();  
	}        
}
