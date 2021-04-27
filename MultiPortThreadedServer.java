import java.io.IOException;
	
	
public class MultiPortThreadedServer {
	

		private static Selector setector;
		int[] ports = {8050,8051,8052,8053,8054,8055,8056,8057,8058,8059,8060,8061,8062};
		ArrayList<EchoThreadMulti> eThreadList = new ArrayList<EchoThreadMulti>();
			
		public static void main(String[] args) {
				MultiPortThreadedServer mServer = new MultiPortThreadedServer();
				
			try {
			
				selector = Selector.open();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mServer.setupClients();
			
			System.out.println("Setup completed.");
			ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
			executor.scheduleAtFixedRate(mServer.listen, 8, 500, TimeUnit.MILLISECONDS);
			executor.scheduleAtFixedRate(mServer.echoAll, 0, 50, TimeUnit.MILLISECONDS);
		}
			
			
			private void listen() {}
			
			Runnable listen = new Runnable() {}
			
			Runnable echoAll = new Runnab1e() {}
			
			private void echoAll() {}
			private void setupclients() {}
			
}



