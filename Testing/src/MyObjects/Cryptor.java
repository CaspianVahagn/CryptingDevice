/**
 * @author Dominik Leipelt
 */
package MyObjects;

import java.util.ArrayList;
import java.util.List;

public class Cryptor {
	
	int[] cryponizers= new int[455];
	 
//	static String letters = "qayxswedc vfrtgbnhzujmkiolöpüäQAYXSWEDCVFRTGBZHNUJMIKOLPÖÄÜß?1234567890!§$%&/()=.,;:";
	
	static String letters = "`´=N?P§äU,MqÖa3uhbo\t8Efü[7QÜßW;I\"m6SB-9VZsTYg!2'#~GD_4:0AipJCj]{@}rxRzt„“ lK&\n(1kLöX/%wyeO$cHvF5nÄd*.)";
	public Cryptor(int key) {
		for (int i = 0; i < cryponizers.length; i++) {
			int val = (key+(i*i))*97;
			if(val%2 == 0){
				val+=1;
				
			}
			
			cryponizers[i] = val;
		}
		
	}

	public  String crypt(String s){
		char[] c = s.toCharArray();
	
		for (int i = 0; i < c.length; i++) {
			c[i] = letters.charAt(((letters.indexOf(c[i]) + (cryponizers[i%455])) % letters.length()));
			
			
		}
		
		return new String(c);
	}
	
	
	public  String decrypt(String s){
		char[] c = s.toCharArray();
		
		
		for (int i = 0; i < c.length; i++) {
			
			int x = (letters.indexOf(c[i])-cryponizers[i%455]) % letters.length();
			if (x<0) x+= letters.length();
			c[i] = letters.charAt(x);
		}
		
//		for (int i = 0; i < c.length; i++) {
//			int x =  ((Integer.valueOf(c[i])-cryponizers[i%455])%126);
//			if (x<0) x+= 126;
//			c[i] = (char) x;
//			
//			
//		}
		
		return new String(c);
	}
	
	  public String shuffle(String input){
	        List<Character> characters = new ArrayList<Character>();
	        for(char c:input.toCharArray()){
	            characters.add(c);
	        }
	        StringBuilder output = new StringBuilder(input.length());
	        while(characters.size()!=0){
	            int randPicker = (int)(Math.random()*characters.size());
	            output.append(characters.remove(randPicker));
	        }
	       return output.toString();
	    }
	
	
	public static void main(String[] args) {
		 Cryptor c = new Cryptor(35);
		 String test = "Lorem ipsum dolor sit amet, "
		 		+ "consetetur sadipscing elitr, sed diam "
		 		+ "nonumy eirmod tempor invidunt ut labore "
		 		+ "et dolore magna aliÜquyam erat, sed diam "
		 		+ "voluptua. At vero eos et accusam et justo "
		 		+ "duo dolores et ea rebum. Stet clita kasd"
		 		+ " gubergren, no sea takimata sanctus est Lorem "
		 		+ "ipsum dolor sit amet. Lorem ipsum dolor sit amet, "
		 		+ "consetetur sadipscing elitr, sed diam nonumy eirmod "
		 		+ "tempor invidunt ut labore et dolore magna aliquyam erat, "
		 		+ "sed diam voluptua. At vero eos et accusam et justo duo "
		 		+ "dolores et ea rebum. Stet clita kasd gubergren, no sea "
		 		+ "takimata sanctus est Lorem ipsum dolor sit amet.";
		 System.out.println(c.crypt(test));
		 System.out.println(c.decrypt(c.crypt(test)));
		 System.out.println();
		 
		 
	}
}
