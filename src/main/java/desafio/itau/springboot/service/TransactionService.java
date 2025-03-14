package desafio.itau.springboot.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.storage.CustomStorage;

@Service
public class TransactionService {
	
	private final CustomStorage<Transaction> storage = new CustomStorage<Transaction>();
	
	@Value("${spring.application.transaction-statistics-time}")
	private int transactionStatisticsTime;
	
	
	public void insertTransaction(Transaction transaction) {
		storage.addItem(transaction);
	}
	
	public void deleteAllTransactions() {
		storage.clearItens();
	}
	
	public DoubleSummaryStatistics getTransactionsStatistics() {
		OffsetDateTime limitStatisticsTime = OffsetDateTime.now().minusSeconds(transactionStatisticsTime);
		Stream<Transaction> allTransactions = (Stream<Transaction>) storage.getAllItems();
		Stream<Transaction> allTransactionsTest = storage.getAllItems();
		
		List<Transaction> transactionsInTime = new ArrayList<Transaction>();
		
		for (var transaction: allTransactions.toList()) {
			
			if ( transaction.getDateTime().isAfter(limitStatisticsTime) ) {
				transactionsInTime.add(transaction);
			}
			
		}
		
		DoubleSummaryStatistics transactionValues = transactionsInTime
				.stream()
				.mapToDouble(Transaction::getValue)
				.summaryStatistics();
		
		
		 return transactionValues; 
	}
}
