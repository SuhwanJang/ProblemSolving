package recursion.math;
import java.util.*;

//Assume exist class SquareMatrix
public class DAQ_powOfMatrix {
	
	//SquareMatrix identity(int n) return n*n Identity Matrix(I)
	SquareMatrix pow(SquareMatrix A, int m)
	{
		if(m==0) return identity(A.size());
		if(m%2==1) return pow(A, m-1)*A;
		SquareMatrix half = pow(A, m/2);
		return half*half;
			
	}
	public static void main(String[] args)
	{
		
	}
}
