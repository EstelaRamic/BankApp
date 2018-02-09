import java.util.Scanner;
import java.util.ArrayList;


public class BankApp {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		call(input);
		input.close();
	}
		
	public static void call(Scanner input) {
		
		Bank bank = new Bank();
		
		int accNumber=0;
		String accName="";
		double accBalance=0;
		boolean added=false;
		boolean transfered= false;
		int choice=0;
		
		
		
		do{
			
			choice=showMenu(input);

		switch (choice){
		case 1:
			added = false;
			do {
				Customer acc = new Customer();
				System.out.println("Enter the account number(ID): ");
				accNumber=input.nextInt();
				acc.setAccountID(accNumber);
				
				System.out.println("Enter the account owner name: ");
				accName=input.next();
				acc.setCustomerName(accName);

				System.out.println("Enter the account balance: ");
				accBalance=input.nextInt();
				acc.setAccountBalance(accBalance);
				
				added=bank.addNewAccount(acc);
			} while (!added);
			break;
			
		case 2:
			
			transfered = false;
			int sourceID=0, targetID=0;
			double amount=0;
			do{
				System.out.println("Enter the source account number (ID):");
				sourceID=input.nextInt();
				
				System.out.println("Enter the target account number (ID): ");
				targetID=input.nextInt();
				
				do{
					System.out.println("Which amount do you transfer:");
					amount=input.nextDouble();
					if (amount<=0){
						System.out.println("*************************************************");
						System.out.println("Amount for transfer shoud be positive value.");
						System.out.println("*************************************************");
					};
				}while (amount<=0);
				
				transfered = bank.transfer(sourceID, targetID, amount);
			}while (!transfered);
			break;
		case 3:
			Customer acc = new Customer();
			int accNum=0;

			System.out.println("For which acoount number do you want information:");
			accNum = input.nextInt();
			acc = bank.isAccountExist(accNum);
			if (acc.getAccountID()==0){
				System.out.println("*************************************************");
				System.out.println("This account doesn't exist.");
				System.out.println("*************************************************");
			} else{
				System.out.println("*************************************************");
				System.out.println(acc.toString());
				System.out.println("*************************************************");
			}
			break;
		case 4:
			System.out.println("*************************************************");
			System.out.println("You choose to exit App. You are Welcome some other time.");
			System.out.println("*************************************************");
			break;
		}
		}while (choice!=4);

		
	}
	
	public static int showMenu(Scanner input){
		//Scanner ch = new Scanner(System.in);
		char choice='1';
		ArrayList<Character> validInputs = new ArrayList<>();
		validInputs.add('1');
		validInputs.add('2');
		validInputs.add('3');
		validInputs.add('4');
		
		do{
			if (!validInputs.contains(choice)) {
				System.out.println( "\nWrong input. Choose again.\n");
			}
			System.out.println("\nChoose an option:\n");
			System.out.println("*************************************************");
			System.out.print("1. Create new account \n");
			System.out.print("2. Make transaction \n");
			System.out.print("3. Get account information \n");
			System.out.print("4. Exit \n");
			System.out.println("*************************************************");
			choice = input.next().charAt(0);

		}while (!validInputs.contains(choice));
		
		//ch.close();
		
		return ((int) choice-48);
	}
	
	
}
