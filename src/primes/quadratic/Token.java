/**
 * This new variant of the Token class has to manage
 * residuals of the factoring integer
 * @author MP
 */

package primes.quadratic ;

import java.math.BigInteger ;
//import primes.erathostenes.Sieve ;

class Token extends primes.erathostenes.Token {
	private BigInteger safenum ;
	private BigInteger candidate ;
	private boolean primality ;

	static final BigInteger TWO = new BigInteger("2");
	
	//costruttori
	Token() {
		System.out.println("new quadratic Token");
		this.Set(BigInteger.ZERO) ;
	}

	// setters
	public void Set(BigInteger n) {
		super.Set(n) ;
		//this.safenum = n;
		//this.primality = true ;
	}
	
	public void Reset(BigInteger r, BigInteger n) {
		super.Set(n) ;
		this.safenum = n;
		this.candidate = r ;
		//this.primality = true ;
	}
	
	public void SetPrimality(boolean b) {
		this.primality = b;
	}
	
	public BigInteger value2() {
		System.out.println("in quadratic Token "+this.safenum);
		return this.safenum ;
	}
	
	public BigInteger candidate() {
		System.out.println("in quadratic Token "+this.candidate);
		return this.candidate ;
	}
	
	boolean primality() {
		return this.primality;
	}
	
	boolean testincompletefactoring() {
		
		return (this.value().compareTo(BigInteger.ONE)!=0) ;
		
	}
}
