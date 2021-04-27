import java.net.*;
import java.io.*;

public class Chatterbox {

	
		public static void main(String[] args) {
			Chatterbox simple = new Chatterbox(8051);
			try {
				simple.StartServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private BufferedReader bufferedReader;
		private char[] buffers;
		private PrintWriter printWriter;
		private int port;
		private ServerSocket socket;
		private Socket client;
		private InputStream input;
		private OutputStream output;
		
		public Chatterbox(int port) {
			this.port = port;
		}
		
		public void StartServer() throws IOException {
			try {
					socket = openServerSocket(port);
					client = waitForLogin(socket);
					setupStreams(client);
			} catch (IOException e) {
				e.printStackTrace();
			}
			while(true) {
				String message = readMessage(bufferedReader);
				System.out.println(message);
			}
		}
		
		private String readMessage (BufferedReader bReader) throws IOException {
			BufferedReader bufferedReader =
					new BufferedReader(
						new InputStreamReader(
							client.getInputStream()));
				char[] buffer = new char[200];
				int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
				String nachricht = new String(buffer, 0, anzahlZeichen);
				return nachricht;
		}
		
		private ServerSocket openServerSocket(int port) throws IOException {
			ServerSocket serverSocket = new ServerSocket(port);
			return serverSocket;
		}
		
		private Socket waitForLogin(ServerSocket serverSocket) throws IOException{
			Socket socket = serverSocket.accept();
			return socket;
		}
		
		private void setupStreams(Socket socket) throws IOException{
			
			input = socket.getInputStream();
			
			output = socket.getOutputStream();
			
		}
		private void setupPrintWriter() throws IOException {
			printWriter =
				new PrintWriter(
					new OutputStreamWriter(
						client.getOutputStream()));
		}
}