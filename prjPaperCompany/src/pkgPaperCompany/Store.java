package pkgPaperCompany;

import java.io.BufferedReader;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Random;




public class Store {
	
	 String storeName;
		ArrayList<Customers> custs = new ArrayList<Customers>();
	    ArrayList<Otransactions> transaction = new ArrayList<Otransactions>();
	    Products[] product = new Products[4];
		 int custIndex = 0;
		 int orderIndex = 0;
		
		 
		  

	 Store()  {
		    
		   loadProducts();
		    loadCustomers();
		     loadTransactions();
		    
				
        }
	 
		 
		  void createAccount() {
		  
		  try {
			String fullname;
			String username;
			String password;
			String cardNumber = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			
			System.out.print("Enter your Full Name:");
			fullname = br.readLine();
			
			System.out.print("Enter the username you want to create: ");
			username = br.readLine();
			
			
			
			System.out.print("Enter the Password you want for your account: ");
			password = br.readLine();
			
			
			 
			System.out.print("Enter your cardNumber: ");
			cardNumber = br.readLine();
			
			
			// Test if card number is already in system
			for (int i = 0; i < custs.size(); i++) {
			while(cardNumber.equals(custs.get(i).getCardNumber())) {
			     System.out.print("Sorry Card Number already exists try again:");
				cardNumber = br.readLine();
				
			}
			
			}
			 
			
			
			// adds new customer to arraylist
			custs.add(new Customers (fullname,username,password,cardNumber));
			
			
			
			  // adds new customer to txt file
			 FileWriter fw = new FileWriter("customers.txt", true);
		  BufferedWriter bw = new BufferedWriter(fw);
			
	           
			 bw.write(custs.get(custs.size()-1).getFullname() + "," +
					 custs.get(custs.size()-1).getUsername()   +  ","  +
	   			     custs.get(custs.size()-1).getPassword() + "," + 
	   			    custs.get(custs.size()-1).getCardNumber() + "\n");
		
			  bw.close();
			
			System.out.println("Thanks for creating an account!");
		
			
		  } 
		  
		  catch (IOException e)
		    {
		      System.out.println("Error loading data");
		    }
		
		} // ends method
	  
	  
	  
	  boolean login()  {
		  
		  
		  try {
		  
		  String username = null;
		  String password = null;
		  boolean validate = false;
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  custIndex = -1;
		
		  
		    System.out.print("Enter your Username to login: ");
		 
		  username = br.readLine();
		
		   
		  
		  
		 for(int i = 0; i < custs.size(); i++) {
		  
    if (username.equals(custs.get(i).getUsername())) {
			  custIndex = i;
			 
			  
			    } 
		
		  }
		  
		  
		  if (custIndex > -1) {
			  
			 System.out.print("Enter your password: "); 
			
				password = br.readLine();
		 
			 
			 
			  if(password.equals(custs.get(custIndex).getPassword())) {
				 validate = true;
				  
				  System.out.println("Welcome " + custs.get(custIndex).getFullname());
				  
			  } 
			  }
		  
		  
    return validate;
		  
		  }	  
		  catch (IOException e) {
				System.out.println("Error loading data");
			}
		return false; 

	 } // ends method
	  
	  
	  
	  
	 
