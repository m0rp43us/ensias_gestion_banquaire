package metier;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trav1
 */
public class connector_utilisateur {
    private String password="mysql";
    
    
    public String[] getInfo(String Login) throws SQLException, ClassNotFoundException   {   // cette fct retorne un array de valeurs qui sont dans la base de donner des personnels.
                String url="jdbc:mysql://localhost:3306/Personnels";
                String url1="jdbc:mysql://localhost:3306/gestionbancaire";
              String val[]=new String[3];
              String val1[]=new String[3];
            Connection conn =DriverManager.getConnection(url,"root",password);
            
            Class.forName("com.mysql.jdbc.Driver");
		//Statement stmt=(Statement) conn.createStatement();
		String req="Select * from coordone where nompr=?;";
                String req1="Select * from coordone_client where login=?";
	    PreparedStatement pre=conn.prepareStatement(req);
            
	    pre.setString(1,Login);
	    ResultSet res=pre.executeQuery();
            // close
           
            
           
	   
            boolean donnees_exist=false,donnees_exist1=false;  // cette variable va nous donner l'affirmation que le login entrer exist ou nom.
            while(res.next()) {
                //System.out.println("ds la bcl while");
                donnees_exist=true;
			val[0]=res.getString(1);// la valeur de la 1ere colonne càd la colonne nompr.
                        val[1]=res.getString(2);// la valeur de la 2eme colonne càd la colonne passwd.
                        val[2]=res.getString(3);// la valeur de la 3eme colonne càd la colonne type_empl.
	    }
            if (donnees_exist==false)val[0]="true";
            res.close();
            pre.close();
            //conn.close();
            if (donnees_exist==false){  //il s'agit bien d'un client.
                 conn =DriverManager.getConnection(url1,"root",password);
                PreparedStatement pre1=conn.prepareStatement(req1);
                pre1.setString(1,Login);
                ResultSet res1=pre1.executeQuery();
                while(res1.next()) {
//                    System.out.println("ds la bcl while");
                    donnees_exist1=true;
                    val1[0]=res1.getString(2);// la valeur de la 2eme colonne càd le login.
                    val1[1]=res1.getString(3);// la valeur de la 3eme colonne càd la colonne du password.
                    val1[2]="client"; // on indique qu'il s'agit d'un client.
                }
                res1.close();
                pre1.close();
                res.close();
                pre.close();
                conn.close();
                if (donnees_exist1==true)return val1;
            }
            
            //  res.close();
            //pre.close();
            //conn.close();
            if (donnees_exist==true && donnees_exist1==true){  // dans ce cas l'employe est un client de la banque, il va etre connecter en tant que employe.
                return val;
            }
            
            return val;
}
 
    public String setClient(String[] str) throws SQLException, ClassNotFoundException{
        //String password="mysql";
                //String url1="jdbc:mysql://localhost:3306/Personnels";
                String url="jdbc:mysql://localhost:3306/gestionbancaire";
              
            Connection conn =DriverManager.getConnection(url,"root",password);
            
            Class.forName("com.mysql.jdbc.Driver");
		//Statement stmt=(Statement) conn.createStatement();
		//String req2="Select * from coordone where nompr=?;";
                //String req1="Select * from coordone_client where login=?";
            
            String req="insert into client(nom,prenom,CIN,ville,adresse,tel,email,Agence)values(?,?,?,?,?,?,?,?)";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            
                 pre.setString(1,str[1]);
                 pre.setString(2,str[2]);
                 pre.setString(3,str[0]);
                 pre.setString(4,str[5]);
                 pre.setString(5,str[4]);
                 pre.setString(6,str[6]);
                 pre.setString(7,str[7]);
                 pre.setString(8,str[3]);
                 
            
	   
	    int nb=0;
                  nb=pre.executeUpdate();
                  
            pre.close();      
            conn.close();      
            if (nb!=0){
                return "succes";
            }
            return "echec";
    }
    public String[] getClientInfos(String CIN) throws SQLException, ClassNotFoundException{
        //String password="mysql";
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
        Connection conn =DriverManager.getConnection(url,"root",password);
        Class.forName("com.mysql.jdbc.Driver");
		
            String req="select * from client where CIN=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setString(1,CIN);
            ResultSet res=pre.executeQuery();
            String[] str=new String[9];
            
            while(res.next()){
                str[0]=res.getString(1);
                str[1]=res.getString(2);
                str[2]=res.getString(3);
                str[3]=res.getString(4);
                str[4]=res.getString(5);
                str[5]=res.getString(6);
                str[6]=res.getString(7);
                str[7]=res.getString(8);
                str[8]=res.getString(9);
            }
            res.close();
            pre.close();
            conn.close();
            //System.out.println(str);
            return str;
    }
    
