package gameoffours;

import java.util.Stack;
import java.util.Vector;


public class PolyNomialEquationSolver {
	
	private static final String DIVISOR = "/";
	private static final String MULTIPLIER = "*";
	private static final String PLUS = "+";
	private static final String SUBTRACTOR = "-";

	private static final String SYMBOLS = "+-*/!^%";
	private static final String LEFT_BRACKETS = "([";
	private static final String RIGHT_BRACKETS = ")]";
	private static final String NUMBERS ="1234567890";
	
		
	public double processMath(String math){
		Stack<String> leftStack = new Stack<String>();
	
		String number="";
		for( int i = 0;i<math.length();i++){
			String element = math.substring(i, i+1);
			
			if( LEFT_BRACKETS.contains(element)){
				if(!number.equals("")){
					leftStack.push(number);
					number ="";
				}
				leftStack.push(element);
			}else if(NUMBERS.contains(element)){
				number +=element;
			}else if(SYMBOLS.contains(element)){
				if(!number.equals("")){
					leftStack.push(number);
					number ="";
				}
				leftStack.push(element);
			}else{
				if(!number.equals("")){
					leftStack.push(number);
					number ="";
				}
				doBedmas(leftStack,element);
			}
		}
		if (leftStack.size()>=1){
			if(!number.equals("")){
				leftStack.push(number);
				number ="";
			}
			doBedmas(leftStack);
		}
		
		String finalValue = leftStack.pop();			
		return Double.parseDouble(finalValue);
	}
	
	private void doBedmas(Stack<String> leftStack) {
		doBedmas(leftStack,"");
	}

	private void doBedmas(Stack<String> equationStack, String rightBracket){
		String leftBracket ="";
		if (!rightBracket.equals("")){
			leftBracket = findLeftBracket(rightBracket);				
		}
		Vector<String> subEquation = new Vector<String>();
		
		while(!equationStack.isEmpty() && equationStack.peek()!=leftBracket){
			String node = equationStack.pop();
			subEquation.add(node);
		}
		if (equationStack.size()>=1){
			equationStack.pop();
		}
		
		
		while(subEquation.size()>1 ){

			while(subEquation.contains(DIVISOR)){
				performOperation(DIVISOR,subEquation);
			}
			
			while(subEquation.contains(MULTIPLIER)){
				performOperation(MULTIPLIER,subEquation);
			}
			
			while(subEquation.contains(PLUS)){
				performOperation(PLUS,subEquation);
			}
			
			while(subEquation.contains(SUBTRACTOR)){
				performOperation(SUBTRACTOR,subEquation);
			}
		}
	}
	
	private Vector<String> performOperation(String operation,Vector<String> equation){
		int operatorPoint = equation.indexOf(operation);
		String leftValue = equation.get(operatorPoint-1);
		String rightValue = equation.get(operatorPoint+1);
		PolyNomial leftNumber = new PolyNomial(leftValue);
		
		
		switch(operation){
			case DIVISOR:
				leftNumber.DivideBy(rightValue);
			case MULTIPLIER:
				leftNumber.MultiplyBy(rightValue);
			case PLUS:
				leftNumber.Add(rightValue);
			case SUBTRACTOR:
				leftNumber.Add(rightValue);	
		}
				
		equation.remove(operatorPoint+1);
		equation.remove(operatorPoint);
		equation.remove(operatorPoint-1);
		
		equation.add(0, leftNumber.ToString());
		return equation;
			
	}
	
	
	private String findLeftBracket(String rightBracket){
		int indexOfBracket = RIGHT_BRACKETS.indexOf(rightBracket);
		char leftBracket = LEFT_BRACKETS.charAt( indexOfBracket);
		return String.valueOf(leftBracket);
			
	}
	
}
