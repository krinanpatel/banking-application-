import java.util.Scanner;
public class Account { //account connected w KPBank.java file
 int balance;
 int previousTransaction;     //Class variables
 String customerName;
 String customerID;

 Account (String cName, String cID){
    customerName = cName;      //Class Constructor
    customerID = cID;

 }
 void deposit (int amount){
     if (amount !=0){
         balance = balance + amount;         //Function for adding Money
         previousTransaction= amount;
     }
 }
  void withdrawl (int amount){
      balance = balance-amount;
      previousTransaction= -amount;             //Function for withdrawing money
  }

  void getpreviousTransaction (){
      if (previousTransaction>0){
          System.out.println("Deposited: $" + previousTransaction);
      }
      else if (previousTransaction<0){
          System.out.println("Withdrawed: $" + Math.abs(previousTransaction));
      }
  }
  void Interest (int years){
      double InterestRate=0.185; //annual interest rate -- needs to be updated anually. Last update: 07/2022
      double newBalance= (balance * InterestRate * years) + balance;         //This overall calculate the interest rate and what the new balance will be after x number of years
      System.out.println("The current annual interest rate is: " + InterestRate);
      System.out.println("Your new balance, after "+years+"years will be: $"+ newBalance);
  }
  void ShowMenu(){
      char choices = '0';
      Scanner scanner = new Scanner (System.in);
      System.out.println("Welcome " +customerName+" to your Bank Account!");
      System.out.println("Your ID is "+customerID);
      System.out.println("                      ");
      System.out.println("What would you like to do today?");
      System.out.println("                      ");
      System.out.println("A: Check your current balance");
      System.out.println("B: Make a deposit");
      System.out.println("C: Withdraw money");
      System.out.println("D: Calculate interest");
      System.out.println("E: View your previous transaction");
      System.out.println("F: Leave");



  do {
      System.out.println();
      System.out.println("Enter an option below: ");
      char choice1=scanner.next().charAt(0);
      choices = Character.toUpperCase(choice1);
      System.out.println();
      switch (choices){
          case 'A': 
            System.out.println("_________________________________________________________________________");
            System.out.println ("Balance = $" +balance);
            System.out.println("_________________________________________________________________________");
            System.out.println();
            break;
          case 'B':
            System.out.println("What amount would you like to depost?");
            int amount = scanner.nextInt();
            deposit(amount);
            System.out.println();
            break; 
         case 'C':
            System.out.println("What amount would you like to withdraw?");
            int amount2 = scanner.nextInt();
            withdrawl(amount2);
            System.out.println();
            break; 
         case 'D': 
            System.out.println("How many years of interest would you like to calculate?");
            int years=scanner.nextInt();
            Interest(years);
            System.out.println();
            break;
         case 'E': 
            System.out.println("_________________________________________________________________________");
            getpreviousTransaction();
            System.out.println("_________________________________________________________________________");
            System.out.println();
            break;
         case 'F':
            System.out.println("_________________________________________________________________________");
            break;  
        default: 
            System.out.println("Oh no! You've encountered an error. Please enter a valid option and try again!");
      } 
    }
    while (choices != 'F');
         System.out.println("Thank you for banking with us!");
  }
}
  
