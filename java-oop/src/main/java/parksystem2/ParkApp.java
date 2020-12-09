package parksystem2;

import parksystem3.ParkSystem3;

public class ParkApp {

	public static void main(String[] args) {
		Car c = new Bus();
		ParkSystem2.park(c);
		
		c = new SportsCar();
		ParkSystem2.park(c);
		
		c = new Taxi();
		ParkSystem2.park(c);
		
	}

}
