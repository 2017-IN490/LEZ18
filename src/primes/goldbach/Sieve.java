package primes.goldbach ;

import java.math.BigInteger ;

public class Sieve extends primes.Sieve<Token> {

    // costruttori
public Sieve(String[] args) {
	super(args,null);
	this.set(new Counter(this));
	this.mainloop();
	this.print2() ;

	}
	
public boolean testloop(Token token) {
		return (( token.value().compareTo(this.getmax()) != 1) && (!token.parity())) ;
	}
	
	
public void mainloop() {
		Token token ;
			//System.out.println("in main loop - before the first get");
		token = (Token) this.next().get() ;
	
		while (testloop(token)) {
			this.seteuler()  ;
			this.set( new Filter(this.next() , token.value() ));
			token = (Token) this.next().get() ;
		};
		
	}
	
public Token get() {
		return null ;
	}
}
