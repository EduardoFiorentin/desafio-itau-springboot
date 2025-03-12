package desafio.itau.springboot.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class Transaction {
	private BigDecimal value;
	private OffsetDateTime dateTime;
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
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
