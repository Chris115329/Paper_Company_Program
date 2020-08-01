package pkgPaperCompany;

public class Products {
	
	private int productID;
	private String productName;
	private float price;
	private int quantityOH;
	
	//default constructor
	public Products()
	{
		
		productID = 0;
		productName = "";
		price = 0.00f;
		quantityOH = 0;
		
	}

	//overloaded constructor
	public Products(int productID, String productName, float price, int quantityOH)
	{
		
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.quantityOH = quantityOH;
		
	}

	//getters and setters
	public int getProductID() 
	{
		return productID;
	}

	public void setProductID(int productID) 
	{
		this.productID = productID;
	}

	public String getProductName() 
	{
		return productName;
	}

	public void setProductName(String productName) 
	{
		this.productName = productName;
	}

	public float getPrice() 
	{
		return price;
	}

	public void setPrice(float price) 
	{
		this.price = price;
	}

	public int getQuantityOH() 
	{
		return quantityOH;
	}

	public void setQuantityOH(int quantityOH) 
	{
		this.quantityOH = quantityOH;
	}
	
	
	
	

}
