package practice01;


public class Prob03 {
	public static void main(String[] args) {
		char one;
		char two;
		for(int i=1; i<100; i++) {			
			String s = String.valueOf(i);
			if(i<10) {
				one = s.charAt(0);
				if(one=='3'||one=='6'||one=='9')
					System.out.println(one + " 짝");
			}else {
				one = s.charAt(0);
				two = s.charAt(1);
				if((one=='3'&&(two=='3'||two=='6'||two=='9'))||(one=='6'&&(two=='3'||two=='6'||two=='9'))||(one=='9'&&(two=='3'||two=='6'||two=='9'))) {
					System.out.print(one);
					System.out.println(two+" 짝짝");
				}else if(one=='3'||one=='6'||one=='9'||two=='3'||two=='6'||two=='9') {
					System.out.print(one);
					System.out.println(two+" 짝");
				}
			}
			
			
		}
		/*int i= 69;
		String s = String.valueOf(i);
				
		char c = s.charAt(0);
		*/
		
	}
}
