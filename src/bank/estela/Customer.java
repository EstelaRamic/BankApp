
public class Customer {

		private int accountID;
		private String customerName;
		private double accountBalance;
		
		// construsctors
		public Customer(){
			this.accountID = 0;
			this.customerName = "";
			this.accountBalance = 0;
		}
		
		public Customer(int accountNumber, String customerName, double accountBalance) {
			this.accountID = accountNumber;
			this.customerName = customerName;
			this.accountBalance = accountBalance;
		}
		
		// The accessor and mutator methods
		public int getAccountID() {
			return accountID;
		}

		public void setAccountID(int accountID) {
			this.accountID = accountID;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public double getAccountBalance() {
			return accountBalance;
		}

		public void setAccountBalance(double accountBalance) {
			this.accountBalance = accountBalance;
		}

		// A method that withdraws a specified amount from the account.
		public void withdraw(double amount){
			this.accountBalance= this.accountBalance - amount;
		}
		
		// A method that deposits a specified amount to the account.
		public void deposit(double amount) {
			this.accountBalance = this.accountBalance + amount;
		}

		// print account information
		public String toString() {
			return "Account ID: " + this.accountID + "\nCustomer name: " + this.customerName + "\nAccount balance:" + this.accountBalance + "\n";
		
		}

}
