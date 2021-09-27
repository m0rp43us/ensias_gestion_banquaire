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
import java.util.Date;

public class Transaction  {
	private Date date;
	private int type;
	private double montant;
	
	public Transaction(Date date,int type,double montant) {
		this.date=date;
		this.type=type;
		this.montant=montant;
	}
	
	
	public String toString() {
		return "Transaction de type :" + this.type + "faite le "+this.date+" avec le montant : "+this.montant;
	}
	public Date getdate() {
		return this.date;
	}
	
	public int gettype() {
		return this.type;
	}
	
	public double getmontant() {
		return this.montant;
	}
}
