package com.example.diva.leet.SwordOffer;

import java.util.ArrayList;
import java.util.HashSet;

public class Sword38 {
    HashSet<String> set = new HashSet<>();
    boolean[] visited ;
    ArrayList<Character> arrayList = new ArrayList<>();


    public String[] permutation(String s) {
        visited = new boolean[s.length()];
        help(s,"");
        String [] result = new String[set.size()];
        int i =0;
        for(String str: set){
            result[i++] = str;
        }
        return result;
    }

    /***
     *  每次都需要 创建一个新的Str 。效率其实还可以。
     *
     *  这种解法 为什么 不用删除 temp 添加的 部分 ：temp+s.charAt(j)
     *  因为我们是值传递 。temp + s.charAt(j)  又形成了一个新的对象。
     * @param s
     * @param temp
     */
    public  void help(String s,String temp){
        if(temp.length() ==s.length()){
            set.add(temp);
            return;
        }
        for(int j=0;j<s.length();j++){
            if(!visited[j]){
                visited[j] = true;
                help(s,temp+s.charAt(j));
                visited[j] = false;
            }
        }


    }


    public  void help2(String s){
        if(arrayList.size() ==s.length()){
            StringBuilder stringBuilder = new StringBuilder();
            for(Character character: arrayList){
                stringBuilder.append(character);
            }
            set.add(stringBuilder.toString());
            return;
        }
        for(int j=0;j<s.length();j++){
            if(!visited[j]){
                visited[j] = true;
                arrayList.add(s.charAt(j));
                help2(s);
                arrayList.remove(arrayList.size()-1);
                visited[j] = false;
            }
        }
    }
}
