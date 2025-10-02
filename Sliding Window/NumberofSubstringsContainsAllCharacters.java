public class Solution {
    public int NumberOfSubstrings(string s) {
        int left=0;
        int n=s.Length;
        int[] frq=new int[3];
        int count=0;
        for(int right=0;right<n;right++){
            if(s[right]=='a'||s[right]=='b'||s[right]=='c'){
                frq[s[right]-'a']++;
            }
            while(frq[0]>=1&&frq[1]>=1&&frq[2]>=1){

                    count+=(n-right);
                    frq[s[left]-'a']--;
                    left++;
                
            }
        }
        return count;
    }
}
