package desafio.itau.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.controller.dto.TransactionRequestDTO;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.service.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService; 
	
	@PostMapping
	public ResponseEntity<Void> recieveTransaction(@Valid @RequestBody TransactionRequestDTO dto) {
		
		Transaction transaction = dto.parseToTransaction(); 
		transactionService.insertTransaction(transaction);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
