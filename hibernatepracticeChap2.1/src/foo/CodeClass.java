package foo;

public class CodeClass {

	/**
	 * @param args
	 */
	
	private int numberLength = 7;
    private int divisor = 10;

    public boolean FunctionOne(String input)
    {
    	//System.out.println(input);
      long result=Long.parseLong(input);
      if (input.length() <= this.numberLength || result < 0L)
       return false;
      this.numberLength = input.length();
      int num = this.numberLength;
      long input1 = result;
      while (num-- > 0)
      {
    	  //System.out.println(num);
        input1 = this.FunctionTwo(input1);
        if (!this.FunctionThree(input1))
          return false;
      }
      return true;
    }

    private boolean FunctionThree(long input)
    {
      long num1 = (long) Math.sqrt((double) input);
      //System.out.println(num1);
      if (input % 2L == 0L)
        return false;
      long num2 = 3L;
      while (num2 <= num1)
      {
        if (input % num2 == 0L){
          
          //System.out.println(num2);
          return false;
        }
        num2 += 2L;
      }
      return true;
    }

    private long FunctionTwo(long input)
    {
    	//System.out.println(input / (long) this.divisor + input % (long) this.divisor * (long) Math.pow((double) this.divisor, (double) (this.numberLength - 1)));
      return input / (long) this.divisor + input % (long) this.divisor * (long) Math.pow((double) this.divisor, (double) (this.numberLength - 1));
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String input = "10000000";
		 CodeClass code = new CodeClass();
		 boolean flag = false;
		 while(!flag){
			 input = Long.valueOf(Long.parseLong(input)+1L).toString();
			 flag = code.FunctionOne(input);
		 }
		 System.out.println(input);
	}

}
