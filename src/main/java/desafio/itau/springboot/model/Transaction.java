package desafio.itau.springboot.model;

import java.time.OffsetDateTime;



public class Transaction {
	private double value;
	private OffsetDateTime dateTime;
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public OffsetDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(OffsetDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	@Override
	public String toString() {
		return "Transaction [value=" + value + ", dateTime=" + dateTime + ", getValue()=" + getValue()
				+ ", getDateTime()=" + getDateTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	} 
	
	
}
