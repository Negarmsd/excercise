class palim{
	public static void main(String[]args){
		String word ="hello";
		int a = word.length();
		System.out.println(a);
		char [] words =word.toCharArray();
		
		
		

		for (int b=a-1; b>=0;b--){
			
					
				
			String reverss =Character.toString(words[b]);
			System.out.println(reverss);
				 
		}

		
	}
}

