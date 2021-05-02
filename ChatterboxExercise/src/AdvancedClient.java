import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

	
public class AdvancedClient {


	
		Socket socket;
		BufferedReader bufferedReader;
		PrintWriter printWriter;
		String ip;
		int port;
		

		public AdvancedClient(String ip, int port){
			this.ip = ip;
			this.port = port;
		}


	public static void main (String[] args) throws IOException {
		AdvancedClient advancedClient = new AdvancedClient("2001:16b8:4570:5800:91f9:3143:2bcd:d7ca", 8051);
		//Client client = new Client("127.0.0.1",8051);
		try{
			advancedClient.connectSocket();
		} catch(UnknownHostException e1){
				e1.printStackTrace();
		} catch(IOException e1) {
				e1.printStackTrace();
		}
		
		advancedClient.setupStreams();
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		executor.scheduleAtFixedRate(advancedClient.readMessageRunnable, 0, 200, TimeUnit.MILLISECONDS);
		
		advancedClient.waitForInput();
	}
		
	Runnable readMessageRunnable = new Runnable() {
	@Override
	public void run() {
		try {
			if(bufferedReader.ready()) {
				String message = readMessage();
			if (!message.isEmpty() && message != null) {
				System.out.println(message);
			}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			}
		}
	};

	private void setupStreams() throws IOException {  
		// ?
		//DataInputStream din = new DataInputStream(socket.getInputStream());  
		//DataOutputStream dout = new DataOutputStream(socket.getOutputStream());  
	}
	
	void waitForInput() {
		System.out.println("Please use the console to send messages.");
		Scanner scanner = new Scanner(System.in);
		try {
			while(true) {
				String line = scanner.nextLine();
				try {
					writeMessage(socket, line);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		} catch (IllegalStateException e1) {
				//System.in has been closed
			e1.printStackTrace();
		}
		
	}
	
	private void connectSocket() throws UnknownHostException, IOException {
		// ?
	}
	
	void writeMessage(java.net.Socket socket, String nachricht) throws IOException {
			
			printWriter.print(nachricht);
	 		printWriter.flush();
		}


	private String readMessage() throws IOException {
			char[] buffer = new char[200];
			int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
			String nachricht = new String(buffer, 0, anzahlZeichen);
			return nachricht;
	}
	
}

	

