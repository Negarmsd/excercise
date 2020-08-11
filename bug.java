import java.awt.Point;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Random;
class bug {
	public static void main (String[] args){
		List<Character> dude = new ArrayList<Character> ();
		dude.add('h');
		dude.add('e');
		dude.add('y');
		char struggle = " "; 
		String bruh = "theStruggle";
		char babe = 'D';
		bruh += babe;
		System.out.println("bruh" + bruh);
		Random r = new Random();
		    for(int x = 0 ; x < 50; x++) {
			    System.out.print(r.nextInt((8 - 1) + 1) + 1 + "  " );
		    }
		    char s = 'B';
		    System.out.println("*************" +Character.toLowerCase(s) + " " + s);
		    
		    test te =  new test();
		    te.a = 10000;
		    System.out.println(" class tets " + te.a);
		    System.out.println( 5 << 3) ;

		Point a = new Point();
		a.x=0;
		a.y=0;
		a(a);
		b(a);
		int[] x = new int[100] ;
		x[0] = 2;
		c(x);
		List<Integer> no = new ArrayList<Integer>() ;
		no.add(333);
		no.add(33);
		System.out.print("remove " + no.get(0) );
		no.clear();
		System.out.println("no " + no.size()+ " " );
		///System.out.print());
		while(x[0] != -1) {
		//x[(x[0] & 2)] = 1111111;
			System.out.println(x[0] + " " + (x[0] & 7));

			
				x[0]--;
		}
		System.out.println(8 % 10 + " %%%");
		
		number test = new number("a","b");
		Random random = new Random();
		while(true) {
			int aa = random.nextInt(100);
			if(aa == 99) {
				System.out.println(aa);
				break;
			}
		}
		List<Integer> zer = new ArrayList<Integer>();
		zer.add(10000);
		zer.add(4040404);
		for (int i = 0 ; i < zer.size() ;i ++ ){
			System.out.println(" ** " + zer.get(i));
		}
		zer  = zer(zer);
		for (int i = 0 ; i < zer.size(); i ++ ){
                        System.out.print("  " + zer.get(i));
                }
			
		//new name();
		//Integer yes = new Integer(999);
		//System.out.println(yes.intValue());
		
		String[] objects = {"b51","A" };
		//bubbleSort( objects);
	}
	public static void bubbleSort(String[] objects) {
		System.out.println(objects[0].compareTo(objects[1]));
	}

	public static void a(Point a){
		a.x=0;
		System.out.println(a);
	}
	public static void b (Point a){
		a.y=1;
		System.out.println(a);
	}
	public static boolean yes(Point a){
		if(a.x ==1 && a.y ==1)
			return true;
		else return false;
	}
	public static List<Integer> zer(List<Integer> zer) {
		/*for(int i = 0; i < 10 ;i++) {
			zer.add(i);
		}*/
		zer.remove(1);
		return zer;
	}
	public static void c(int[] x){
		x[0] = 23;
		System.out.println("in void" + x[0]);

		//return x;

	}
}
class number{
	String x ;
        String   y ;
        public number( String x, String y){
                this.x = x;
                this.y = y;



        }
}

class name implements Comparator<number>{ 
	
	public int compare( number numx,number numy){
		int c = ( numx.x.compareTo(numy.y));
		return c;
	}
}
class test { 
	int a;
	public test () {
		ptest();
	}
	public  int ptest() {
		System.out.print("class tetst " + a);
		return a;
	}
}

