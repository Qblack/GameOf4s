package gameOf4sUnitTests;

import static org.junit.Assert.*;

import java.util.Arrays;
import gameoffours.PolyNomialEquationSolver;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PolyNomialEquationSolverTest {
	
	private PolyNomialEquationSolver m_sut;
	private double expected;
	private String math;
	
	@Before
	public void initialize() throws Exception {
		m_sut = new PolyNomialEquationSolver();
	}

	@After
	public void tearDown() throws Exception {
	}

	public PolyNomialEquationSolverTest(String math,double expected){
		this.math = math;
		this.expected = expected;
	}
	
	@Test
	public void testProcessMath() {
		double actual = m_sut.processMath(math);
		assertEquals(expected, actual,0);
	
	}
	
	@Parameters
	public static Iterable<Object[]> data(){
		return Arrays.asList(new Object[][] {
				{"44-44",0},
				{"44/44",1},
				{"4/4+4/4",2},
				{"(4*4-4)/4",3},
				{"(4-4)*4+4",4},
				{"[4*4+4]/4",5},
				{"[(4+4)/4]+4",6},
				{"(4+4)-(4/4)",7},
				{"(4*4)-(4+4)",8},
				{"(4/4)+4+4",9},
				{"((44-4)/4)",10}						
		});
	}
		
}
