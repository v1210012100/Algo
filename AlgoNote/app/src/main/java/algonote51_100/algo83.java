package algonote51_100;

// 带判断技巧的双指针
public class algo83 {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();
        int i =0,j=0;
        if(c.length == 0) return s;
        while(i<c.length){
            if(j<c.length && c[j]!= ' ') {
                j++;
            }else{
                int temp = j-1;
                while(i<temp){
                    char t = c[temp];
                    c[temp] = c[i];
                    c[i] = t;
                    i++;
                    temp--;
                }
                j++;
                i = j;
            }
        }
        return new String(c);
    }
}
