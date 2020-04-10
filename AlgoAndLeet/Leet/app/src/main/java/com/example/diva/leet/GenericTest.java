package com.example.diva.leet;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenericTest<T> {                 //  1
    public List<T> list = new ArrayList<>();                     // 2
    public List<String> stringList = new ArrayList<>();               // 3

    public <K> K genericMethod(K key) { // 4
        List<String> list = new ArrayList<>();
        list.add(" 这是一个 局部变量的 泛型");

        return key;
    }

    public T put(T t){
        list.add(t);
        return t;
    }


    public static void main(String args[]){
        try{
            GenericTest<String> genericTest = new GenericTest<>();
            Class<?> testClass = genericTest.getClass();
            Field field = testClass.getField("list");
            Field field2 = testClass.getField("stringList");
            System.out.println("list 的泛型 "+ field.getGenericType());
            System.out.println("stringList 的泛型 "+ field2.getGenericType());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}