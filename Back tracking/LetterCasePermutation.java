class Solution {
    static ArrayList<String> result;
    static void recursion(int index,int n,char[] wordArray){
        if(index==n){
            String curResult=new String(wordArray);
            result.add(curResult);
            return;
        }
            
            if(Character.isAlphabetic(wordArray[index])){
                recursion(index+1,n,wordArray);
                wordArray[index]=(Character.isUpperCase(wordArray[index]))?Character.toLowerCase(wordArray[index]):Character.toUpperCase(wordArray[index]);
                recursion(index+1,n,wordArray);
                wordArray[index]=(Character.isUpperCase(wordArray[index]))?Character.toLowerCase(wordArray[index]):Character.toUpperCase(wordArray[index]);
            }
            else{
                recursion(index+1,n,wordArray);
            }
        
    }
    public List<String> letterCasePermutation(String s) {
        result=new ArrayList<>();
        char[] wordArray=s.toCharArray();
        int n=wordArray.length;
        recursion(0,n,wordArray);
        return result;
    }
}
