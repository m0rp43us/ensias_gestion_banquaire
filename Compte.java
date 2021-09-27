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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Calendar;


public  class Compte {
	private static int i=0;
	private String nom;
	private double solde;
	private int code;
	//Transaction[] transaction;
	public static final int nbTransact=100;
	public int nbLigneRéel;
	
	 ArrayList<Transaction> transaction1;
	
	public void deposer(double montant) {
		this.solde=this.solde+montant;
	}
	
	public void retirer(double montant){
		this.solde=this.solde-montant;
	}
	
	/*public  String toString() {
		return "le compte de Mr "+ this.nom+ " qui a le code: "+ this.code+ " et le solde: " +this.solde+"\n";
	}*/
	//abstract public String ToString();
	
	public Compte(String nom, double solde) {
		this.nom=nom;
		this.solde=solde;
		/*this.code=i+1;
		i++;*/
		this.code=++i;
		this.transaction1=new ArrayList<Transaction>(); //
		this.nbLigneRéel=-1;
		
	}
	public void addTransaction(int type,double montant) {
		if (type==1 && this.solde<montant) {
			System.out.println("le solde n'est pas suffisant!");
		}
		else if (nbLigneRéel+1<=nbTransact) {
			/*transaction[nbLigneRéel+1]=Obj;//++nbLigneRéel;
			//transaction[++indice]=montant;
			nbLigneRéel+=1;
			//indice++;
		}
		else {
			System.out.println("Vous avez dépasser le nombre maximal des transactions!!");
		*/
			Calendar c=Calendar.getInstance();
			Date date=c.getTime();
			
			
			
			Transaction trans= new Transaction(date,type,montant);
			transaction1.add(trans);
			nbLigneRéel+=1;
			if (type==0) {
					this.deposer(montant);
			}
			else {
					this.retirer(montant);
			}
		
		}
	}
	public void afficher() {
		Iterator<Transaction> iterator=transaction1.iterator();
		while(iterator.hasNext()) {
			//System.out.println("Transaction faite le :"+ transaction[i].getdate()+" de type : "+ transaction[i].gettype()+" d'un montant de : "+transaction[i].getmontant());
			Transaction t= (Transaction) iterator.next();//cast to Transaction!!!
			System.out.println("Transaction faite le :"+ t.getdate()+" de type : "+t.gettype()+" d'un montant de : "+t.getmontant());
		}
	}
	
	public String getnom() {
		return this.nom;
	}
	public double getsolde() {
		return this.solde;
	}
	public int getcode() {
		return this.code;
	}
	public void setsolde(double somme) {
		this.solde=somme;
	}
	
	
	
	
}
	

