import java.io.IOException;
import java.nio.channels.Selector;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
	
	
public class MultiPortThreadedServer {
	

		private static Selector selector;
		int[] ports = {8050,8051,8052,8053,8054,8055,8056,8057,8058,8059,8060,8061,8062};
		ArrayList<EchoThreadMulti> eThreadList = new ArrayList<EchoThreadMulti>();
			
		public static void main(String[] args) {
				MultiPortThreadedServer mServer = new MultiPortThreadedServer();
				
			try {
			
				selector = Selector.open();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mServer.setupclients();
			
			System.out.println("Setup completed.");
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
			executor.scheduleAtFixedRate(mServer.listen, 8, 500, TimeUnit.MILLISECONDS);
			executor.scheduleAtFixedRate(mServer.echoAll, 0, 50, TimeUnit.MILLISECONDS);
		}
			
			
			private void listen() { // Zeigt Nachrichten vom Server an
				
			}
			
			Runnable listen = new Runnable() {}
			
			Runnable echoAll = new Runnab1e() {}
			
			private void echoAll() { // Zeigt Nachrichten von allen Clients an die mit dem Server verbunden sind
				
			}
			private void setupclients() { // Klassifizierung von versch. Clients
				
			}
			
}