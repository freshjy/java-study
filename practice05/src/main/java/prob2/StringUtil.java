package prob2;

public class StringUtil {
    public static String concatenate( String[] str ){
    	StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length; i++) {
        	sb.append(str[i]);
        }
    	String answer = sb.toString();
        
    	return answer;    	
    }

    public static void main(String args[])  {         
        String[] strArr = {"SuperMan", "BatMan", "SpiderMan"}; 
        String resultStr = concatenate( strArr );
        System.out.println( "결과 문자열 : " + resultStr ); 
    }
}

