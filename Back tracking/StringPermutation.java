/*
Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

Examples:

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.
Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.
Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same.
*/
class Solution {
    static Set<String> set;
    static void swap(char str[],int i,int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }
    static void recursion(char str[],int index){
        if(index==str.length){
            set.add(new String(str));
            return;
        }
        for(int j=index;j<str.length;j++){
            swap(str,index,j);
            recursion(str,index+1);
            swap(str,index,j);
        }
    }
    public ArrayList<String> findPermutation(String s) {
        // Code here
        set=new LinkedHashSet<>();
        char str[]=s.toCharArray();
        recursion(str,0);
        ArrayList<String> list=new ArrayList<>(set);
        return list;
    }
}
