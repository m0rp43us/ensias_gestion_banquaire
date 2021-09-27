/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author trav1
 */
public class CompteEpargne extends Compte implements Comparable {
	private double tauxInteret;
	public CompteEpargne (String nom,double solde, double tauxInteret) {
		super(nom,solde);
		this.tauxInteret=tauxInteret;
	}
	
	public double getTauxInteret() {
		return this.tauxInteret;
	}
	
	/* public int compareTo(double M) {
		if (this.tauxInteret>M) {
			return 1;
		}
		if (this.tauxInteret<M) {
			return -1;
		}
		else { return 0;}
		
	}*/
	
	
	@Override
	public void deposer(double M) {
		this.setsolde(this.getsolde()+M*this.tauxInteret);  //*this.tauxInteret
	}
	public String ToString() {
		return "le compte de Mr "+ this.getnom() + " qui a le code: "+ this.getcode()+ " a le taux d'interet: " +this.getTauxInteret()+"\n";
	}
	public int compareTo(Object o) {
		if (this.tauxInteret>((CompteEpargne) o).getTauxInteret()) {
			return 1;
		}
		if (this.tauxInteret<((CompteEpargne) o).getTauxInteret()) {
			return -1;
		}
		else { return 0;}
		
	}
	
	
}

