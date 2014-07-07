package drj.euler.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

import drj.euler.Utility;

public class TestSieve extends AbstractPrimeSieve {

	public static void main(String[] args) {
		PrimeService newsieve = new TestSieve();
		PrimeService oldsieve = new Utility.PrimeSieve();
		
		Utility.Timer t = new Utility.Timer();
		
		t.start();
		newsieve.isPrime(1100001);
		System.out.println("new sieve - " + t.toDecimalString());
		t.reset();
		oldsieve.isPrime(1100001);
		System.out.println("old sieve - " + t.toDecimalString());

//		for (int i = 0; i < 10000000; i++) {
//			boolean sieveIsPrime = newsieve.isPrime(i);
//			boolean isPrime = Utility.isPrime(i);
//			if (sieveIsPrime)
//				System.out.println(i);
//			if (sieveIsPrime ^ isPrime)
//				throw new RuntimeException();
//		}
	}

	List<Boolean> sieve = new ArrayList<>();

	public TestSieve() {
		sieve.add(false);
		sieve.add(true);
		sieve.add(true);
		sievedTo.set(5);
	}

	@Override
	protected boolean checkPrime(long num) {
		return sieve.get((int) (num / 2));
	}

	@Override
	protected long getSieveIncrement() {
		return 1000000;
	}

	@Override
	protected void onSieveStart(long space) {
		for (int i = 0; i < space; i++) {
			sieve.add(Boolean.TRUE);
		}
	}

	@Override
	protected void setNotPrime(CountDownLatch latch, long... nums) {
		for (long num : nums) {
			int index = (int) (num / 2);
			sieve.set(index, Boolean.FALSE);
		}
		latch.countDown();
	}
}