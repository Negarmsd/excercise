import java.util.Arrays;
import java.util.*;

class basicII{
	public static void main (String[] args){
	/*this is the input for rowsColumnsChanger method
	 * int [][]numbers =new int[3][2];
		numbers[0][0]=10;
		numbers[1][0]=20;
		numbers[2][0]=30;
		numbers[0][1]=40;
		numbers[1][1]=50;
		numbers[2][1]=60;
		System.out.println(numbers);
		int rowsSize = numbers.length;
                int columnsSize = numbers[0].length;
		rowsColumnsChanger(numbers);*/
		//plusOne();
		shuffle();










	}

	public static void shuffle (){
		Integer [] num = new Integer[54];
		for (int i = 0 ; i<54 ; i++){
			num[i] = i;
		}
		
		Collections.shuffle(Arrays.asList(num));
		System.out.println(Arrays.toString(num));
	}


	//this function print 3 biggest numbers in an array 
	public static void biggestInArray(){
		int[] numbers={1,4,17,25,3,100,5,8};
		int size=numbers.length;
		Arrays.sort(numbers);
		System.out.print(Arrays.toString(numbers));
	}

	//prints average of the numbers in an array and the numbers bigger than average
	public static void average(){
		int [] numbers = {1,4,25,3,100,17};
		int size = numbers.length;
		int holder =0;
		for(int i=0 ; i<size ;i++){
			holder+=numbers[i];
		}
		System.out.print(holder/size);
		for(int j=0; j<size ;j++){
			if(numbers[j]>(holder/size)){
			
			System.out.println(numbers[j]);
			}
		}
	}

	//prints the numbers that they are smaller than numbers in another Array

	public static void compare(){
		int [] numbers ={2,11,12,2,21,64,43,33,4};
		int [] num = { 6,54,688,87,6,66,543,54,6};
		Arrays.sort(numbers);
		Arrays.sort(num);
		for(int i=0;i<8;i++){
			if(num[i]>numbers[i]){
				System.out.println(numbers[i]);
			}
		}
	}

	//lus one to the number of a given positive numbers represented as an array of digits.
	public static void plusOne(){
		int [] number ={9,9,9};
		int size= number.length;
		int holder =0;
		int count=1;
		for(int i=0 ;i<size;i++){
			holder= holder + count * number[i];
			count*=10;
		}
		holder+=1;
		int [] plus = new int [4];
		for(int j=0 ; j<4 ; j++ ){
			plus[3-j]=holder%10;
		}


		System.out.println(Arrays.toString(plus));
	}


	

	//this function changes the row and columns of a two demonsial Array
	public static void rowsColumnsChanger(int[][]numbers){

		int rowsSize = numbers.length;
		int columnsSize = numbers[0].length;
		int [][] number=new int[columnsSize][rowsSize];
		for(int i=0;i<rowsSize;i++){
			for (int j=0 ; j<columnsSize;j++){
				number[j][i]=numbers[i][j];
				System.out.printf("%d  ",number[j][i]);
			}
		}
	}
}




























