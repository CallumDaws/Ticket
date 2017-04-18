import java.util.Scanner;


public class Coordinates {
	Scanner s = new Scanner(System.in);
	int x;
	int y;
	String input;
	String[] inputSplit;

	// Constructor for setting coordinates
	public Coordinates(int x, int y){
		setCoords(x,y);
	}

	// default constructor if the object needs to be created for use
	public Coordinates(){
		setX(1);
		setY(1);
	}

	// Method for setting coordinates using input parameters then check if it fails or not
	public int setCoords(int x, int y){			
		if((x<=10 && x>=-10) && (y<=10 && y>=-10)){
			setX(x);
			setY(y);
			return x;
		}else{
			return setCoords(x,y);
		}

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	//Method for easily creating new coordinate object with given parameters
	public Coordinates Coords(int x, int y){
		Coordinates Coords = new Coordinates(x,y);
		return Coords;
	}
	//System for printing out the Coordinates for a specific ticket
	void Tickets(Coordinates c ){
		System.out.println(c.getX() + " " + c.getY());
	}
}
