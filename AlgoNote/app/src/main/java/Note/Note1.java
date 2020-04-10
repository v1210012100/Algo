package Note;

public class Note1 {
    /***
     * 双指针解法 : 这个双指针比较特殊， 不需要全部遍历完成，当为奇数时 。不需要遍历 指针 i= j 的情况
     * 当为偶数时： 是全部遍历( 访问了对应指针所指向的值 )  。
     * 关于循环 ：1 循环的条件 ,  循环操作  。    满足了终止条件 ， 跳出循环 。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i<j){

            // 在 i<j 的情况下 找到 合法字符串 而终止 ， 或者因 i==j 而终止
            while(i<j && !isLeagle(s.charAt(i))) i++;


            while(i<j && !isLeagle(s.charAt(j))) j--;



            if(i<j && !equalIgnore(s.charAt(i),s.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean isLeagle(char c){
        return ( c>='a'&& c<='z' || c>='0' &&c<='9'|| c>='A'&&c<='Z');
    }

    /***
     * 全部转小写再比较
     * @param a
     * @param b
     * @return
     */
    public static boolean equalIgnore(char a,char b){
        if(a>='A'&&a<='Z') a +=('a'-'A');
        if(b>='A'&&b<='Z') b +=('a'-'A');
        return a==b;
    }
}
