import java.io.*;
import java.net.*;

public class Client {
	Socket socket;
	BufferedReader bufferedReader;
	PrintWriter printWriter;
	String ip;
	int port;

	public Client(String ip, int port){
		this.ip = ip;
		this.port = port;
	}


public static void main (String[] args) throws IOException {
	Client client = new Client("2001:16b8:4570:5800:91f9:3143:2bcd:d7ca", 8051);
	//Client client = new Client("127.0.0.1",8051);
	client.startClient();
	while(true){
		try{
			client.writeMessage("Hello World!");
			Thread.sleep(4000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	
}
	
private void startClient() throws UnknownHostException, IOException{
			socket = new Socket(ip, port);
			
			setupPrintWriter();
 
            System.out.println("Connected to the chat server");
 
            
}

void writeMessage(String nachricht) throws IOException {
		
		printWriter.print(nachricht);
 		printWriter.flush();
	}


private void setupPrintWriter() throws IOException {
	printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
}


}