    public String toString(String[] str){
        return "code :  "+str[0]+"   nom :"+str[1]+"  prenom : "+str[2]+"   CIN :"+str[3]+"    Ville :"+str[4]+"    Adresse : "+str[5]+"   tel :"+str[6]+"     e-mail :"+str[7]+"      Agence :"+str[8];
    }
    
    
    public String updateClient(String[] str) throws SQLException, ClassNotFoundException{
        //String password="mysql";
                //String url1="jdbc:mysql://localhost:3306/Personnels";
                String url="jdbc:mysql://localhost:3306/gestionbancaire";
              
            Connection conn =DriverManager.getConnection(url,"root",password);
            
            Class.forName("com.mysql.jdbc.Driver");
		//Statement stmt=(Statement) conn.createStatement();
		//String req2="Select * from coordone where nompr=?;";
                //String req1="Select * from coordone_client where login=?";
            
            String req="update client set nom=?,prenom=?,CIN=?,ville=?,adresse=?,tel=?,email=?,Agence=? where CIN=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            
                 pre.setString(1,str[1]);
                 pre.setString(2,str[2]);
                 pre.setString(3,str[0]);
                 pre.setString(4,str[5]);
                 pre.setString(5,str[4]);
                 pre.setString(6,str[6]);
                 pre.setString(7,str[7]);
                 pre.setString(8,str[3]);
                 pre.setString(9,str[8]);
                 
           
           
	    int nb=0;
                  nb=pre.executeUpdate();
            
            pre.close();      
            conn.close();
            if (nb!=0){
                return "succes";
            }
            return "echec";
    }
    
    public String deleteClient(String CIN) throws SQLException, ClassNotFoundException{
        //String password="mysql";
                //String url1="jdbc:mysql://localhost:3306/Personnels";
                String url="jdbc:mysql://localhost:3306/gestionbancaire";
              
            Connection conn =DriverManager.getConnection(url,"root",password);
            
            Class.forName("com.mysql.jdbc.Driver");
		//Statement stmt=(Statement) conn.createStatement();
		//String req2="Select * from coordone where nompr=?;";
                //String req1="Select * from coordone_client where login=?";
            
            String req="delete from client where code not in (select code from compte) and CIN=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setString(1, CIN);
            
                 
            
	   
	    int nb=0;
                  nb=pre.executeUpdate();
            pre.close();
            conn.close();
                  
            if (nb!=0){
                return "succes";
            }
            return "echec";
    }
    
    public String getcheckClient(String cin) throws SQLException, ClassNotFoundException{
        //String password="mysql";
                //String url1="jdbc:mysql://localhost:3306/Personnels";
                String url="jdbc:mysql://localhost:3306/gestionbancaire";
              
            Connection conn =DriverManager.getConnection(url,"root",password);
            
            Class.forName("com.mysql.jdbc.Driver");
		//Statement stmt=(Statement) conn.createStatement();
		//String req2="Select * from coordone where nompr=?;";
                //String req1="Select * from coordone_client where login=?";
            
            String req="select count(*) from client where CIN=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setString(1, cin);
            ResultSet res;
         
            
	   res=pre.executeQuery();
           int nbr=0;
           while(res.next()) {
               nbr=res.getInt(1);
           }
           res.close();
           pre.close();
           conn.close();
           if (nbr==0){
               return "notfound";
           }
           return "found";
    }
    
    public int getCheckClientCompte(String CIN) throws SQLException, ClassNotFoundException{  // retourne le nombre de comptes pour un client donné.
            String url="jdbc:mysql://localhost:3306/gestionbancaire";
             Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
            String req="select count(*) from compte where code=(select code from client where CIN=?)";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setString(1, CIN);
            ResultSet res;
         
	   res=pre.executeQuery();
           int nbr=0;
           while(res.next()) {
               nbr=res.getInt(1);
           }
           //System.out.println(nbr);
           res.close();
           pre.close();
           conn.close();
           return nbr;
           
    }
    
