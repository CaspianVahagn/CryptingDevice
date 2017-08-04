package UnitTests;
import MyObjects.*;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class MyUnitTest {

	TestMyShit tms = new TestMyShit();
	Automazer atm = new Automazer();
	Cryptor cr;
	Zufaller ff = new Zufaller();
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void runMyMath(){
		
		int[] g = {2,3,9};
		
		assertEquals(tms.sumListStream(g),14);
		assertEquals(tms.classicSumlist(g),14);
		
		
	}
	
	@Test
	public void runMyList() throws Exception{
		assertEquals(atm.randomArrayList(5).length , 5);
		assertEquals(atm.randomArrayList(0).length , 0);
		assertEquals(atm.randomArrayList(40).length , 40);
	}
	
	@Test
	public void RandomList(){
		try {
			
			atm.randomArrayList(-5);
		} catch (Exception e) {
			assertEquals("no negative",e.getMessage());
			// TODO: handle exception
		}
		
	   
	   
		
	}
	
	@Test
	public void combineTest(){
		int g[];
		try {
			g = atm.randomArrayList(945);
			assertEquals(tms.sumListStream(g),tms.classicSumlist(g));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void cryptingTest(){
		cr = new Cryptor(17);
		assertFalse(cr.crypt("hallo").equals("hallo"));
		assertEquals("hallo",cr.decrypt(cr.crypt("hallo")));
		String test = cr.crypt("hallo");
		cr = new Cryptor(13);
		assertNotEquals("hallo", cr.decrypt(test));
		cr = new Cryptor(17);
		assertEquals("hallo", cr.decrypt(test));
		
		
	}
	@Test
	public void testZufall(){
		ff.setMax(100);
		int[] counters = new int[100]; 
		for (int i = 0; i < 1000; i++) {
			int z = ff.createZahl();
			assertTrue(z<=100 && z>= 1);
		}
	}
	@Test
	public void verteilung(){
		int max =1000;
		ff.setMax(max);
		int[] counters = new int[max];
		int n =  10_000_000;
		for (int i = 0; i < n; i++) {
			int z = ff.createZahl();
			counters[z-1]++;
		}
		for (int i = 0; i < counters.length; i++) {
			System.out.println(counters[i]);
			assertTrue(counters[i] <= n/max*1.05 && counters[i] >= n/max*0.95);
			
		}
	
	}
	
	
		
}

