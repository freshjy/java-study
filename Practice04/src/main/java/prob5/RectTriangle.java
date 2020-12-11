package prob5;

public class RectTriangle extends Shape{
	double width;
	double height;
	
	RectTriangle(){}
	RectTriangle(double w, double h){
		width = w;
		height = h;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (width*height)/2;
	}
	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return width+height+(Math.sqrt(Math.pow(width, 2)+Math.pow(height, 2)));
	}
	
	
}
