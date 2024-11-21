package model;

public class DebitCard implements PaymentMethod {
	
	private double fees;
	
	public DebitCard(double fees) {
		this.fees = fees/100;
	}
	
	@Override
	public double calculate(double value) {
		return value + (value * fees);
	}
	
	@Override
	public String toString() {
		return "Cartão de Débito";
	}
}
