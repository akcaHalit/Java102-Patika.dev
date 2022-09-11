import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		Threads thr = new Threads();
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		for(int i=1; i<=10000; i++) {
			executor.execute(thr);
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}catch(InterruptedException e) {
            throw new RuntimeException(e);
		}
		
		System.out.println("Even Numbers: " + thr.getEvenNumbers().size());
		System.out.println("Odd Numbers: " + thr.getOddNumbers().size());
		//System.out.println("Even Numbers: " + thr.getEvenNumbers().size());
		
	}

}
