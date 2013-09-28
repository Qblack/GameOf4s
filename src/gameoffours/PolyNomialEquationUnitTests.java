/**
 * 
 */
package gameoffours;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Q
 *
 */
public class PolyNomialEquationUnitTests {
	
	private PolyNomialEquationSolver equationSolver;
	
	@Before
	public void Setup(){
		equationSolver = new PolyNomialEquationSolver();
		
	}
	
	@Test
	public void SimpleAddition() {
		String math = "4+4";
		double expected = 8;
		
		double actual = equationSolver.processMath(math);
		
		assertSame(expected, actual);
		
	}

}
