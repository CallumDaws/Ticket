
public class Tickets implements Comparable<Tickets> {
	double Cost;
	int Number;
	Coordinates location;

	//Constructor for the creation of tickets
	public Tickets(double Cost, int Number, Coordinates location){
		this.Cost = Cost;
		this.Number = Number;
		this.location = location;
	}

	//System for printing specific ticket information if that needs to be added once the user decides on a ticket.
	void printTickets(){
		System.out.println(String.format("03d%",(getNumber()) + " $" + getCost() + " (" + getLocation().getX() + "," + getLocation().getY() + ")"));
	}

	public double getCost() {
		return Cost;
	}

	public void setCost(double cost) {
		Cost = cost;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public Coordinates getLocation() {
		return location;
	}

	public void setLocation(Coordinates location) {
		this.location = location;
	}

	// Override for Comparing tickets making it possible to sort and compare tickets according to their x and y locations.
	@Override
	public int compareTo(Tickets arg0) {
		if((this.getLocation().getX()) > (arg0.getLocation().getX())){
			return 1;
		}
		if((this.getLocation().getX()) < (arg0.getLocation().getX())){
			return -1;
		}
		if((this.getLocation().getY()) > (arg0.getLocation().getY())){
			return 1;
		} else
			return -1;
	}


}
