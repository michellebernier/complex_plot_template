package math;

public class Complex {
	
	private double Real, Imaginary;
	
	public Complex(double real, double imaginary) {
		Real = real;
		Imaginary = imaginary;
	}
	
	public double getImaginary() {
		return Imaginary;
	}
	
	public double getReal() {
		return Real;
	}
	
	public double getTheta() {
		return Math.atan2(Imaginary, Real);
	}
	
	public double getModulus() {
		return Math.sqrt(Real * Real + Imaginary * Imaginary);
	}
	
	public void setReal(double real) {
		Real = real;
	}
	
	public void setImaginary(double imaginary) {
		Imaginary = imaginary;
	}
	
	public void setTheta(double theta) {
		double mod = getModulus();
		Real = mod * Math.cos(theta);
		Imaginary = mod * Math.sin(theta);
	}
	
	public void setModulus(double modulus) {
		assert modulus > 0;
		double cmod = getModulus();
		Real = modulus / cmod;
		Imaginary = modulus / cmod;
	}
	
	public void add(Complex c2) {
		Real += c2.Real;
		Imaginary += c2.Imaginary;
	}
	
	public void times(Complex c2) {
		double x = Real, y = Imaginary;
		Real = x * c2.Real - y * c2.Imaginary;
		Imaginary = x * c2.Imaginary + y * c2.Real;
	}
	
	public void dividedBy(Complex c2) {
		double x = Real, y = Imaginary;
		Real = (x * c2.Real + y * c2.Imaginary) / c2.getModulus();
		Imaginary = (y * c2.Real - x * c2.Imaginary) / c2.getModulus();
	}
	
	public void power(double r) {
		double mod = getModulus();
		double theta = getTheta();
		
		Real = Math.pow(mod, r) * Math.cos(theta * r);
		Imaginary = Math.pow(mod, r) * Math.sin(theta * r);
	}
	
	public void exp() {
		double x = Real, y = Imaginary;
		
		Real = Math.exp(x) * Math.cos(y);
		Imaginary = Math.exp(x) * Math.sin(y);
	}
	
}
