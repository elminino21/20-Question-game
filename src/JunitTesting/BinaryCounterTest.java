package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.necc.net.costumeIPA.BinaryCounter;

public class BinaryCounterTest {

	@Test
	public void test() {
		BinaryCounter test = new BinaryCounter();
		
		test.incraseCounter(false);
		test.incraseCounter(false);
		test.incraseCounter(true);
		long output = test.incraseCounter(false);
		
		
		System.out.println(output);
		assertEquals(20, output);
		
	}

}
