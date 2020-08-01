package pkgPaperCompany;

public class Customers {
	
	// class variables
		private String fullname;
		private String username;
		private String password;
		private String cardNumber;
		
		
		
		// default constructor
		public Customers() {
			
			fullname = "";
			username = "";
			password = "";
		 cardNumber = "";
			
			
		}
		
		
		
		// parameterized constructor 
		public Customers(String fullname, String username, String password, String cardNumber) {
			super();
			this.fullname = fullname;
			this.username = username;
			this.password = password;
			this.cardNumber = cardNumber;
		}
		
		

	  // getters and setters 

		public String getFullname() {
			return fullname;
		}



		public void setFullname(String fullname) {
			this.fullname = fullname;
		}



		public String getUsername() {
			return username;
		}



		public void setUsername(String username) {
			this.username = username;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getCardNumber() {
			return cardNumber;
		}



		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		
		} // ends getters and setters
		

}
