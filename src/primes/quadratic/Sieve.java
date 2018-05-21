package primes.quadratic ;
import java.math.BigInteger;

//import primes.Item;
//import primes.Bidimensional ;
//import primes.erathostenes.Token;
public class Sieve extends primes.Sieve<Token> {
 BigInteger factoring ;
 static boolean mode ;

/**
 * In the extension of a class constructors arenot inherited
 */
public	Sieve (String[] args) {
		super(args, new Counter(new BigInteger(args[1]) )) ;
		Sieve.mode = false ; // factoring mode
		this.factoring = ((Counter)this.next()).factoring();
		System.out.println("Q:S factoring the number "+this.factoring);
		System.out.println("Q:S smoothness "+this.getmax());
		System.out.println("constructing quadratic Sieve");
	
		this.mainloop();
		this.print() ;
	}

	
	
public	boolean testloop(Token factortoken) {
	//BigInteger safenum,candidate,residue ;
	Token primetoken ;
	boolean result ;
	
	System.out.println("factoring token in testloop:\n residue :"+factortoken.value()+" intero: "+factortoken.value2());
	
	while (factortoken.testincompletefactoring())
	{
		// passo in modalita generazione
		Sieve.mode= true ; // generating mode
//		primetoken.SetPrimality(Sieve.mode);
		primetoken = this.next().get();
		
		this.seteuler() ;
		this.set( new Filter(this.next() , primetoken.value(),factortoken));	
	}
	
	Sieve.mode = false;
	result = ((Matrix)((Filter)this.next()).column()).quadratictest() ;
	System.out.println("Q:S:testloop back to generatig mode, testing quadratic relation ("+result+")");
	
	return result ;
}
	
/**
 * @override of the erathosenes.Sieve mainloop
 * the only difference is on the test of
 * the primality boolean in order to create a new Filter objet
 */
	public void mainloop() {
		Token factoringtoken ;
		
		
//		factoringtoken.SetPrimality(Sieve.mode);
		factoringtoken = (Token) this.next().get() ;
		System.out.println("in Q:S:mailoop before while "+factoringtoken.value2());
		
		//genera candidati finche' non trovo la combinazione
		//di righe nulla
		while (testloop(factoringtoken)) {
			
			factoringtoken = (Token) this.next().get() ;
			this.printmatrix();
			
		}
		
		
		
		
		//System.out.println("in Q:S:mailoop after while : ready to new S:get()");
		//factoringtoken = this.next().get() ;
			
		//System.out.println("in Q:S:mailoop new integer : "+factoringtoken.value2()+" "+factoringtoken.value());
		
	}
	
	public void printmatrix() {
		/* bisogna essere sicuri che si ha un Filter o un Matrix */
		((Filter)this.next()).column().print() ;
		//((Matrix)((Filter)this.next()).column()).printmap() ;
		((Matrix)((Filter)this.next()).column()).printrowparity() ;
	}

	public Token get() {
		return null ;
	}

}
