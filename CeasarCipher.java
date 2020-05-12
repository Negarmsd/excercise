//import java.util.iArrays; 
class CeasarCipher{
	 public static void main (String[] args ){
		 String theSentence = "the ZerbRA is Wow";
		 CeasarSentence(theSentence);

	 }







	 public static void CeasarSentence (String sentence){
		 int lengthOfSentence = sentence.length();
		 //String [] words= sentence.split(" ");
		 //
		 
		 //int lengthOfWords = words.length;
		 char [] words= sentence.toCharArray();
		 int lengthofwords= words.length;
		 //System.out.print(words);
		 char [] ceasarwords =new char [lengthofwords];
		 int[]CeasarCode = new int [lengthofwords];
		 //char [] word =new char [lengthOfWords];
		
		 for (int i=0;i<lengthofwords;i++){
			 if(words[i]=='z' | words[i]=='Z' | words [i]=='Y' | words[i] =='y' |  words[i]=='x'| words [i]=='X' | words[i]=='w'| words[i]=='W' | words[i]=='v'| words[i]=='V'){
			

			 	CeasarCode[i]=words[i]-21;
			 }else 
				 CeasarCode[i]=words[i]+5;
			 //System.out.printf("%d",CeasarCode[i]);
			 ceasarwords[i]=(char)CeasarCode[i];
			 if(ceasarwords[i]=='%'){
				 ceasarwords[i]=' ';}
			 System.out.print(ceasarwords[i]);

		 }

	 }
						
		 
 }
