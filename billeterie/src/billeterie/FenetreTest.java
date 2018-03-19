package billeterie;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FenetreTest {
 
	private FrameFixture demo;
	
	@Before
	public void setUp() {
 
		demo = new FrameFixture(new Fenetre());
	}
	
	@After
	public void tearDown() {
 
		demo.cleanUp();
	}
	
	@Test
	public void test() {
		
		demo.button("myButton").click();
	}
}
