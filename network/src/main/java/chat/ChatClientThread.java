package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatClientThread extends Thread{
	private BufferedReader bufferesReader;
	private Socket socket;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			while(true) {
				String message = bufferedReader.readLine();
				if(message == null) {
					break;
				}
				System.out.println(message);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
	}
	
	
}
