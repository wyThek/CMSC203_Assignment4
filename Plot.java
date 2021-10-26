public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;


	/**
	 * constructor.
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	/**
	 * overloading constructor
	 * @param p
	 */
	public Plot(Plot p) {
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	/**
	 * Overloading constructor
	 * @param x	coordinate	
	 * @param y coordinate
	 * @param width	
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * Method that check if a plot is overlapping another plot.
	 * @param plot
	 * @return a boolean value that tells if plots are overlapping
	 */
	public boolean overlaps(Plot plot) {
		boolean flag = true;

		if (plot.x + plot.width <= x) {
			flag = false;
		} else if (plot.y + plot.depth <= y) {
			flag = false;
		} else if (plot.x >= x + width) {
			flag = false;
		} else if (plot.y >= y + depth) {
			flag = false;
		}
		return flag;
	}

	/**
	 * takes a Plot instance and determines if the current plot contains it
	 * @param plot
	 * @return a boolean value
	 */
	public boolean encompasses(Plot plot) {
		boolean flag = false;
		
		if (x <= plot.x && x + width >= plot.getX() + plot.getWidth() && y <= plot.getY()
				&& y + depth >= plot.getY() + plot.getDepth()) {

			flag = true;
		}

		return flag;
	}

	// Following are Getters and Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}
	
	/**
	 * @return String that contains the value of a Plot.
	 */
	@Override
	public String toString() {
		return "Upper left: (" + this.x + "," + this.y + "); Width: " + this.width + " Depth: " + this.depth;
	}

}