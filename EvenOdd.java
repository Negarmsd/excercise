import java.util.Arrays;
class EvenOdd{
	 public static void main (String[] args){
		  String numbers ="123,23,232323,";

		 isOddEven(numbers);
	 }
	 public static void isOddEven(String numbers){
		 int length=numbers.length();
		 String[] number= new String [length];
		 System.out.println(length);
		 for(int count=0;count<1;count++){
			 
			 number[count]=numbers;
		 }
	 	
		 int a= number.length;
		 System.out.println(Arrays.toString(number));


		 int [] num = new int [a];
		 //num =number.charAt();
		 System.out.println(a);
		 int last =0;
		 int counter=0;
		 for (int j=0;j<a;j++){
			 num[j]=Integer.parseInt(number[j]);
		 }

		 for (int i=0;i<a;i++){
			 

			 if(num[i]==',')
			 {
				 counter++;
				 last=num[i-1];
				 if(last%2==0){
					System.out.println(counter);
				 }
			 }
		 }
	 }
 }
			 
				 
