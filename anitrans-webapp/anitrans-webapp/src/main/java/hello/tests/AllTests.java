package hello.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
// by FYICenter.com

// specify a runner class: Suite.class
@RunWith(Suite.class)

// specify an array of test classes
@Suite.SuiteClasses({
	hello.ContextLoadsTest.class,
	//OrderTestMock.class,
	HomeTestMock.class,
	LoginTestMock.class
}
)

// the actual class is empty
public class AllTests {
}