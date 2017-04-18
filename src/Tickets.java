
public class Tickets implements Comparable<Tickets> {
	double Cost;
	int Number;
	Coordinates location;

	public Tickets(double Cost, int Number, Coordinates location){
		this.Cost = Cost;
		this.Number = Number;
		this.location = location;
	}

	void printTickets(){
		System.out.println(Cost + " " + Number + " " + location.x + "," + location.y);
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

	public int compare(Tickets arg1, Tickets arg2) {
		Integer first = (arg1.getLocation().getX() + arg1.getLocation().getY());
		Integer second = (arg2.getLocation().getX() + arg2.getLocation().getY());
		int result = first.compareTo(second);
		return result;
	}

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
