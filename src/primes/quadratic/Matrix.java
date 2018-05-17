/**
 * @author MP
 */


package primes.quadratic ;

import java.math.BigInteger ;
import java.util.HashMap;
import java.util.Map.Entry;

import primes.Item ;
import primes.Bidimensional ;
//import primes.erathostenes.Token ;

class Matrix extends Item<Token> implements Bidimensional<Token> {
private	BigInteger entry ;
private	Item<Token> nextrow ;
private int ncols;
private int emod ;
private BigInteger rowparity ;
static private HashMap<BigInteger,BigInteger> mappa = new HashMap<BigInteger,BigInteger>();

/** Costruttore che inserisce un nuovo elemento <em>e</em>
       nella matrice  che continua con la riga n
       e la colonna nrow:
       @param n argomento di tipo Item che punta al resto della riga
       @param nrow argomento di tipo Item che punta al resto della colonna
       @param e il valore intero da inserire nella matrice
    */

	Matrix(Item<Token> n, Item<Token> nrow, BigInteger e) {
		super(n) ;
		
		//System.out.println("constructing Matrix object: next = "+n+" column = "+nrow+" entry = "+e);
		
		this.set(nrow, e);
	}
       
 /** Metodo setter che prende 
       @param nrow la prossima riga della matrice 
       @param e    valore da immettere
    */
private	void set(Item<Token> nrow, BigInteger e) {
		System.out.println("Q:M:set assigning exponent "+e);
		this.nextrow = nrow;
		this.entry = e;
		this.emod = e.mod(Token.TWO).intValue() ;
		
		if (nrow == null ) 
			{
				this.ncols = 1;
				this.rowparity = e.mod(Token.TWO) ;
			}
		else
			{
				
				if (this.next()==null)
					{
						this.ncols = 1;
						this.rowparity = e.mod(Token.TWO) ;
					}
				else
					{
						this.ncols = ((Matrix)this.next()).ncols + 1 ;
						if (this.emod == 0)
							this.rowparity = ((Matrix)this.next()).rowparity ;
						else
							this.rowparity = ((Matrix)this.next()).rowparity.add(Token.TWO.pow(this.ncols)) ;

					}
			}
	}
	// getters
	
/** Implementazione del Metodo get ereditato
	calcolo del rango della matrice (da fare)
	@return restituisce l'intero nel token
 */
public Token get() {
	return null ;
}

/** implementazione del metodo che restituisce
 *  il numero di righe della sotto-matrice
 *  individuata dall'elemento corrente
 */
	public int rows() {
		if (this.column() == null)
				return 1 ;
			else
				return ((Matrix)this.column()).rows()+1 ;
		
	}
	
/** implementazione del metodo value() ereditato
	@return restituisce il BigInteger dell'elemento della matrice
*/
public BigInteger value() {
	return this.entry;
     } 

/** implementazione di un metodo di stampa di una riga 
 * 	della matrice
 */

private void printrow() {
	//System.out.print("M:"+this.entry+"->") ;
	System.out.print(this.entry+" ("+this.rowparity+","+this.emod+")  ") ;
	if (!(this.next()==null)) ((Matrix)this.next()).printrow();
}

public void print() {
	this.printrow();System.out.println();
	if (!(this.column()==null)) this.column().print();
	else 
		System.out.println();
}

/**
 * This method gives back the reference to the next element
 * in the same column of the Matrix
 * @return the reference to the Item linked by nextrow attribute.
 */
public Item<Token> column () {
	return this.nextrow ;
	}

/** method quadratictest() is called by sieve when
 * a candidate is completely factored
 * @return true if there exits no combination of rows having rowparity equal to zero  
 */

public boolean quadratictest() {

	
	for(Entry<BigInteger, BigInteger> x : Matrix.mappa.entrySet()) Matrix.mappa.put(x.getKey().add(Token.TWO.pow(this.rows())) , x.getValue().xor(this.rowparity)  ) ;

	Matrix.mappa.put(Token.TWO.pow(this.rows()) , this.rowparity  ) ;

//	mappa.forEach((k, v) -> { mappa.put(k.add(Token.TWO.pow(this.rows())) , v.xor(this.rowparity)  );
	
	return (!Matrix.mappa.containsValue(BigInteger.ZERO));
}

void printmap() {
	System.out.println(Matrix.mappa);
}

void printrowparity() {
	System.out.print(this.rowparity+" ");
	if (this.column()!=null) ((Matrix)this.column()).printrowparity() ;
}

}
