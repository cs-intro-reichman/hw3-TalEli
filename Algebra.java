// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(-3,-7));   // 2 + 3
	    //System.out.println(minus(7,-5));  // 7 - 2
   		//System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,-4));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(0,3));      // 5^3
   		System.out.println(pow(3,-2));      // 3^5
   		//System.out.println(div(12,3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   	    //System.out.println(div(7,2));   // 25 / 7 =3
   		//System.out.println(mod(25,7));   // 25 % 7 = 4
   		//System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
	 	System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 > 0)
		{
		for (int i = 0; i < x2; i++){
		x1++; 
		}
	    }
		else {
			for (int i=x2; i<0; i++){
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		
		if (x2 > 0)
		{
		for (int i = 0; i < x2; i++){
		 x1--; 
		}
	    }
		else {
			for (int i=x2; i<0; i++){
				x1++;
			}
		}
		return x1;

	}


	public static int times(int x1, int x2) {
	int sum = 0;
    boolean isNegative = false;

    if (x1 < 0 && x2 > 0 || x1 > 0 && x2 < 0) {
        isNegative = true;
    }

    if (x1 < 0) x1 = minus(0, x1); 
    if (x2 < 0) x2 = minus(0, x2); 
    for (int i = 0; i < x2; i++) {
        sum = plus(sum, x1);
    }

    if (isNegative) {
        sum = minus(0, sum);
    }

    return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int sum = 1;
		if (n == 0){
			return 1;
		}
		if (x == 0) {
			return 0;
		}
		for (int i = 0; i < n; i++){
			sum = times(sum, x);
		}
				return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x1 == 0 || x2 == 0){
			return 0;
		}
		int n  = 1; 
		while (x1 >= times(x2, n)){
			n++;
		}
		return n-1;
		}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		
		if (x1==0 || x2==0)
        {
            return 0;
        }
		int mod=x1; 
		while (mod>=x2)
		{
			mod=minus(mod,x2);
		}
		return mod;
		}
		
		

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int n = 1;
		while (pow(n, 2) <= x){
			n++;
		}
		return n-1;
	}	  	  
}