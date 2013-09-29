package gameoffours;

import java.util.Stack;
import java.util.Vector;
import gameoffours.Polynomial;


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
		
		while(!equationStack.isEmpty() && !equationStack.peek().equals(leftBracket)){
			String node = equationStack.pop();
			subEquation.add(0,node);
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
		transferVectorToStack(subEquation,equationStack);
	}
	
	private void transferVectorToStack(Vector<String> vector,Stack<String> stack){
		while(!vector.isEmpty()){
			String node = vector.remove(0);
			stack.push(node);
		}
	}
	
	private void performOperation(String operation,Vector<String> equation){
		int operatorPoint = equation.indexOf(operation);
		String leftValue = equation.get(operatorPoint-1);
		String rightValue = equation.get(operatorPoint+1);
		Polynomial leftNumber = new PolynomialImp(leftValue); 
						
		switch(operation){
			case DIVISOR:
				leftNumber.DivideBy(rightValue);
				break;
			case MULTIPLIER:
				leftNumber.MultiplyBy(rightValue);
				break;
			case PLUS:
				leftNumber.Add(rightValue);
				break;
			case SUBTRACTOR:
				leftNumber.Subtract(rightValue);
				break;
		}		
		equation.remove(operatorPoint+1);
		equation.remove(operatorPoint);
		equation.remove(operatorPoint-1);
		
		equation.add(operatorPoint-1,leftNumber.ToString());
			
	}
	
	
	private String findLeftBracket(String rightBracket){
		int indexOfBracket = RIGHT_BRACKETS.indexOf(rightBracket);
		char leftBracket = LEFT_BRACKETS.charAt( indexOfBracket);
		return String.valueOf(leftBracket);
			
	}
	
}
