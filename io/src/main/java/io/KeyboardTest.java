package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			//기반 스트림(System.in : 표준 입력 or stdin)
			
			//보조 스트림1(byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
			
			//보조 스트림2(char1|char2|char3|\n -> "char1char2char3")
			br = new BufferedReader(isr);
			
			String line = null;
			
			while((line = br.readLine()) != null) {
				if("exit".equals(line))	break;
				System.out.println(line);
			}
			
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error:" + e);
		} catch(IOException e){
			System.out.println("error:" + e);
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error:" + e);
			}
		}
	}
}
