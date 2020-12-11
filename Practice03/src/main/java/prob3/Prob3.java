package prob3;

public class Prob3 {
	
	public static void main(String args[]) {
		
		char[] array1 = reverse("Hello World");
		printCharArray(array1);
		
		char[] array2 = reverse("Java Programming!");
		printCharArray(array2);
	}
	
	public static char[] reverse(String str) {
		char[] data = new char[str.length()];
		for(int i=0; i< (str.length()/2); i++) {
			data[i] = str.charAt(str.length()-1-i);
			data[str.length()/2] = str.charAt(str.length()/2);
			data[str.length()-1-i] = str.charAt(i);			
		}

		return data;
	}
	
	public static void printCharArray(char[] array){
		for(char arr : array) {
			System.out.print(arr);
		}
		System.out.println();
	}
}
