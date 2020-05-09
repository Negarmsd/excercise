class fibunachi{
	public static void main (String[] args)
	{
	isfibuna();
	}


	public static void isfibuna(){
		int firstnum=1;
		int i=1;
		int counter=0;
		int another=0;
		for(int a=0;a<=10;a++){
			another=firstnum;
			firstnum=firstnum+i;
			counter=firstnum;
			i=another;



			System.out.println(counter);
		}
	}
	






}


	

