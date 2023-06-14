package Algorithm;

public class P12949 {
    static public void main(String args[]){
        // tc1
        // int[][] arr1 = {{1,4}, {3,2}, {4,1}};
        // int[][] arr2 = {{3,3}, {3,3}};

        // tc2
        int[][] arr1 = {{2,3,2}, {4,2,4}, {3,1,4}};
        int[][] arr2 = {{5,4,3}, {2,4,1}, {3,1,1}};

        int[][] result = solution(arr1, arr2);
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    static public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int n = arr1.length;
        int m = arr2.length;
        int l = arr2[0].length;
        
        int[][] answer = new int[n][l];
        
        for(int i=0;i<n;i++){
            int[] resultMed = new int[l];
            int[] med1 = arr1[i];
            for(int j=0;j<l;j++){
                int num=0;
                for(int k=0;k<m;k++){
                    num+=(med1[k]*arr2[k][j]);
                }
                resultMed[j]=num;
            }
            answer[i]=resultMed;
        }
        return answer;
    }
}