	  void placeOrder()  {
	 
	 try {
			 
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String productName = null;
			 
		  boolean validateProduct = false;
		  boolean validateQuantity = false;
		  String status = null;
		  int orderId = 0;
		  String timeStamp = null;
		  int quantityOH;
		 
			
			
			System.out.print("Enter the  Product Name you would like to purchase:");
			productName = br.readLine();
			 
			 do {
				 
				
				 for(int i = 0; i < product.length; i++) {
				 
					 
				 if(productName.equals(product[i].getProductName())) {
				
				 validateProduct = true;
				 orderIndex = i;
				 
				  }
			 
				 }
			 
	          if(!validateProduct) {
			
			 System.out.print("Sorry Product not available try again or click q to quit:");
			 productName = br.readLine();
			   
			    
			 
			    if(productName.equals("q")) {
			    	System.out.println("Thank you for using our program");
			    	System.exit(0);
					  
				 }
	    
				    }
			 
			   
			 
			 } while(validateProduct == false);
			 
			 
			 
			 System.out.print("How much of this Item will you purchase?");
			
			   quantityOH = Integer.parseInt(br.readLine());
				
		  do {
				  
				  
				   if(quantityOH > product[orderIndex].getQuantityOH()) {
				 System.out.print("There is only " + product[orderIndex].getQuantityOH() + " quantity remaining enter another amount:");
				quantityOH = Integer.parseInt(br.readLine());
			
				  
				 
				 } else {
				 validateQuantity = true;
				 status = "In transit";
				 
				 
				 // update quantity amount
				  product[orderIndex].setQuantityOH(quantityOH-product[orderIndex].getQuantityOH());
				 
				 // generate random number for OrderId
				 Random rn = new Random();
				 orderId = rn.nextInt(1000) + 1;
				 
				 // record purchase date
		    	 String pattern = "MM-dd-yyyy HH:mm:ss";
		    	    SimpleDateFormat formatter = new SimpleDateFormat(pattern);  
		    	     Date date = new Date();  
		    		 timeStamp = formatter.format(date);  
		    		 
		    		 
				  }
			 
			 
			  } while(validateQuantity == false);
			  
			  
			  // calculate total price
			  float   totalPrice = quantityOH * product[orderIndex].getPrice();
		  
	               
			  
			  
			 
			  
			  
			  
			   // adds transaction to txt file
			 FileWriter fw = null;
			
				fw = new FileWriter("order.txt", true);
			
		  BufferedWriter bw = new BufferedWriter(fw);
			
	           
			
				bw.write(orderId + "," +
						 custs.get((custIndex)).getCardNumber() +  ","  +
					     status  + "," + 
					   totalPrice + ", " + timeStamp + "\n");
			
		
			  
				bw.close();
			 
			  
			  transaction.add (new Otransactions( orderId, custs.get((custIndex)).getCardNumber(), status, totalPrice, timeStamp ));
			  
			
			//    transaction.get((transaction.size()-1)).setTransAmount(totalPrice);
			  
			  
			  
			  if(validateQuantity) {
			 System.out.println("Thank you for your purchase");
			  } 
			  
			  
	 }
	 
	 catch (IOException e) {
		 System.out.println("Error loading data");	
		}
	 
	 
	 catch (NumberFormatException e) {
			System.out.println("Wrong Number Format!");
			
		} 
		 
	 
   } // ends method
	  
	  
	  
	 
	void cancelOrder()  {
		
		try {
		  
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   String timeStamp;
		  int orderId = 0;
		  String status = "Cancelled";
		  FileWriter fw = new FileWriter("order.txt", true);
		  BufferedWriter bw = new BufferedWriter(fw);
		  int OrderIndex = 0;
		 
		 
		  System.out.print("Enter your orderID: ");
		  orderId =  Integer.parseInt(br.readLine());
		  
		  
		   
		  for(int i = 0; i < transaction.size(); i++) {
			  
			  if (orderId == transaction.get(i).getOrderID()) {
				  OrderIndex = i;
				 }
			  }
		  
		 
		  
		      // record purchase date
	    	 String pattern = "MM-dd-yyyy HH:mm:ss";
	    	    SimpleDateFormat formatter = new SimpleDateFormat(pattern);  
	    	     Date date = new Date();  
	    		 timeStamp = formatter.format(date);  
		  
		  bw.write(orderId + "," +
					 transaction.get(OrderIndex).getCardnum() +  ","  +
				     status  + "," + 
				   transaction.get(OrderIndex).getTransAmount() + ", " + timeStamp + "\n");
		  
		  bw.close();
		  
		  System.out.println("Order Cancelled");
		  
		  
		}
		
		catch (IOException e) {
				 System.out.println("Error loading data");	
				}
			
		}
	
	
	void shipOrder()  {
		
		
		try {
			  
			  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			   String timeStamp;
			  int orderId = 0;
			  String status = "Shipped";
			  FileWriter fw = new FileWriter("order.txt", true);
			  BufferedWriter bw = new BufferedWriter(fw);
			  int OrderIndex = 0;
			 
			  System.out.print("Enter your orderID: ");
			  orderId =  Integer.parseInt(br.readLine());
			   
			  for(int i = 0; i < transaction.size(); i++) {
				  
				  if (orderId == transaction.get(i).getOrderID()) {
					  OrderIndex = i;
					 
					   } 
				
				  }
			  
			     
			   // record purchase date
		    	 String pattern = "MM-dd-yyyy HH:mm:ss";
		    	    SimpleDateFormat formatter = new SimpleDateFormat(pattern);  
		    	     Date date = new Date();  
		    		 timeStamp = formatter.format(date);  
			  
			  bw.write(orderId + "," +
						 transaction.get(OrderIndex).getCardnum() +  ","  +
					     status  + "," + 
					   transaction.get(OrderIndex).getTransAmount() + ", " + timeStamp + "\n");
			  
			  bw.close();
			  
			  System.out.println("Order Shipped");
			  
			  
		}
		
		 catch (IOException e) {
			 System.out.println("Error loading data");	
			}
			  
			  
		}
		
		
		
