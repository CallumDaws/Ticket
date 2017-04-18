import java.text.DecimalFormat;
import java.util.*;
public class TicketBuying {
	List<Tickets> Tickets = new ArrayList<Tickets>();
	DecimalFormat df = new DecimalFormat("#.00"); 
	int locationNumber;
	int loopNumber;
	int x,y;
	
/* Method for ticket generation, also ensures the locations are unique by checking the x and y coordinates,
 *  if they match any currently in the list it recursively calls the method to restart generation */ 
	void GenerateTickets(){
		int max = 10;
		int min = -10;
		double costMin = 0;
		double costMax = 100;
		Coordinates coords = new Coordinates();
		Random c = new Random();
		int randomCoordsx = c.nextInt((max-min) +1) +min;
		int randomCoordsy = c.nextInt((max-min) +1) +min;
		double cost = (costMin = (costMax - costMin) * c.nextDouble());
		coords = coords.Coords(randomCoordsx, randomCoordsy);
		Tickets t = new Tickets(cost, locationNumber, coords);
		locationNumber = locationNumber + 1;
		for(loopNumber = 0; loopNumber <Tickets.size(); loopNumber++){
			if((t.getLocation().getX() & t.getLocation().getY()) == (Tickets.get(loopNumber).getLocation().getX() & Tickets.get(loopNumber).getLocation().getY())){
				GenerateTickets();
			}else{
				break;
			}
		}
		Tickets.add(t);
	}

// Method for finding the closest 5 tickets to the location inputed
	List<Tickets> findClosest(int x,int y){
		int inputLocation = x+y;
		int index =0;
		List<Tickets> ClosestTickets = new ArrayList<Tickets>();
		while(index < 4){
			ClosestTickets.add(Tickets.get(index));
			index++;
		}
		Collections.sort(Tickets);
		index=0;
		for(loopNumber=0; loopNumber<Tickets.size();loopNumber++){
			if((Math.abs(inputLocation - (Tickets.get(loopNumber).location.getX() + Tickets.get(loopNumber).location.getY()))) < (Math.abs(inputLocation - (ClosestTickets.get(index).location.getX() + ClosestTickets.get(index).location.getY())))){
				ClosestTickets.add(Tickets.get(loopNumber));
				if(index < 4){
					index++;
				}
			}
			if(ClosestTickets.size() >= 6){
				ClosestTickets.remove(0);		
			}
		} 
		Collections.reverse(ClosestTickets);
		System.out.println("Closest Events to (" + getX() + "," + getY() + "):");
		for(loopNumber = 0; loopNumber < ClosestTickets.size(); loopNumber++){
			System.out.println("Event " + String.format("%03d",(ClosestTickets.get(loopNumber).getNumber())) + " $" + df.format(ClosestTickets.get(loopNumber).getCost()) + " Distance " + Math.abs(inputLocation - (ClosestTickets.get(loopNumber).getLocation().getX() + ClosestTickets.get(loopNumber).getLocation().getY())));
		}

		return ClosestTickets;
	}

// Method to call which calls the generation methods
	void Generate(){
		int generationNumber;
		for(generationNumber = 0; generationNumber<100; generationNumber++ ){
			GenerateTickets();
		}
	}
// Method which uses a scanner for user input then parses int to turn each side of the comma into different numbers to be used for x y
	private void userInput() {
		Scanner s = new Scanner(System.in);
		String input;
		String[] inputSplit;
		input = s.next();
		inputSplit = input.split(",");
		try{
			setX(Integer.parseInt(inputSplit[0]));
			setY(Integer.parseInt(inputSplit[1]));
		}catch (Exception WrongInput){
			System.out.println("Please input a correct Number");
			userInput();
		}
		s.close();
	}

	public static void main(String[] args) {
		TicketBuying t = new TicketBuying();
		t.Generate();
		t.userInput();
		t.findClosest(t.getX(),t.getY());

	}
// Get and Setters
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


}
