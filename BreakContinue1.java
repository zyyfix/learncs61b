public class BreakContinue1{
	public static void windowPosSum(int[] a,int n){
		int i=0,j=0;
		for(i=0;i<a.length;i++){
			if(a[i]<0)
			{
				continue;
			}
			for(j=i;j<i+n;j++){
				if(j+1>=a.length)
					break;
				a[i]=a[i]+a[j+1];
			}
		}	
	}
	public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);
        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}
