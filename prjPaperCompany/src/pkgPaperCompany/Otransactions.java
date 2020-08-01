package pkgPaperCompany;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Otransactions {
	
	
	private int orderID;
	  private String cardnum;
		private String status;
		private float transAmount;
		private String timestamp;
		
	  //default constructor
		public Otransactions()
	  {
	    
	    orderID = 0;
	    cardnum = "";
	    status = "";
	    transAmount = 0.00f;
	    timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	  }

	  //overloaded constructor
	  public Otransactions(int orderID, String cardnum, String status, float transAmount, String timestamp) 
		{

			this.orderID = orderID;
			this.cardnum = cardnum;
			this.status = status;
			this.transAmount = transAmount;
			this.timestamp = timestamp;

		}
	  
	  //getters and setters
	  public int getOrderID() 
	  {
			return orderID;
		}

		public void setOrderID(int orderID) 
	  {
			this.orderID = orderID;
		}

		public String getCardnum() 
	  {
			return cardnum;
		}

		public void setCardnum(String cardnum) 
	  {
			this.cardnum = cardnum;
		}

		public String getStatus() 
	  {
			return status;
		}

		public void setStatus(String status) 
	  {
			this.status = status;
		}

		public float getTransAmount() 
	  {
			return transAmount;
		}

		public void setTransAmount(float transAmount) 
	  {
			this.transAmount = transAmount;
		}

		public String getTimestamp() 
	  {
			return timestamp;
		}

		public void setTimestamp(String timestamp) 
	  {
			this.timestamp = timestamp;
		}

}
