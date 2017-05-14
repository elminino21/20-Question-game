package JunitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AnswerSourceTest.class, BinaryCounterTest.class,
		QuestionSourceTest.class })
public class AllTests {

}
