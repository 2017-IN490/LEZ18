/*** implementazione del crivello di ertaostene
 *
 * @author Marco Pedicini
 **/

import primes.quadratic.Sieve ;

public class lezione {
	
	public static void main(String[] args) {
		Sieve lista ;
		
		lista = new Sieve(args) ;
	// test
		lista.printmatrix();
		return ;
	}
	
}

