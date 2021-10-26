import java.util.Arrays;

public class ManagementCompany {
	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;

	/**
	 * constructor
	 */
	ManagementCompany() {
		plot = new Plot(0, 0, 10, 10);
		name = "";
		taxID = "";
		// create new property array
		properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < properties.length; i++) {
			properties[i] = new Property();
		}
	}

	/**
	 * overloading constructor
	 * @param name		name of the management company
	 * @param taxID		tax id of the management company
	 * @param mgmFee	the management fee
	 */
	ManagementCompany(String name, String taxID, double mgmFee) {
		plot = new Plot(0, 0, 10, 10);
		this.name = name;
		this.taxID = taxID;
		mgmFeePer = mgmFee;
		// create new property array
		properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < properties.length; i++) {
			properties[i] = new Property();
		}
	}

	/**
	 * overloading constructor
	 * @param name		name of the management company
	 * @param taxID		tax id of the management company
	 * @param mgmFee	the management fee
	 * @param x			plot's x coordinate
	 * @param y			plot's y coordinate
	 * @param width			plot's width
	 * @param depth			plot's depth
	 */
	ManagementCompany(java.lang.String name, java.lang.String taxID, double mgmFee, int x, int y, int width,
			int depth) {
		this.name = name;
		this.taxID = taxID;
		mgmFeePer = mgmFee;
		// create new plot object
		plot = new Plot(x, y, width, depth);
		// create new property array
		properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < properties.length; i++) {
			properties[i] = new Property();
		}
	}

	/**
	 * overloading constructor
	 * @param otherCompany
	 */
	ManagementCompany(ManagementCompany otherCompany) {
		properties = new Property[MAX_PROPERTY];
		mgmFeePer = otherCompany.getMgmFeePer();
		name = otherCompany.getName();
		taxID = otherCompany.getTaxID();
		plot = otherCompany.getPlot();
		//create new property array
		for (int i = 0; i < properties.length; i++) {
			properties[i] = new Property();
		}

	}

	/**
	 * Add a new property
	 * @param property		property object
	 * @return				 the index of the array where the property is added
	 */
	public int addProperty(Property property) {
		int size = 0;
		if (property == null) {		//case when 0 property exits
			size = -2;
		}
		if (!plot.encompasses(property.getPlot())) {
			size = -3;
		}
		if (plot.overlaps(property.getPlot())) {	// check if it is overlapping existing one.
			size = -4;
		}

		// if found a property with 0 as rent, means no property exist in this index yet,
		// place the new created property into it
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() == 0) {
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param name		name of the property
	 * @param city		city name where the property is located
	 * @param rent		rent amount
	 * @param owner		owner of the property
	 * @return the index of the array where the property is added
	 */
	public int addProperty(String name, String city, double rent, String owner) {

		int size = 0;
		Property property = new Property(name, city, rent, owner);

		if (property == null) {//case when 0 property exits
			size = -2;
		}
		if (!plot.encompasses(property.getPlot())) {
			size = -3;
		}
		if (plot.overlaps(property.getPlot())) {
			size = -4;
		}

		// if found a property with 0 as rent, means no property exist in this index yet,
		// place the new created property into it
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() == 0) {
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param name		name of the property
	 * @param city		city name where the property is located
	 * @param rent		rent amount
	 * @param owner		owner of the property
	 * @param x		x coordinate of the property
	 * @param y		y coordinate of the property
	 * @param width		width of the property
	 * @param depth		depth of the property
	 * @return the index of the array where the property is added
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		int size = 0;
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		if (property == null) {//case when 0 property exits
			size = -2;
		}

		if (!plot.encompasses(property.getPlot())) {
			size = -3;
		}
		
		System.out.println("3");
		if (plot.overlaps(property.getPlot())) {
			size = -4;
		}

		// if found a property with 0 as rent, means no property exist in this index yet,
		// place the new created property into it
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() == 0) {
				properties[i] = property;
				return i;
			}
		}

		return -1;
	}

	/**
	 * 
	 * @return the total rent of the properties in the properties array.
	 */
	public double totalRent() {
		double total = 0;

		// add up every rent from the property array.
		for (int i = 0; i < properties.length; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
	}

	/**
	 * 
	 * @return
	 */
	public double maxRentProp() {
		double maxRent = 0;
		
		// if the amount from the property array list is greater than the max rent, replace it
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() > maxRent) {	
				maxRent = properties[i].getRentAmount();
			}
		}
		return maxRent;

	}

	/**
	 * 
	 * @return the index of the property within the properties array that has the
	 *         highest rent amount.
	 */
	private int maxRentPropertyIndex() {
		int maxIndex = 0;
		double maxRent = 0;

		for (int i = 0; i < properties.length; i++) {
			if (properties[i].getRentAmount() > maxRent) {
				maxRent = properties[i].getRentAmount();
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	/**
	 * 
	 * @param i index number
	 * @return toString result
	 */
	private java.lang.String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}

	/**
	 * @return String list of properties
	 */
	public java.lang.String toString() {
		double sum1 = 0;
		String str = "";
		
		for (int i = 0; i < properties.length; i++) {
			for (int ii = 0; ii < properties.length; ii++) {
				str = properties[ii].toString() + "\n";
			}

			for (int j = 0; j < properties.length; j++) {
				sum1 += properties[j].getRentAmount();
			}
		}

		double a = getMgmFeePer() * sum1;
		return "List of properties for " + name + ", taxId= " + taxID + "\n" + "\n"
				+ "----------------------------------------------------------\n" + str
				+ "\n----------------------------------------------------------\n" + "total management Fee: "
				+ Double.toString(a);

	}

	/**
	 *  Following are Getters and Setters
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public Property[] getProperties() {
		return properties;
	}

	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	public double getMgmFeePer() {
		return mgmFeePer;
	}

	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

}