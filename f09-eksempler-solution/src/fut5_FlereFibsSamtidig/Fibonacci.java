package fut5_FlereFibsSamtidig;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Fibonacci {
	
//	private ExecutorService executor = Executors.newSingleThreadExecutor();
	private ExecutorService executor = Executors.newCachedThreadPool();
//	private ExecutorService executor = Executors.newFixedThreadPool(1000);
//	private ExecutorService executor = Executors.newWorkStealingPool();
	
	public Future<Long> beregn(int n) {
		Callable<Long> fibCallable = new Callable<>() {
			@Override
			public Long call() throws Exception {
				return new Fibonacci().fib(n);
			}
		};
		return executor.submit(fibCallable);
	}
	
	public void shutDown() {
		executor.shutdown();
	}
	
	public long fib(int n) {
		return n <= 1 ? n : fib(n-1) + fib(n-2);
	}
}