package parksystem2;

public abstract class Car {
	private int accelate = 0;
	
	public void brake() {
		System.out.println("브레이크를 밟았습니다.");
	}
	public abstract void park();
}
