package pkgPaperCompany;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StoreSystem {

	public static void main(String[] args) {
		
		
		try {

		       
		      Store m1 = new Store();
				  boolean validate = false;
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      char choice1,choice2 = 'x';
		      

		      System.out.println("Hello Welcome to the Michael Scott Paper Company! ");
		     System.out.println();
				System.out.print("Type c to create an Account or type l to login: ");
				choice1 = (char)br.read();
				
				if(choice1 == 'c') {
				m1.createAccount();
					
				}
		      
		      
		       if(choice1 == 'l' || choice1 == 'c') {
		   
		        
		        // allow the user only 3 times to log in
		      for (int i = 0; i < 3; i++) {
				     validate = m1.login();
				     
				     if(validate) {
				    	 break;
				    	 
				   }
				     
				     if(i < 2) {
				    	System.out.println("Invalid, Try Again"); 
				    	 
				     }
				    if(i == 2 ) {
				    	 System.out.println("Invalid, System Terminated");
		           System.exit(0);
				     }
				     
				    }

		            }

		      
		          do{
		          m1.displayMenu();
		         
		          //ignore enter key
		          choice2 = (char)br.read();
		          choice2 = (char)br.read();
		          choice2 = (char)br.read();
		          
		         

		          if(choice2 < 'A' || choice2 > 'E')
		         {

		           System.out.println("Invalid choice, please enter again:");
		          
		          }
		        
		        else{

		        if(choice2 == 'A')
		           m1.placeOrder();
		          else if(choice2 == 'B')
		            m1.shipOrder();
		         else if(choice2 == 'C')
		            m1.cancelOrder();
		        else if(choice2 == 'D')
		           m1.displayOrder();
		        
		        else if(choice2 == 'E')
			        System.exit(0);
		        
		        }
		       }while(choice2 != 'E');
		          
		   
		   
		   
		    }
		    catch(IOException e)
		    {

		      System.out.println("Error loading data");

		    }
		

	}

}
