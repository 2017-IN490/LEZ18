package primes.quadratic ;

import java.math.BigInteger ;

//import primes.erathostenes.Token;
public class Counter extends primes.Counter<Token> {
private	BigInteger factoring ; 
private BigInteger root ;
private Token ftok ;

public Counter() {
		super(new Token());
		this.ftok = new Token();
		this.ftoken().SetPrimality(false);
		this.token().SetPrimality(true);
	}

BigInteger squareroot ( BigInteger x) {
	BigInteger r = x.divide(Token.TWO);
    for ( int i = 0; i < 30; i++ ) {
            r = (r.add(x.divide(r))).divide(Token.TWO);
    }
    
    System.out.println("Q:C:squareroot of "+x+" is "+r);
    
    return r;
}

public Counter(BigInteger f) {
	// TODO Auto-generated constructor stub
	this();
	this.factoring = f ;
	this.root = squareroot(f).add(BigInteger.ONE) ;
	
}

BigInteger factoring() {
	return this.factoring;
	
}


public 	Token token() {
	return super.token();
}

public 	Token ftoken() {
	return this.ftok;
}


public Token get() {
	if (Sieve.mode)
		  {
		System.out.println("Q:C:get in prime generating mode ");
		this.token().Reset(this.value(), this.value());
			System.out.println("Q:C:get "+" sieving counter value "+this.value());

			this.set() ;
			return this.token() ;
		  }
	else
		{
		System.out.println("Q:C:get in candidate factoring mode ");
			BigInteger tmp =  this.setroot();
			System.out.println("Q:C:get "+" root is "+this.root+" factoring "+tmp);
			this.ftoken().Reset(this.root, tmp );
			return this.ftoken() ;
		}
		
		
}

BigInteger setroot() {
	BigInteger si;
	this.root = this.root.add(BigInteger.ONE);
	si = this.root.multiply(this.root).mod(this.factoring);
	while(si.compareTo(BigInteger.ZERO)==0){
		this.root = this.root.add(BigInteger.ONE);
		si = this.root.multiply(this.root).mod(this.factoring);
	}
	
	return si;
	
}


}
