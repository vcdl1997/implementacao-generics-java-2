package models.services;
import java.util.List;

public class CalculationService<G extends Comparable<G>>{
	
	public G max(List<G> list){
		
		if(list.isEmpty()) throw new IllegalArgumentException("List is Empty!");
		
		G max = list.get(0);
		
		for(G row : list) {
			if(row.compareTo(max) > 0) {
				max = row;
			}
		}
		
		return max;
	}
}
