package primes.goldbach ;

import java.math.BigInteger ;
import primes.Item ;

class Filter extends primes.Filter<Token> {
// costruttori
	Filter(Item<Token> tail, BigInteger p ) {
		super(tail,p) ;
    }

	private boolean testprime(Token t){
		return (t.value().mod(this.value()).compareTo(BigInteger.ZERO) == 0) ;
		
	}
	
public boolean test(Token t) {
		if (t.parity())
			return this.testgoldbach(t) ;
		else
			return this.testprime(t) ;
	}
	
private boolean testgoldbach(Token t) {
		int tmp;
		//System.out.println("Goldbach test:");
		tmp = t.value().compareTo(this.value().add(t.top().value()));
		while (tmp == -1) {
			t.SetTop(t.top().next());
			tmp = t.value().compareTo(this.value().add(t.top().value())) ;
		};
		
		if (tmp == 0 ) System.out.println("Ok Goldbach: "+this.value()+"+"+t.top().value()+"="+t.value());
		
		return (tmp == 0) ;
	}
	
public Token get() {
	 	Token token;
	 	token= (Token) this.next().get() ;
	 	while (test(token)) token = (Token) this.next().get();
	 	return token;
	 
	 }
	
	

}










