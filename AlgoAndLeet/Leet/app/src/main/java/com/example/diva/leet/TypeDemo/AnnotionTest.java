package com.example.diva.leet.TypeDemo;

import java.lang.reflect.Method;
import java.util.List;

public class AnnotionTest<T> {

    /***
     *
     */
    public List<String> getReturnType() {
        Class clz = this.getClass();
        try {
            Method method = clz.getMethod("getReturnType", null);
            System.out.println("getGenericReturnType     " + method.getGenericReturnType());
            System.out.println("getReturnType     " + method.getReturnType());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
        try {
            Class clz = Class.forName("com.example.diva.leet.TypeDemo.GitHubService");
            Method method = clz.getMethod("listRepos", String.class);
            System.out.println("getGenericReturnType     " + method.getGenericReturnType());
            System.out.println("getReturnType     " + method.getReturnType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    T t;

    public T get(){
        return t;
    }
    public  void set(T t){
        this.t = t;
    }


}
