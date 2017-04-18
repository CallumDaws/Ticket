import java.util.Scanner;


public class Coordinates {
	Scanner s = new Scanner(System.in);
	int x;
	int y;
	String input;
	String[] inputSplit;
	public Coordinates(int x, int y){
		setCoords(x,y);
	}

	public Coordinates(){
		setX(1);
		setY(1);
	}
// Method for setting coordinates using methods input as parameter then check if it fails or not
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
	public Coordinates Coords(int x, int y){
		Coordinates Coords = new Coordinates(x,y);
		return Coords;
	}
	void Tickets(Coordinates c ){
		System.out.println(c.getX() + " " + c.getY());
	}
}
