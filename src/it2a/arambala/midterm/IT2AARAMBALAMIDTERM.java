/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it2a.arambala.midterm;

import java.util.Scanner;

/**
 *
 * @author SCC-COLLEGE
 */
public class IT2AARAMBALAMIDTERM {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int choice =0;
        IT2AARAMBALAMIDTERM pres = new IT2AARAMBALAMIDTERM();
        String another = null;
        
        
        
        do{
        System.out.println("WELCOME TO PRESCRIPTION SYSTEM\n");
            System.out.println("___________________________\n");
        System.out.print("1. ADD PRESCRIPTION\n");
         System.out.print("2. VIEW PRESCRIPTION\n ");
         System.out.print("3. UPDATE PRESCRIPTION\n ");
         System.out.print("4. DELETE PRESCRIPTION\n");
            System.out.println("____________________________\n");
         
          System.out.print("Enter a choice:  ");
          choice = in.nextInt();
          
          switch (choice){
              
              case 1:
                  pres.addpres();
                  
                  
                  break;
                  
              case 2:
                  pres.viewpres();
                  break;
                  
              case 3:
                  pres.updatepres();
                  break;
                  
              case 4:
                  pres.deletepres();
                  break;
              
              
              
          }
          
          System.out.print("INPUT ANOTHER PRESCRIPTION (Yes|No):");
        another = in.nextLine();
        

        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
        
        
        }
          
        }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
        
        
        
        
        
    }
    int price = 0;

    public void addpres(){
        Scanner in = new Scanner (System.in);
        config conf = new config();
        
        String date = null;
        String name = null;
        int dosage = 0;
        String another = null;
        do {
        
        System.out.print("Enter the Prescription Date: ");
       date = in.nextLine();
        
       
       
        System.out.print("Enter the Medication Name: ");
         name = in.nextLine();
        
         while(true){
        System.out.print("Enter the dosage: ");
         String dosageInput = in.nextLine().trim();
         
         try{
    dosage = Integer.parseInt(dosageInput);
    if(dosage >= 0){
        break;
    }
    
    else {
        
        System.out.println("Dosage should not be a negative: ");
    }
    
    
}
catch (NumberFormatException e){
    System.out.println("Product Price Invalid");
    
}
         
         }
                String sql = "INSERT INTO Prescription ( prescription_date, medication_name,  dosage) VALUES (?, ?, ?)";

        
        conf.addRecord(sql, name,dosage , dosage);
         
         System.out.print("INPUT ANOTHER PRESCRIPTION (Yes|No):");
        another = in.nextLine();
        

        
        while(!another.equalsIgnoreCase("yes ") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
        
        
        }
        }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
    }
     public void viewpres(){
    
      config conf = new config();
    String test = "SELECT * FROM Prescription";
                String[] headers = {"prescription_id", "prescription_date", "medication_name", "dosage"};
                String[] Columns = {"prescription_id", "prescription_date", "medication_name", "dosage"};

    conf.viewRecords(test, headers, Columns);
    
}
     public void updatepres(){
         
         Scanner in = new Scanner (System.in);
         String date = null;
         String name = null;
         int dosage = 0;
         String another = null;
         config confi = new config();
         
         IT2AARAMBALAMIDTERM pres = new IT2AARAMBALAMIDTERM();
         
         do{
          pres.viewpres();
          System.out.print("Enter the ID you want to Update: ");
          int id = in.nextInt();
          in.nextLine();
          
          System.out.print("Enter the new Prescription Date: ");
       date = in.nextLine();
        
        System.out.print("Enter the new Medication Name: ");
         name = in.nextLine();
        
           while(true){
        System.out.print("Enter the dosage: ");
         String dosageInput = in.nextLine().trim();
         
         try{
    dosage = Integer.parseInt(dosageInput);
    if(dosage >= 0){
        break;
    }
    
    else {
        
        System.out.println("Dosage should not be a negative: ");
    }
    
    
}
catch (NumberFormatException e){
    System.out.println("Product Price Invalid");
    
}
           }
         
                
                String sql = "UPDATE Prescription SET prescription_date = ?, medication_name = ?, dosage = ? WHERE prescription_id = ?";
                
                
                confi.updateRecord(sql, date, name, dosage, id);
                
                
         System.out.print("UPDATE ANOTHER PRESCRIPTION (Yes|No):");
        another = in.nextLine();
                
                while(!another.equalsIgnoreCase("yes") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
                }
                
         }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
     }
         
         
         
     
     public void deletepres(){
         
         Scanner in = new Scanner(System.in);
          config del = new config();
          
          String another = null;
             IT2AARAMBALAMIDTERM pres = new IT2AARAMBALAMIDTERM();
          pres.viewpres();
          
          
          
          do{
          System.out.print("Enter the ID you want to delete: ");
        
          
           while(!in.hasNextInt()){
            System.out.println("Character is Invalid: ");
            System.out.print("Enter an ID again: ");
            in.nextLine();
            
        }
        int id = in.nextInt();
        in.nextLine();
          
          String deleteSQL = "DELETE FROM Prescription WHERE prescription_id = ?";
          
          del.deleteRecord(deleteSQL, id);
          
           System.out.print("UPDATE ANOTHER PRESCRIPTION (Yes|No):");
        another = in.nextLine();
                
                while(!another.equalsIgnoreCase("yes") && !another.equalsIgnoreCase("Yes") && !another.equalsIgnoreCase("YES") && !another.equalsIgnoreCase("no")
              &&  !another.equalsIgnoreCase("NO") && !another.equalsIgnoreCase("No")){
            
            System.out.print(" |INPUT INVALID| \n Try again: ");
            another=in.nextLine();
          
                }
          }while(another.equals("yes") || another.equals("Yes") || another.equals("YES"));
         
         
     
     
     
    
}
}