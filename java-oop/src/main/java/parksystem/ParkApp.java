package parksystem;

public class ParkApp {

	
	
	public static void main(String[] args) {
		Bus c1 = new Bus();
		SportsCar c2 = new SportsCar();
		
		ParkSystem.park(c1);
		ParkSystem.park(c2);
	}

}
