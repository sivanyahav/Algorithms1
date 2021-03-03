package Test;

public class Q2 {

	 //A
    public static int longestOfOne(int[] arr) {
        int length= help_arr(arr);
        return length;
    }

    public static int help_arr(int[] arr){
        int n= arr.length, max_ind=0;
        int[] help_arr= new int[n];
        help_arr[0]= arr[0];
        for (int i=1; i<n; i++){
            if(arr[i]==1){
                help_arr[i]=help_arr[i-1]+1;
                if(help_arr[i]>help_arr[max_ind])
                    max_ind=i;
            }
            else{
                help_arr[i]=0;
            }
        }
        return help_arr[max_ind];
    }

    //B
    public static int imaginaryPlus(int[][] arr) {
        int max= 0;
        int n=arr.length, m=arr[0].length;
        int[][] u= new int [n][m];
        int[][] d= new int [n][m];
        int[][] r= new int [n][m];
        int[][] l= new int [n][m];

        for (int i=0; i<m; i++){u[0][i]=arr[0][i];}
        for (int i=0; i<m; i++){d[n-1][i]=arr[n-1][i];}
        for(int i=0; i<n; i++){l[i][0]= arr[i][0];}
        for(int i=0; i<n; i++){r[i][m-1]= arr[i][m-1];}

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(arr[i][j]!=0){
                    if( i != 0) {u[i][j]= u[i-1][j]+1;}
                    if(j != 0) {l[i][j]= l[i][j-1]+1;}
                }
            }
        }

        for(int i=n-1; i>=0; i--){
            for (int j= m-1; j>=0; j--){
                if(arr[i][j]!=0) {
                    if (i != n - 1) {d[i][j] = d[i + 1][j] + 1;}
                    if (j != m - 1) {r[i][j] = r[i][j+1]+1;}
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                int up= u[i][j];
                int down=d[i][j];
                int left=l[i][j];
                int right= r[i][j];
                int curr_sum= up+down+left+right-3;
                if(curr_sum>max)
                    max=curr_sum;
            }
        }
        return max;

    }
	
}
