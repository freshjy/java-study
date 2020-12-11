package prob5;

public abstract class Shape {
	int numSides;
	
	Shape(){}
	Shape(int numSides){
		this.numSides = numSides;
	}
	
	abstract double getArea();
	abstract double getPerimeter();
}