    public String setCompte(double solde,String type,String CIN) throws ClassNotFoundException, SQLException{ // str contient les informationts du compte.
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
            String req="select code from client where CIN=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setString(1, CIN);
            ResultSet res;
	   res=pre.executeQuery();
           int code=-1;
           while(res.next()) {
               code=res.getInt("code");
           }
           System.out.println(code);
           String req1="insert into compte(solde,type_compte,code) values(?,?,?)";
           PreparedStatement pre1=conn.prepareStatement(req1);
            
           pre1.setDouble(1,solde);
           pre1.setString(2, type);
           pre1.setInt(3,code);
            
            int nbr=0;
            //nbr=pre1.executeUpdate();
            res.close();
            pre.close();
            conn.close();
            
            if (nbr!=0){
                return "succes";
            }
           return "echec";
            
           
    }
    
    
    public String setCompte1(double solde,String type,String CIN,double dec_taux) throws ClassNotFoundException, SQLException{ // str contient les informationts du compte.
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
            String req="select code from client where CIN=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setString(1, CIN);
            ResultSet res;
	   res=pre.executeQuery();
           int code=-1;
           while(res.next()) {
               code=res.getInt("code");
           }
           System.out.println(code);
           String req2="select count(*) from comptes where type_compte='Courant' and code=?";
           String req3="select count(*) from comptes where type_compte='Epargne' and code=?";
           String req1="insert into compte(solde,type_compte,code,decouvert_taux,'non') values(?,?,?,?)";
           PreparedStatement pre2=conn.prepareStatement(req2);
            PreparedStatement pre3=conn.prepareStatement(req3);
            pre2.setInt(1,code);
            pre3.setInt(1,code);
           ResultSet res2=pre2.executeQuery();
           ResultSet res3=pre3.executeQuery();
           int nbr1=2,nbr2=2;   
           
           while(res2.next()) {
               nbr1=res2.getInt(1);
           }
           while(res3.next()) {
               nbr2=res3.getInt(1);
           }
           if (type.equals("Courant") && nbr1!=0) return "echec";
           if (type.equals("Epargne") && nbr2!=0) return "echec";
           
           PreparedStatement pre1=conn.prepareStatement(req1);
            
            
           pre1.setDouble(1,solde);
           pre1.setString(2, type);
           pre1.setInt(3,code);
            pre1.setDouble(4, dec_taux);
            int nbr=0;
            nbr=pre1.executeUpdate();
            res.close();
            pre.close();
            conn.close();
            
            if (nbr!=0){
                return "succes";
            }
           return "echec";
            
           
    }
    
     public String[] getCompte1(String CIN,int cho) throws ClassNotFoundException, SQLException{ 
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
            String req="select code from client where CIN=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setString(1, CIN);
            ResultSet res;
	   res=pre.executeQuery();
           int code=-1;
           while(res.next()) {
               code=res.getInt("code");
           }
           System.out.println(code);
           String  req1="";
          if (cho==1) req1="select * from compte where type_compte='Courant' and code=?";
          if (cho==0) req1="select * from compte where type_compte='Epargne' and code=?";
           PreparedStatement pre1=conn.prepareStatement(req1);
            
           pre1.setDouble(1,code);
           ResultSet res1;
           res1 = pre1.executeQuery();
            
           double solde=-1;
           int code1=-1;
           double decouvert=-1;
           
           while(res1.next()) {
               solde=res1.getDouble(2);
               code1=res1.getInt(4);
               decouvert=res1.getDouble(5);
           } 
           String str[]=new String[3];
           String t="";
           t=t+solde;
           str[0]=t;
           t="";
           t=t+code1;
           str[1]=t;
           t="";
           t=t+decouvert;
           str[2]=t;
           t="";
           return str;
     }
    
    public String setCompteSolde(double solde,String CIN) throws ClassNotFoundException, SQLException{ // str contient les informationts du compte.
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
            String req="select code from client where CIN=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setString(1, CIN);
            ResultSet res;
	   res=pre.executeQuery();
           int code=-1;
           while(res.next()) {
               code=res.getInt("code");
           }
           System.out.println(code);
           
           String req1="Update compte set solde=? where code=?";
           
            
       
           PreparedStatement pre1=conn.prepareStatement(req1);
            
            
           pre1.setDouble(1,solde);
           pre1.setInt(2,code);
            
            int nbr=0;
            nbr=pre1.executeUpdate();
            res.close();
            pre.close();
            conn.close();
            
            if (nbr!=0){
                return "succes";
            }
           return "echec";
            
           
    }
    
