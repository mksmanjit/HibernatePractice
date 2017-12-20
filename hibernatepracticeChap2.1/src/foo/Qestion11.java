package foo;

public class Qestion11 {

	 public int[][] key = new int[][]{{79,108,85},{88,79,109},{77,104,69},{105,81,79,115}};
	 

	    public  String CreatetheCipher(String plainText, int rowsize, int colsize)
	    {
	      char[] chArray1 = plainText.toCharArray();
	      int[][] numArray = new int[3][3];
	      int num1 = 0;
	      int index1 = 0;
	      int num2 = chArray1.length;
	      for (int index2 = 0; index2 < rowsize; ++index2)
	      {
	        for (int index3 = 0; index3 < colsize; ++index3)
	        {
	          if (index1 < num2)
	          {
	        	  
	            if (Character.isUpperCase(chArray1[index1]))
	              num1 = ((int) chArray1[index1] - 65);
	        	  num1 = chArray1[index1];
	            numArray[index2][index3] = num1;
	            ++index1;
	          }
	          else
	            numArray[index2][index3] = 0;
	        }
	      }
	      //System.out.println(numArray);
	      int num3 = 0;
	      char[][] chArray2 = new char[3][3];
	      for (int index2 = 0; index2 < rowsize; ++index2)
	      {
	        for (int index3 = 0; index3 < colsize; ++index3)
	        {
	          for (int index4 = 0; index4 < 3; ++index4)
	            num3 += this.key[index2][index4] * numArray[index4][index3];
	          char ch = (char) num3;
	          chArray2[index2][index3] = ch;
	          num3 = 0;
	        }
	      }
	      String str = "";
	      for (int index2 = 0; index2 < 3; ++index2)
	      {
	        for (int index3 = 0; index3 < 3; ++index3)
	          str += chArray2[index2][index3];
	      }
	      return str;
	    }
	    
	    public static void main(String[] args)
        {
	    	Qestion11 queQestion11 = new Qestion11();
            String x = "SWEETLORD";
           // key = 
            System.out.println(queQestion11.CreatetheCipher(x, 3, 3));
            /*char[] a = x.toCharArray();
            for(int i = 0;i<a.length;i++){
            	int m = (int)a[i];
            	System.out.println("char:-"+a[i]+"int:-"+m);
            	
            }*/
            //Console.WriteLine(CreatetheCipher(x, 3, 3));
            //Console.ReadKey();
        }
	    
	    
	  }

