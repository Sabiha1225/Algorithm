/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author sabiha
 */
public class Kadane_Algorithm {
    
    private static int maxSubArrayProb(int[] arr)
    {
        int start = 0, end = 0;
        int max = 0;
        int curMax = 0;
        for(int i=0; i<arr.length; ++i)
        {
            curMax += arr[i];
            if(curMax < 0) 
            {
                curMax = 0;
                start = i+1;
            }
            else if(curMax > max)
            {
                max = curMax;
                end = i;
            }
        }
        
        System.out.println("Maximum Sum: " + max);
        System.out.println("Start: " + start + "  End: " + end);
        
        return max;
    }
    public static void main(String[] args)
    {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int m = maxSubArrayProb(arr);
    }
}
