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
public class CompteCourant  extends Compte implements Comparable   { 
	private double decouvertAutorisé;
	
        public CompteCourant(String nom,double solde, double decouvertAutorisé) {
		super (nom,solde);
		this.decouvertAutorisé=decouvertAutorisé;
	}
	
	public double getDecouvertAutorisé() {
		return decouvertAutorisé;
	}
	
	@Override 
	public void retirer(double somme) {
		if (this.getsolde()+this.decouvertAutorisé>somme) {// this.getsolde() ou bien je change solde en public.
			this.setsolde(this.getsolde()-somme);
		}
	}
	
	public String ToString() {
		return "le compte de Mr "+ this.getnom()+ " qui a le code: "+ this.getcode()+ " a le decouvert autorisé : " +this.getDecouvertAutorisé()+"\n";
		}
	
	public int compareTo(Object o) {
		if (this.decouvertAutorisé>((CompteCourant)o).getDecouvertAutorisé()) {  
			return 1;
		}
		if (this.decouvertAutorisé<((CompteCourant) o).getDecouvertAutorisé()) {
			return -1;
		}
		else { return 0;}
		
	}
	
	}

