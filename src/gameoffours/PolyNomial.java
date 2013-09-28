package gameoffours;
import java.math.*;

public class PolyNomial {
	
	private double value;
	
	public PolyNomial(String value){
		this.setValue(Double.parseDouble(value));
	}
	
	public void Add(String secondValue){
		double result = this.getValue() + Double.parseDouble(secondValue);
		this.setValue(result);
	}
	
	public void Subtract(String secondValue){
		double result = this.getValue() - Double.parseDouble(secondValue);
		this.setValue(result);
	}
	
	public void MultiplyBy(String secondValue){
		double result = this.getValue() * Double.parseDouble(secondValue);
		this.setValue(result);
	}
	
	public void DivideBy(String denominator){
		double result = this.getValue() / Double.parseDouble(denominator);
		this.setValue(result);
	}
	
	public void ToThePowerOf(String exponent){
		double result = Math.pow(this.value, Double.parseDouble(exponent));
		this.setValue(result);
	}

	public double getValue() {
		return value;
	}
	
	public String ToString(){
		return String.valueOf(this.value);
	}

	public void setValue(double result) {
		this.value = result;
	}
	
	
}
