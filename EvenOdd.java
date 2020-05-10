import java.util.Arrays;
class EvenOdd{
	 public static void main (String[] args){
		  String numbers ="1112,22222,2222,323456543,123,23,232323,";

		 isOddEven(numbers);
	 }
	 public static void isOddEven(String numbers)
	 {

		 int length=numbers.length();
		 String[] number= numbers.split(",");
		 //System.out.println(length);	 
		 int a= number.length;
		 //System.out.println(Arrays.toString(number));
		 int [] num = new int [a];
		 //num =number.charAt();
		 //System.out.println(a);
		 int last =0;
		 int counter=0;
		 for (int j=0;j<a;j++){
			 num[j]=Integer.parseInt(number[j]);
		 }
		 
		for (int i=0;i<a;i++){
			//System.out.printf("i%d",num[i]);
			if(num[i]%2==0){
				System.out.printf("e%d  " ,num[i]);
			}else 
				System.out.printf("o%d  ",num[i]);
		}
	 }
}
 
			 
				 
