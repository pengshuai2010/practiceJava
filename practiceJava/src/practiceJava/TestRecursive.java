package practiceJava;

public class TestRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
		ruler(0, 32, 6);
		int[] a = {0, 1, 2, 3, 4, 5};
		reverseArray(a, 0, a.length);
		System.out.println(java.util.Arrays.toString(a));
		
	}
	
	public static long factorial(long n){
		if(n == 0){
			return 1;
		}else{
			return n*factorial(n-1);
		}
	}
	
	public static void ruler(double start, double end, double tick){
		if(end - start < 1 || tick < 1){
			return;
		}
		ruler(start, start + (end - start)/2, tick-1);
		for(int i = 0; i < tick; i++){
			System.out.print("-");
		}
		System.out.println();
		ruler(start + (end - start)/2, end, tick-1);
	}
	
	public static void reverseArray(int[] a, int start, int end){
		if(start < end){
			int tmp = a[start];
			a[start] = a[end-1];
			a[end-1] = tmp;
			reverseArray(a, start + 1, end - 1);
		}
		
	}

}