	void displayOrder()
 
 {

   //ask for order ID
   try
   {
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   int id;
   int orderIndex = 0;
   System.out.println("What is your order ID?");
   id = Integer.parseInt(br.readLine());
   
   
   for(int i = 0; i < transaction.size(); i++) {
		  
		  if (id == transaction.get(i).getOrderID()) {
			  orderIndex = i;
			  System.out.println("Your order is below");
		      System.out.println(transaction.get(orderIndex).getOrderID() + " " + transaction.get(orderIndex).getCardnum() + " " + transaction.get(orderIndex).getStatus());
			 
			   } 
		
		  }
   
   
   
   }
   catch (IOException e) {
		    System.out.println("Error loading data");	
		    }

 }
	
	
	 void displayMenu()
  {

    System.out.println("*********************************");
    System.out.println("A: Place an order");
    System.out.println("B: Ship an order");
    System.out.println("C: Cancel an order");
    System.out.println("D: Display an order");
    System.out.println("E: Exit");
    System.out.println("Please enter an option:");
  }
	
	
	  
			 
	  
	  
	// adds the customers from a textfile to an arraylist
			void loadCustomers() {	
				
				try {
				
				//create the file for reading from
				FileReader fr = null;
				fr = new FileReader("customers.txt");
				BufferedReader br = new BufferedReader(fr);

				//create the variables for the file
				String n = "";
				String u = "";
				String p = "";
				String c = "";
				String eachLine = "";
				StringTokenizer st; 
				eachLine = br.readLine();
				
				
				
				while (eachLine != null)	
		           {
		              	st = new StringTokenizer(eachLine, ",");
		              	while (st.hasMoreTokens()) 
		              	{	

		              		n = st.nextToken();
		              		u = st.nextToken();
		              		p = st.nextToken();
		              		c = st.nextToken();
		              		custs.add (new Customers(n, u, p,c));	//add the customer to the ArrayList
		              		
		              		eachLine = br.readLine();
							
		              }//end of reading one line
		           }//end of reading the file
				
				
				 br.close();
				 
				 
               }
				
				catch (IOException e) {
					System.out.println("Error loading data");

					} // ends catch
				
				} //end of loadCustomers()
			
			
			void loadProducts() 
			
			{	
				
				try {
				
				//create the file for reading from
				FileReader fr=new FileReader("products.txt");  
				BufferedReader br = new BufferedReader(fr);

				//create the variables for the file
				int id = 0;
				String pn = "";
				float p = 0f;
				int qa = 0;
				
				//counter for the array
				int i = 0;

				//create the variables for each line
				String eachLine = "";
				StringTokenizer st; 
				
				eachLine = br.readLine();

				
          	while (eachLine != null)	
		           {	
		              	st = new StringTokenizer(eachLine, ",");
		              	while (st.hasMoreTokens()) 
		              	{	//remember the order of the text file
		              		id = Integer.parseInt(st.nextToken());
		              		pn = st.nextToken();
		              		p = Float.parseFloat(st.nextToken());
		              		qa = Integer.parseInt(st.nextToken());
		              		

		              		product[i] = new Products(id,pn,p,qa);	//add the product to the Array
		              		i++;	//increment the counter for the next line
		              		eachLine = br.readLine();//read the next line
					}//end of reading one line
		           }//end of reading the file
		           
				br.close();
				
				}
				
				catch (IOException e) {
					System.out.println("Error loading data");

					} // ends catch
				
				
			} //end of loadProducts()
			
			
			
			
void loadTransactions() {	
				
				try {
				
				//create the file for reading from
				FileReader fr = null;
				fr = new FileReader("order.txt");
				BufferedReader br = new BufferedReader(fr);

				//create the variables for the file
				 int id = 0;
				String cn = "";
				String s = "";
				float ta = 0f;
				String ts = "";
				String eachLine = "";
				StringTokenizer st; 
				eachLine = br.readLine();
				
				
				
				while (eachLine != null)	
		           {
		              	st = new StringTokenizer(eachLine, ",");
		              	while (st.hasMoreTokens()) 
		              	{	
                          id = Integer.parseInt(st.nextToken());
		              		cn = st.nextToken();
		              		s = st.nextToken();
		              		ta = Float.parseFloat(st.nextToken());
		              		ts = st.nextToken();
		              		transaction.add (new Otransactions(id,cn,s,ta,ts));	
		              		
		              		eachLine = br.readLine();
							
		              }//end of reading one line
		           }//end of reading the file
				
				
				 br.close();
				 
				 
               }
				
				catch (IOException e) {
					System.out.println("Error loading data");

					} // ends catch
				
				} //end of loadTransactions

}
