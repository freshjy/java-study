package chat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread{
	private String nickname;
	private Socket socket;
	private List<PrintWriter> listWriters = new ArrayList<PrintWriter>();
	
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	
	private void doJoin(String nickName, PrintWriter printWriter) {
		this.nickname = nickName;
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		/* writer pool에 저장 */
		addWriter(printWriter);
		
		// ack
		printWriter.println("join:ok");
		printWriter.flush();
		
	}
	
	private void addWriter(PrintWriter printWriter) {
		synchronized(listWriters) {
			listWriters.add(printWriter);
		}
	}
	
	private void doQuit(PrintWriter printwriter) {
		removeWriter(printwriter);
		
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
	}
	
	private void doMessage(String token) {
		broadcast(nickname + ":" + token);
	}
	private void removeWriter(PrintWriter printwriter) {
		/* 잘 구현 해 보기 */
		synchronized(listWriters) {
			listWriters.remove(printwriter);
		}
	}
	
	private void broadcast(String data) {
		synchronized(listWriters) {
			for(PrintWriter writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	@Override
	public void run() {
		// 1. remote Host Information
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		String remoteHostAddress = remoteInetAddress.getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		
		try {
			//2. 스트림 얻기
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			
			//3. 요청 처리
			while(true) {
				String data = bufferedReader.readLine();
				
				if(data == null){
					// client가 소켓을 정상 종료
					System.out.println("클라이언트로 부터 연결 끊김");
					doQuit(printWriter);
					break;
				}
				
				String[] tokens = data.split(":");
				if("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				}else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}else if("quit".equals(tokens[0])) {
					doQuit(printWriter);
				}else {
					System.out.println("에러:알수 없는 요청("+tokens[0]+")");
				}				
			}
		} catch(SocketException e) {
			// client가 비정상 종료
			doQuit(printWriter);
			System.out.println("[server] suddenly closed by client");
		} catch(IOException e) {
			doQuit(printWriter);
			System.out.println("[server] error:" + e);
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
