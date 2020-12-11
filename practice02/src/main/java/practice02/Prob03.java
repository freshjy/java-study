package practice02;

public class Prob03 {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
	    Rectangle s = new Rectangle(1,1,2,3);

	    System.out.println( r );
	    System.out.println(s);

	    System.out.println( "사각형  r의 넓이는"  + r.square()  );
	    System.out.println( " 사각형 s의 넚이는" + s.square() );

	    r.set(1,1,2,3);
	    System.out.println( r ); //"Rectangle(x1=1, y1=1, x2=2, y3=3)"

	    if( r.equals(s) ) {
	       System.out.println( "두 사각형은 같습니다" );
	    }
	}
}
