package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9999;
	
	public static void main(String[] args) {
		
		Scanner scanner = null;
		Socket socket = null;
		try {
			//1. 키보드 연결
			scanner = new Scanner(System.in);
			
			//2. 소켓 생성
			socket = new Socket();
			
			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("[client] connected!");
			
			//4. reader/writer 생성
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
			//5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			printWriter.println("join:"+nickname);
			String ack = bufferedReader.readLine();
			if("join:ok".equals(ack)) {
				System.out.println("입장완료");
			}
			
			//6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();
			
			//7. 키보드 입력 처리
			while(true) {
				String input = scanner.nextLine();
				
				if("quit".equals(input)) {
					//8.quit 프로토콜 처리
					printWriter.println("quit");
					break;
				}else {
					//9.메세지 처리
					printWriter.println("message:" + input);
				}
				
			}
		} catch(SocketException e) {
			// server 비정상 종료
			System.out.println("[clinet] suddenly closed by server");
		} catch (IOException e) {
			System.out.println("[client] error:" + e);
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && !socket.isClosed())
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
