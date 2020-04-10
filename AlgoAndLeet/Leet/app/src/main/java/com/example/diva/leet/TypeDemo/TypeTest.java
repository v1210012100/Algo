package com.example.diva.leet.TypeDemo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.*;

public class TypeTest<T, V extends  Number & Serializable> {
    private Number number;
    public T t;
    public V v;
    public List<T> list = new ArrayList<>();
    public Map<String, T> map = new HashMap<>();

    public T[] tArray;
    public List<T>[] ltArray;

    public TypeTest testClass;
    public TypeTest<T, Integer> testClass2;

    public Map<? super String, ? extends Number> mapWithWildcard;

    //泛型构造函数,泛型参数为X
    public <X extends Number> TypeTest(X x, T t) {
        number = x;
        this.t = t;
    }

    //泛型方法，泛型参数为Y
    public <Y extends T> void method(Y y) {
        t = y;
    }







    public static  void main(String args[]){
        try{
//            Field v = TypeTest.class.getField("v");//用反射的方式获取属性 public V v;
//            TypeVariable typeVariable = (TypeVariable) v.getGenericType();//获取属性类型
//            System.out.println("TypeVariable1:  getClass  " + typeVariable.getClass());
//            System.out.println("TypeVariable2:" + Arrays.asList(typeVariable.getBounds()));//获取类型变量上界
//            System.out.println("TypeVariable3:" + typeVariable.getGenericDeclaration());//获取类型变量声明载体
//            System.out.println("TypeVariable5:" + typeVariable.getName());


            Field list = TypeTest.class.getField("list");
            Type genericType1 = list.getGenericType();
            System.out.println("参数类型1:  的 String " + genericType1.getTypeName()); //参数类型1:java.util.List<T>
            System.out.println("参数类型1:  的 class " + genericType1.getClass()); //参数类型1:java.util.List<T>
            System.out.println("参数类型1: genericType1.getActualTypeArguments()" + ((ParameterizedType)genericType1).getActualTypeArguments()[0].getClass()); //参数类型1:java.util.List<T>
            System.out.println("参数类型1: genericType1.getActualTypeArguments()" + ((ParameterizedType)genericType1).getActualTypeArguments()[0]); //参数类型1:java.util.List<T>
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}


