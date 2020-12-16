package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServer {
	public static final int PORT = 9999;
	
	public static void main(String[] args) {
		//List<Writer> listWriters = new ArrayList<Writer>();
		ServerSocket  serverSocket = null;
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			// 2. 바인딩
			//String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
			System.out.println("연결 기다림 " + "127.0.0.1" +":" + PORT);
			
			//3. 요청 
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket).start();
			}
		} catch (IOException e) {
			System.out.println("[server] error:" + e);
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
