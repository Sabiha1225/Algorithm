/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.algorithms;

/**
 *
 * @author Sabiha
 */
public class KMP_String {
    
    private int[] findLPS(String pattern)
    {
        int[] lps = new int[pattern.length()];
        
        int j = 0;
        for(int i=1; i<pattern.length(); )
        {
            if(pattern.charAt(i) == pattern.charAt(j))
            {
                lps[i] = j+1;
                i++;
                j++;
            }
            else
            {
                if(j != 0)
                {
                    j = lps[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
        return lps;
    }
    
    private boolean kmpPatternSearch(String text, String pattern)
    {
        int[] lps = findLPS(pattern);
        
        int i = 0;
        int j = 0;
        while(i < text.length() && j < pattern.length())
        {
            if(text.charAt(i) == pattern.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                if(j != 0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
        
        if(j == pattern.length())
            return true;
        return false;
        
    }
    
    public static void main(String args[]){
        
        String text = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        KMP_String ss = new KMP_String();
        boolean result = ss.kmpPatternSearch(text, pattern);
        System.out.print(result);
        
    }
}
