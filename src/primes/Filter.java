package primes ;

import java.math.BigInteger ;

public abstract class Filter<T> extends Item<T> {
 private BigInteger prime ;

    // costruttori
public Filter(Item<T> tail, BigInteger p ) {
	System.out.println("new primes Filter");
	this.Set(tail,p) ;
    }

    // setters
public void Set(Item<T> tail, BigInteger p) {
	this.prime = p ;
	super.set(tail) ;
    }

    // getters
public void print() {
		
		System.out.print("F:"+this.prime+"->");
		//if (!(this.next==null))
		this.next.print() ;
		
	}

public abstract boolean test(T t) ;
	
	/*
	 {
		return (t.value().mod(this.value()).compareTo(BigInteger.ZERO) == 0) ;
	}
*/
	
	
public abstract T get() ;
	/*
		Token token;
		token=this.next.get() ;
		while (test(token)) token=next.get();
		return token;

	}*/
	
	
public	BigInteger value() {
		return this.prime ;
		
	}

}










