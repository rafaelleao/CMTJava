package stm;

import java.util.*;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class FieldInfo <A> {
	
	public {A => void} updateField;
	public AtomicMarkableReference<Long> wlock;
	public AtomicMarkableReference<Long> rlock;
	public Vector<Block> blockedThreads;
	public String name;
	
	public FieldInfo( String name, {A => void } uf ) {
		
		this(uf);
		this.name = name;
	}
	
	public FieldInfo( {A => void } uf ) {

		updateField = uf;
		blockedThreads = new Vector<Block>();
		wlock = new AtomicMarkableReference(null, false);
		rlock = new AtomicMarkableReference(0l, false);
	}

	public synchronized void addBlockedThread (Block s) {
		blockedThreads.add(s);
	}
	
	public synchronized void wakeupBlockedThreads () {
		for (int i=0; i < blockedThreads.size(); i++) {
			blockedThreads.get(i).unblock();
		}
		blockedThreads = new Vector<Block>();
	}
	
	public synchronized String toString() {
		return ("["+ name + " : wlock "+ wlock.isMarked() +"," +wlock.getReference()
			+" : rlock "+ rlock.isMarked() +"," +rlock.getReference()+"]") ;
	}
	
}

