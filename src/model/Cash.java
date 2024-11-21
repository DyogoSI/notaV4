package model;

public class Cash implements PaymentMethod {
	private double discount;
	
	public Cash(double discount) {
		this.discount = discount/100;
	}
	
	@Override
	public double calculate(double value) {
		return value - (value * discount);
	}
	
	@Override
	public String toString() {
		return "Dinheiro/Pix";
	}
}
