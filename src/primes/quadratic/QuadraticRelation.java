package primes.quadratic ;
import java.math.BigInteger;
class QuadraticRelation{
	BigInteger a ;
	BigInteger b ;
	
	QuadraticRelation(BigInteger a, BigInteger b) {
		this.Set(a,b);
	}
	
	void Set(BigInteger a , BigInteger b) {
		this.a =a ;
		this.b =b ;
	}
	
	BigInteger value1() {
		return this.a ;
		
	}
	
	BigInteger value2() {
		return this.b ;
		
	}
}


