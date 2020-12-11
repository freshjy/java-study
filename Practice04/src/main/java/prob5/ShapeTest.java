package prob5;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

	public static void main(String[] args) {
		List<Shape> list = new ArrayList<Shape>();
		list.add( new Rectangle(5, 6));
		list.add( new RectTriangle(6, 2));
		
		for(Shape s : list) {
			System.out.println("area : " + (s.getArea()));
			System.out.println("perimeter : " + (s.getPerimeter()));
			
			if(s instanceof Resizable) {
				((Resizable)s).resize(0.5);
				System.out.println("new area : " + (s.getArea()));
				System.out.println("new perimeter : " + (s.getPerimeter()));
			}
		}

	}

}
