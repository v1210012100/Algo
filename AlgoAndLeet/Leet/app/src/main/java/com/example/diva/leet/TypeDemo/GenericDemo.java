package com.example.diva.leet.TypeDemo;

import java.lang.reflect.Field;
import java.util.HashMap;

/***
 * 泛型参数可以在三种 位置声明： 类或则接口、 Method、 构造方法
 * @param <T>
 */
public class GenericDemo<T extends Number> {
    private CharSequence name;
    // Class 上声明的 泛型参数 T  。
    public T t;   //t是 TypeVariable 类型

    public HashMap<CharSequence, T> hashMap = new HashMap<>();  //  hashMap 是 ParameterizedType 类型

    public HashMap rawHashMap = new HashMap<>();  // rawHashMap 是 原生类型，所以是 class 类型。

    public T[] tArray;   // tArray 是 GenericArrayType

    public HashMap<? extends CharSequence, T> wildHashMap = new HashMap<>();  // wildHashMap 是 WildcardType

    // 构造方法处声明的泛型参数 E
    public <E extends CharSequence> GenericDemo(E e) {
        name = e;
    }

    // 非静态方法上声明的 泛型参数 K
    public <K extends T> void setT(K k) {
        t = k;
    }

    // 静态方法上声明的泛型参数 K  ,和上面非静态方法的 K 不是同一种类型，不冲突
    public static <K> void staticMethod(K k) {
        System.out.println("  test " + k.getClass());
    }



    public static void main(String args[]) {
        try {
//            Field field = GenericDemo.class.getField("t");
//            TypeVariable typeVariable = (TypeVariable) field.getGenericType();
//            System.out.println("typeVariable toString" + typeVariable);
//            System.out.println("typeVariable  的泛型边界" + Arrays.asList(typeVariable.getBounds()));
//            System.out.println("TypeVariable  的声明方式" + typeVariable.getGenericDeclaration());


//            Field field = GenericDemo.class.getField("hashMap");
//            ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
//            System.out.println("parameterizedType toString " + parameterizedType);
//            System.out.println("parameterizedType  的参数信息 " + Arrays.asList(parameterizedType.getActualTypeArguments()));
//            System.out.println("parameterizedType  的原生类型 " + parameterizedType.getRawType());
//            System.out.println("hashMap<CharSequence,T>  的第二个参数类型 " + parameterizedType.getActualTypeArguments()[1].getClass());

            // public HashMap<? extends CharSequence, T> wildHashMap = new HashMap<>();
//            Field field = GenericDemo.class.getField("wildHashMap");
//            ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
//            WildcardType wildcardType = (WildcardType) parameterizedType.getActualTypeArguments()[0];
//            System.out.println("wildcardType toString " + wildcardType);
//            System.out.println("wildcardType 的上界是 " + Arrays.asList(wildcardType.getUpperBounds()));
//            System.out.println("wildcardType 的下界是 " + Arrays.asList(wildcardType.getLowerBounds()));

//            Field field = GenericDemo.class.getField("tArray");
//            Type type =  field.getGenericType();
//            System.out.println("T[] 的类型是 " +type.getClass());
//            System.out.println(" T[]  getGenericComponentType() 的类型是 " + ((GenericArrayType) type).getGenericComponentType().getClass());


            // 以 HashMap rawHashMap  和 HashMap<CharSequence, T> hashMap  为对比
            Field rawHashMap = GenericDemo.class.getField("rawHashMap");
            Field hashMap = GenericDemo.class.getField("hashMap");
            System.out.println(" HashMap rawHashMap 的类型是       "+rawHashMap.getGenericType().getClass());
            System.out.println(" HashMap<CharSequence, T> hashMap  的类型是 " +hashMap.getGenericType().getClass());

        } catch (Exception e) {

        }
    }
}
