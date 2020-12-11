package prob5;

public class Rectangle extends Shape implements Resizable{
	double width;
	double height;
	
	Rectangle(){}
	Rectangle(double w, double h){
		width = w;
		height = h;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return width*height;
	}
	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return (2*width)+(2*height);
	}
	@Override
	public void resize(double s) {
		// TODO Auto-generated method stub
		width = width*s;
		height = height*s;
	}
	
}
