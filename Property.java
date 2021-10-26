public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * Constructor
	 */
	public  Property() {
		city="";
		owner = "";
		propertyName="";
		rentAmount=0;
		plot = new Plot(0,0,1,1);
	}
	
	/**
	 * Overloading Constructor
	 * @param p
	 */
	public  Property(Property p) {
		city=p.city;
		owner = p.owner;
		propertyName=p.propertyName;
		rentAmount=p.rentAmount;
		plot = p.getPlot();
	}
	
	/**
	 * Overloading Constructor
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	public  Property(String propertyName,String city, double rentAmount, String owner ) {
		this.city=city;
		this.owner =owner;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		plot = new Plot(0,0,1,1);
	}
	
	/**
	 * Overloading constructor
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x	coordinate of the plot
	 * @param y coordinate of the plot
	 * @param width of the plot
	 * @param depth of the plot
	 */
	public Property(String propertyName,String city, double rentAmount, String owner, int x, int y, int width, int depth ) {
		this.city=city;
		this.owner =owner;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		plot = new Plot(x,y,width,depth);
	}
	
	/**
	 * Overloading constructor
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x	coordinate of the plot
	 * @param y coordinate of the plot
	 * @param width of the plot
	 * @param depth of the plot
	 */
	public Property(String propertyName, String city, int rentAmount, String owner, int x, int y, int width,
			int depth) {
		this.city=city;
		this.owner =owner;
		this.propertyName=propertyName;
		this.rentAmount=rentAmount;
		plot = new Plot(x,y,width,depth);
	}

	/**
	 * Getter for Property name
	 * @return
	 */
	public java.lang.String getPropertyName(){
		return propertyName;
	}
	/**
	 * Setter for Property name
	 * @param propertyName
	 */
	public void setPropertyName(java.lang.String propertyName) {
		this.propertyName=propertyName;
	}
	
	//Following are Getters and Setters
	public java.lang.String getCity(){
		return city;
	}
	
	public Plot setPlot(int x, int y, int width, int depth) {
		return plot = new Plot(x,y,width,depth);
	}
	
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	
	public double getRentAmount() {
		return rentAmount;
		
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount=rentAmount;
	}
	
	public java.lang.String getOwner(){
		return owner;
	}
	
	public void setOwner(java.lang.String owner) {
		this.owner = owner;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	/**
	 * To string method that return the property's values
	 */
	@Override
	public String toString() {
		return "Property Name: " + propertyName+ "/nLocated in city " + city +
				"/nBelonging to: " + owner + "/nRent Amount: " + rentAmount;
	}

	public Plot getPlot() {
		return plot;
	}
	
	
}