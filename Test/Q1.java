package Test;

public class Q1 {

	 //A

    public static int lcs(int[] X, int[] Y) {
        int [][]mat= buildMat(X,Y);
        return mat[X.length][Y.length];
    }

    public static int[][] buildMat(int[] X, int[] Y){
        int [][] mat= new int [X.length+1][Y.length+1];
        for(int i=0; i<mat.length; i++) {
            mat[i][0] = 0;
        }
        for(int i=0; i<mat[0].length; i++) {
            mat[0][i] = 0;
        }

        for(int i=1; i< mat.length; i++){
            for (int j=1; j<mat[0].length; j++){
                if(X[i-1] == Y[j-1]){
                    mat[i][j]=mat[i-1][j-1]+1;
                }
                else{
                    mat[i][j]=Math.max(mat[i][j-1], mat[i-1][j]);
                }
            }
        }
        return mat;
    }


    //B
 public static int lcs3(int[] X, int[] Y, int[] Z){
     int [][][]mat= buildMat(X,Y,Z);
     return mat[X.length][Y.length][Z.length];
 }

    public static int[][][] buildMat(int[] X, int[] Y, int[] Z){
        int [][][] mat= new int [X.length+1][Y.length+1][Z.length+1];
        for(int i=0; i<mat.length; i++) {
            mat[i][0][0] = 0;
        }
        for(int i=0; i<mat[0].length; i++) {
            mat[0][i][0] = 0;
        }
        for(int i=0; i<mat[0][0].length; i++){
            mat[0][0][i]=0;
        }

        for(int i=1; i< mat.length; i++){
            for (int j=1; j<mat[0].length; j++) {
                for (int k = 1; k < mat[0][0].length; k++) {
                    if (X[i - 1] == Y[j - 1] && Y[j-1]==Z[k-1]) {
                        mat[i][j][k] = mat[i - 1][j - 1][k-1] + 1;
                    } else {
                        mat[i][j][k] = Math.max(Math.max(mat[i][j - 1][k], mat[i - 1][j][k]),mat[i][j][k-1]);
                    }
                }
            }
        }
        return mat;
    }

	
}
