package desafio.itau.springboot.controller.dto;

import java.time.OffsetDateTime;

import desafio.itau.springboot.model.Transaction;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class TransactionRequestDTO {
	
	@NotNull
	@Min(0)
	private Double valor;
	
	@NotNull
	@PastOrPresent
	private OffsetDateTime dataHora;

	public TransactionRequestDTO(Double valor, OffsetDateTime dataHora) {
		this.valor = valor;
		this.dataHora = dataHora;
	}

	public Transaction parseToTransaction() {
		Transaction transaction = new Transaction();
		transaction.setDateTime(dataHora);
		transaction.setValue(valor);
		return transaction; 
	}
}
