package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩(binding): Socket Address(IP Address + Port)
			serverSocket.bind(new InetSocketAddress("127.0.0.1",6000));
			
			//3. accept
			Socket socket = serverSocket.accept(); //blocking
			InetSocketAddress remoteInetSocketAddress= (InetSocketAddress)socket.getRemoteSocketAddress();
			
			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();
			System.out.println("[server] connected by client["+remoteHostAddress+":"+remotePort+"]");
			
			try {
				//4. IOStream 받아 오기
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				while(true) {
					//5. 데이터 읽기
					byte[] buffer = new byte[256];
					int readByteCount = is.read(buffer);	//blocking
					
					if(readByteCount == -1) {
						//client가 소켓을 정상적으로 종료
						System.out.println("[server] closed by client");
						break;
					}
					
					String data = new String(buffer, 0, readByteCount, "UTF-8");
					System.out.println("[server] received:"+data);
					
					//6. 데이터 쓰기
					os.write(data.getBytes("UTF-8"));
				}
				
			}catch(IOException e) {
				System.out.println("[server] error:" + e);
			}finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
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
