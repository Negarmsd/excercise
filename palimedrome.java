
class palimedromw{
        public static void main(String[]args){
                String word ="hello";
                int a = word.length();
                //System.out.println(word);
                char [] words =word.toCharArray();
                char [] revers= new char [a];

                for (int b=a-1; b>=0;b--)
		{
			revers[a-4]=words[b];
			System.out.print(revers[a-4]);
                }

                
        }
}
