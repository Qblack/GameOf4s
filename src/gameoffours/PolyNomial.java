package gameoffours;

public interface Polynomial {

		
	public void Add(String secondValue);

	public void Subtract(String secondValue);

	public void MultiplyBy(String secondValue);

	public void DivideBy(String denominator);

	public void ToThePowerOf(String exponent);

	public double getValue();

	public abstract String ToString();

	public void setValue(double result);

}