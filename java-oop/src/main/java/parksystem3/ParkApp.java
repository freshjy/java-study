package parksystem3;

public class ParkApp {

	public static void main(String[] args) {
		IParkable parkable = new Bus();
		ParkSystem3.park(parkable);
		
		parkable = new SportsCar();
		ParkSystem3.park(parkable);
		
		parkable = new Taxi();
		ParkSystem3.park(parkable);
		
		parkable = new Airplane();
		ParkSystem3.park(parkable);
		
	}

}
