package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

import com.necc.net.costumeIPA.BinaryCounter;

public class BinaryCounterTest {

	@Test
	public void test() {
		BinaryCounter test = new BinaryCounter(4);
		
		int output = test.incraseCounter();
		System.out.print(output);
		assertEquals(5, output);
		
	}

}
