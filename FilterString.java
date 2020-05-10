 class FilterString{
	 public static void main (String [] args){
		 String List []={"oaa","abc","cdcdeWCe","ecwaAEvgare","asaass","asd","aaa","awa"};
		 //int a= List.length();
		 for (int i=0;i<8;i++){
			 Filter(List[i]);
			 System.out.print(List[i]);
		 }
		 


	 }
	public static void Filter(String List){
		int length =List.length();
		int counter=0;
		char astart []=List.toCharArray();

				if(length==3){

					counter++;
					System.out.print(counter);
					int j= counter *3;
					char []word =new char [j];
					if(astart[0]=='a'){
				
						for (int i=0;i<=counter*3;i++){
							word[i]=astart[i];
							System.out.print(word[i]);
							if(i==counter*3)
								break;
					
				}

				
			}	
			
		}	
	}


 }
