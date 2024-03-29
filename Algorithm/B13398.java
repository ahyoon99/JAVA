package Algorithm;

import java.util.*;

public class B13398 {
    // 방법 1 : Bottom up
    // static public void main(String args[]){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] num = new int[n];
    //     for(int i=0;i<n;i++){
    //         num[i]=sc.nextInt();
    //     }
    //     Integer[] leftMax = new Integer[n];
    //     Integer[] rightMax = new Integer[n];
        
    //     Arrays.fill(leftMax,null);
    //     Arrays.fill(rightMax,null);
        
    //     leftMax[0]=num[0];
    //     rightMax[n-1]=num[n-1];

    //     for(int i=1;i<n;i++){
    //         if(num[i]<leftMax[i-1]+num[i]){
    //             leftMax[i] = leftMax[i-1]+num[i];
    //         }
    //         else{
    //             leftMax[i] = num[i];
    //         }
    //     }

    //     for(int i=n-2;i>=0;i--){
    //         if(num[i]<rightMax[i+1]+num[i]){
    //             rightMax[i] = rightMax[i+1]+num[i];
    //         }
    //         else{
    //             rightMax[i]=num[i];
    //         }
    //     }

    //     Integer[] allElement = leftMax.clone();
    //     Arrays.sort(allElement);
    //     int maxValue = allElement[n-1];
    //     int med = 0;
    //     for(int i=1;i<n-1;i++){
    //         if(i==0){
    //             med = rightMax[1];
    //         }
    //         else if(i==n-1){
    //             med = leftMax[n-2];
    //         }
    //         else{
    //             med = leftMax[i-1]+rightMax[i+1];
    //         }
    //         if(maxValue<med){
    //             maxValue = med;
    //         }
    //     }
    //     System.out.println(maxValue);
    // }

    // 방법 2 : Top-down
    static int left(Integer[] num, Integer[] leftMax, int idx){
        if(leftMax[idx]!=null){
            return leftMax[idx];
        }
        int med = left(num, leftMax, idx-1);
        if(num[idx]<med+num[idx]){
            leftMax[idx]=med+num[idx];
        }
        else{
            leftMax[idx]=num[idx];
        }
        return leftMax[idx];
    }
    static public void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] num = new Integer[n];
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        Integer[] leftMax = new Integer[n];
        Integer[] rightMax = new Integer[n];

        Arrays.fill(leftMax, null);
        Arrays.fill(rightMax, null);

        leftMax[0]=num[0];
        rightMax[0]=num[n-1];
        left(num, leftMax, n-1);

        List<Integer> reverseRightMax = Arrays.asList(num);
        Collections.reverse(reverseRightMax);
        Integer[] reverseNum = reverseRightMax.toArray(new Integer[reverseRightMax.size()]);
        left(reverseNum, rightMax, n-1);

        reverseRightMax = Arrays.asList(rightMax);
        Collections.reverse(reverseRightMax);
        rightMax = reverseRightMax.toArray(new Integer[reverseRightMax.size()]);

        Integer[] sortedLeftMax = new Integer[n];
        sortedLeftMax = leftMax.clone();
        Arrays.sort(sortedLeftMax);
        int maxValue = sortedLeftMax[n-1];

        for(int i=0;i<n-1;i++){
            int med = 0;
            if(i==0){
                med = rightMax[1];
            }
            else{
                med = leftMax[i-1]+rightMax[i+1];
            }
            if(maxValue<med){
                maxValue = med;
            }
        }
        System.out.println(maxValue);
    }
}
