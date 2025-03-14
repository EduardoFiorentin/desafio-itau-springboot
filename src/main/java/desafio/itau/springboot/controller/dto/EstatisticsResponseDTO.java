package desafio.itau.springboot.controller.dto;

import java.util.DoubleSummaryStatistics;

public record EstatisticsResponseDTO (
		Long count,
		Double sum,
		Double avg,
		Double min,
		Double max
	){

	public static EstatisticsResponseDTO fromDoubleSummaryStatistics(DoubleSummaryStatistics summary) {
		Double min = summary.getMin();
		if (Double.isInfinite(min))
			min = 0.0; 
		
		Double max = summary.getMax();
		if (Double.isInfinite(max))
			max = 0.0; 
		
		return new EstatisticsResponseDTO(
				summary.getCount(), 
				summary.getSum(), 
				summary.getAverage(), 
				min, 
				max
		);
	}
	
}
