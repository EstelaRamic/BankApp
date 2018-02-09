import java.util.ArrayList;

public class Bank {

	private ArrayList<Customer> accounts= new ArrayList<Customer>();
	
	public Bank(){
		accounts.clear();
	}
	
	public void ispisSvihRacuna(){
		System.out.println("*************************************************");
		System.out.println(".................................................");
		for(Customer acc:accounts){
			System.out.println(acc);
	    }
		System.out.println(".................................................");
		System.out.println("*************************************************");
	}
	
	public Customer isAccountExist(int accID){
		
		Customer acc=new Customer();
		for(Customer a : accounts){
			
			if (a.getAccountID()==accID){
				return a;
			};
		}
		return acc;
	}
	
	public boolean addNewAccount(Customer newAcc){
		Customer acc = new Customer();
		int accID =newAcc.getAccountID();
		acc=isAccountExist(accID);

		if (acc.getAccountID()==0){
		
			if (newAcc.getAccountBalance()>0){
				accounts.add(newAcc);
				System.out.println("*************************************************");
				System.out.println("New account is added.");
				System.out.println("*************************************************");
				return true;
			} else{
				System.out.println("*************************************************");
				System.out.println("Cannot make account with negative balance.");
				System.out.println("*************************************************");
				return false;
			}
		}else {
			System.out.println("*************************************************");
			System.out.println("Source account already exist.");
			System.out.println("*************************************************");
			return false;
		}
		
	}
	
	public boolean transfer(int sourceAccount, int targetAccount, double amount){
		Customer accS = new Customer();
		int indexS;
		accS=this.isAccountExist(sourceAccount);
		indexS=accounts.indexOf(accS);
		
		Customer accT = new Customer();
		int indexT;
		accT=this.isAccountExist(targetAccount);
		indexT=accounts.indexOf(accT);
		
		if (accS.getAccountID()==0){
			System.out.println("*************************************************");
			System.out.println("Source account does not exist.");
			System.out.println("*************************************************");
			return false;
		} else if(accS.getAccountBalance()<amount){
			System.out.println("*************************************************");
			System.out.println("Sorce account balance is smaller than amount.");
			System.out.println("*************************************************");
			return false;
		} else if (accT.getAccountID()==0){
			System.out.println("*************************************************");
			System.out.println("Target account doesn't exist.");
			System.out.println("*************************************************");
			return false;
		} else{
			accS.withdraw(amount);
			accounts.set(indexS, accS);
			accT.deposit(amount);
			accounts.set(indexT, accT);
			System.out.println("*************************************************");
			System.out.println("Transaction was succesfull.");
			System.out.println("*************************************************");
			return true;
		}
	}
}
