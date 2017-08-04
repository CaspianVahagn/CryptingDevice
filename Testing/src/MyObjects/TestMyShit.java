package MyObjects;
import java.util.*;
import java.util.stream.IntStream;
public class TestMyShit {
	
	
	
	public String reverseString(String s){

		return new StringBuilder(s).reverse().toString();
		
	}
	
	public int sumListStream(int[] g){

		return IntStream.of(g).sum();
	}
	
	public int classicSumlist(int [] g){
		int sum =0 ;
		
		for (int i = 0; i < g.length; i++) {
			sum += g[i];
		}
		return sum;
	}
	
	
	
	

}
