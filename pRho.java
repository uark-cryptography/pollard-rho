
import java.util.*;

public class pRho{
							//g^t = a in Fp
	static int n = 48610;   //p-1
	int	N = n+1;
	int alpha = 19;		   //g		
	int beta = 24717;	   //a
	
	List<Integer> solve(int x, int a, int b){		
		List<Integer> intList = new ArrayList<>();
		if ( x%3 == 0){			
			x = x*x % N;  
			a =  a*2% n;  
			b =  b*2% n; 
			intList.add(x);
			intList.add(a);
			intList.add(b);
			return intList;
			
		}else if( x%3 == 1){
			
			x = x*alpha % N;  
			a = (a+1) % n;  
			intList.add(x);
			intList.add(a);
			return intList;	
			
		}else if( x%3 == 2){
			
			x = x*beta  % N;                  
			b = (b+1) % n; 
			intList.add(x);
			intList.add(b);					
			return intList;
		}
		return null;
	}
	
	public static void main(String[] args){
		
		int x = 1, a  = 0, b = 0;
		int A = a;
		int B = b;
		int X = x;
				
		pRho p = new pRho();
		
		for(int i = 1; i < n; i++){
			
			List<Integer> tmp = new ArrayList<>();
			tmp = p.solve(x, a, b);	
			switch(x%3){
				case 0: x = tmp.get(0);
						a = tmp.get(1);
						b = tmp.get(2);
						break;
				case 1: x = tmp.get(0);
						a = tmp.get(1);
						break;
				case 2: x = tmp.get(0);
						b = tmp.get(1);
						break;
			}
			
			for(int j = 0; j < 2; j++){
				tmp = p.solve(X, A, B);	
				switch(X%3){
					case 0: X = tmp.get(0);
							A = tmp.get(1);
							B = tmp.get(2);
							break;
					case 1: X = tmp.get(0);
							A = tmp.get(1);
							break;
					case 2: X = tmp.get(0);
							B = tmp.get(1);
							break;
				}
			}
			
System.out.printf("%3d  %4d %3d %3d  %4d %3d %3d\n", i, x, X, a, b, A, B );			
			
			 if( x == X ) {				 
				 break;				 
			 }	
		}
	}
}