    public String setSupprimerCompte(int code) throws SQLException, ClassNotFoundException{
         String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
            String req="select count(*) from transaction where code_tr=?";
           
	    PreparedStatement pre=conn.prepareStatement(req);
            pre.setInt(1, code);
            ResultSet res;
	   res=pre.executeQuery();
           int nbr=-1;
           while (res.next()){
               nbr=res.getInt(1);
           }
           if (nbr==0){
               String req1="delete from compte where idcompte=?";
               PreparedStatement pre1=conn.prepareStatement(req1);
               pre1.setInt(1,code);
               int nb=-1;
               nb=pre1.executeUpdate();
               if (nb!=0){
                   return "succes";
               }
               return "echec";
           }
           else{
               String req2="update compte set etat_inactif='oui' where idcompte=?";
               PreparedStatement pre2=conn.prepareStatement(req2);
               pre2.setInt(1,code);
               int nb1=-1;
               nb1=pre2.executeUpdate();
               if (nb1!=0){
                   return "succes";
               }
               return "echec";
           }
           
           
    }
    
    public String[] getTransaction(int code) throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
        
            String req="select * from transaction where code_tr=?";
               PreparedStatement pre=conn.prepareStatement(req);
               pre.setInt(1,code);
               
               ResultSet res;
               res=pre.executeQuery();
               String[] str=new String[5];
               String t="";
               int id,type,code_tr;
               double montant;
               Date d;
               while(res.next()){
                   id=res.getInt(1);
                   d=res.getDate(2);
                   type=res.getInt(3);
                   montant=res.getDouble(4);
                   code_tr=res.getInt(5);
                   t=t+id;
                   str[0]=t; t=""; t=t+d; str[1]=t; t=""; t=t+type;  str[2]=t; t=""; t=t+montant;str[3]=t;t="";t=t+code_tr;str[4]=t;t="";
               }
               return str;
        }
                   
    public String setAgence(int code,String libele,String d,String ville,String adresse) throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
        
            String req="insert into agence values(?,?,?,?,?,'non')";
               PreparedStatement pre=conn.prepareStatement(req);
               pre.setInt(1,code);
               pre.setString(2,libele);
               pre.setString(3,  d);
               pre.setString(4,ville);
               pre.setString(5,adresse);
               
               int nbr;
               nbr=pre.executeUpdate();
        
               if (nbr!=0){
                   return "succes";
               }
               if (nbr==0) return "echec";
              return "echec"; 
    }
   
    public String[] getInfoAgence(int code) throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
        
            String req="select code,libelé,date_creation,ville,adresse from agence where code=?";
            PreparedStatement pre=conn.prepareStatement(req);
            pre.setInt(1, code);
            ResultSet res;
            res=pre.executeQuery();
            String[] str=new String[6];
            String t="";
            int code1;
            while (res.next()){
                code1=res.getInt(1);
                t=t+code1; str[0]=t; t="";
                str[1]=res.getString(2);
                str[2]=res.getString(3);
                str[3]=res.getString(4);
                str[4]=res.getString(5);
            }
            return str;
            
    }
    
    public String setInfoAgence(int code,String libele,String date_creation,String ville,String adresse) throws SQLException, ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
        
            String req="update agence set code=?,libelé=?,date_creation=?,ville=?,adresse=? where code=?";
            PreparedStatement pre=conn.prepareStatement(req);
            pre.setInt(1, code);
            pre.setString(2, libele);
            pre.setString(3,date_creation);
            pre.setString(4,ville);
            pre.setString(5, adresse);
            pre.setInt(6, code);
            int nbr=0;
            nbr=pre.executeUpdate();
            
            if (nbr!=0){
                return "succes";
            }
            return "echec";
    }
    
    public String deleteagency(int code) throws SQLException, ClassNotFoundException{
         String url="jdbc:mysql://localhost:3306/gestionbancaire";
          Connection conn =DriverManager.getConnection(url,"root",password);
            Class.forName("com.mysql.jdbc.Driver");
            //String req1="select count(*) from client where Agence=?";
            String req="delete from agence where code=?";
            PreparedStatement pre=conn.prepareStatement(req);
            pre.setInt(1,code);
            //PreparedStatement pre1=conn.prepareStatement(req1);
            //String t=""; t=t+code;
            //pre1.setString(1,t);
            //ResultSet res = null;
            int nombre = -2;
            //while(res.next()){
           //     nombre=res.getInt(1);
            //}
                
            
            int nbr=0;
          //if (nombre==0){
            nbr=pre.executeUpdate();
            if (nbr!=0){
                return "succes";
          }
            return "echec";
            
            
            
    }
    
    
    
    
    
    
    
    
}
