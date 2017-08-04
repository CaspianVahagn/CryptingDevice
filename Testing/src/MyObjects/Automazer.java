package MyObjects;

import java.util.ArrayList;
import java.util.Random;

public class Automazer {

	public int[] randomArrayList(int n) throws Exception
	{
		
		if(n < 0){
			throw new Exception("no negative");
		}
		
	    ArrayList<Integer> list = new ArrayList<>();
	    Random random = new Random();

	    for (int i = 0; i < n; i++)
	    {
	        list.add(random.nextInt(255));
	    }
	   
	    return list.stream().mapToInt(i -> i).toArray();
	}
	
	
	
}
