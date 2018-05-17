package primes ;

import java.math.BigInteger ;

public abstract class Sieve<T> extends Item<T> {
private    BigInteger maxprime ;
private    BigInteger euler ;

	
	public Sieve(String[] args, Item<T> next) {
		super(next);
		
		this.maxprime = new BigInteger(args[0]) ;
		this.euler = BigInteger.ZERO ;
	}
	
	public Sieve () {
		super(null) ;
		this.euler = BigInteger.ZERO ;
	}
	
/*
 public Sieve(String[] args) {
		this(args, new Counter()) ;
		System.out.println("new erathostenes Sieve with string args");
		
		this.mainloop();
		this.print() ;
	}
*/
	
 
public abstract	boolean testloop(T token) ;
public abstract void mainloop() ;
	
	// setters
	public void setmax(BigInteger max) {
		this.maxprime = max ;
	}
	
	public void seteuler() {
		this.euler = this.euler.add(BigInteger.ONE) ;
	}
	
	// getters
	
	public BigInteger getmax() {
		return this.maxprime ;
		
	}
	
	
	public void print2() {
		this.print() ;
	}
	
	public void print() {
		
		System.out.print("S:"+this.euler+"->");
		//if (!(this.next==null))
		this.next.print() ;
		
	}

	public abstract	T get() ;
	
/*	public T get {
		return null ;

	}
	*/
	
	public BigInteger value() {
		
		return this.euler ;
	}

}
