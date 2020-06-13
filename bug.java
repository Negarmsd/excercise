import java.awt.Point;
import java.util.*;
import java.io.*;
import java.lang.*;
class bug {
	public static void main (String[] args){
		Point a = new Point();
		a.x=0;
		a.y=0;
		a(a);
		b(a);
		int x = 1 ;
		c(x);
		//System.out.print(c(x));
		System.out.println(x);
		
		number test = new number("a","b");
		
		//new name();
		Integer yes = new Integer(999);
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
	public static int c(int x){
		x = 10;
		System.out.println("in void" + x);
		return x;

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

