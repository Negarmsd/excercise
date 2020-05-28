import java.awt.Point;
class bug {
	public static void main (String[] args){
		Point a = new Point();
		a.x=0;
		a.y=0;
		a(a);
		b(a);
		System.out.print(yes(a));
	}


	public static void a(Point a){
		a.x=0;
	}
	public static void b (Point a){
		a.y=1;
	}
	public static boolean yes(Point a){
		if(a.x ==1 && a.y ==1)
			return true;
		else return false;
	}
}
