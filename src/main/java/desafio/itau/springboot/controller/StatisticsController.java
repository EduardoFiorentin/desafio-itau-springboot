package desafio.itau.springboot.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.controller.dto.EstatisticsResponseDTO;
import desafio.itau.springboot.controller.dto.TransactionRequestDTO;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.service.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {
	
	@Autowired
	private TransactionService transactionService; 
	
	@GetMapping
	public ResponseEntity<EstatisticsResponseDTO> getStatisticsFromTransactions() {
		
		DoubleSummaryStatistics statistics = transactionService.getTransactionsStatistics();
		
		return ResponseEntity.ok(EstatisticsResponseDTO.fromDoubleSummaryStatistics(statistics));
		
	}
}
