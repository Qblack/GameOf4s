package gameoffours;

public class PolynomialImp implements Polynomial {
	
	private double value;
	
	public PolynomialImp(String value){
		this.setValue(Double.parseDouble(value));
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Polynomial#Add(java.lang.String)
	 */
	@Override
	public void Add(String secondValue){
		double result = this.getValue() + Double.parseDouble(secondValue);
		this.setValue(result);
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Polynomial#Subtract(java.lang.String)
	 */
	@Override
	public void Subtract(String secondValue){
		double result = this.getValue() - Double.parseDouble(secondValue);
		this.setValue(result);
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Polynomial#MultiplyBy(java.lang.String)
	 */
	@Override
	public void MultiplyBy(String secondValue){
		double result = this.getValue() * Double.parseDouble(secondValue);
		this.setValue(result);
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Polynomial#DivideBy(java.lang.String)
	 */
	@Override
	public void DivideBy(String denominator){
		double result = this.getValue() / Double.parseDouble(denominator);
		this.setValue(result);
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Polynomial#ToThePowerOf(java.lang.String)
	 */
	@Override
	public void ToThePowerOf(String exponent){
		double result = Math.pow(this.value, Double.parseDouble(exponent));
		this.setValue(result);
	}

	/* (non-Javadoc)
	 * @see gameoffours.Polynomial#getValue()
	 */
	@Override
	public double getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see gameoffours.Polynomial#ToString()
	 */
	@Override
	public String ToString(){
		return String.valueOf(this.value);
	}

	/* (non-Javadoc)
	 * @see gameoffours.Polynomial#setValue(double)
	 */
	@Override
	public void setValue(double result) {
		this.value = result;
	}


	
	
}
