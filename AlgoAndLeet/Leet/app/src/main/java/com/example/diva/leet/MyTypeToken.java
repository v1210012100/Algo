package com.example.diva.leet;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class MyTypeToken<T> {
    private final Type type;
    public MyTypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if(genericSuperclass instanceof Class){
            throw new RuntimeException("Missing type parameter.");
        }

        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        System.out.println("  parameterizedType 的类型是  " +parameterizedType.getClass());
        System.out.println("  parameterizedType owner type   " +parameterizedType.getOwnerType());
        Type[] typeArguments = parameterizedType.getActualTypeArguments();
        type = typeArguments[0];
    }

    public Type getType() {
        return type;
    }


    public static  class TokenUtil{
        public static <E> Type getType(){
            return new MyTypeToken<E>() {}.getType();
        }
    }
    // 本意在于获取Response<String>的类型, 但是new MyTypeToken<E>() {}时已经实现了
// 抽象类, 相当于创建一个子类 class MyTypeToken$0<E> extends MyTypeToken<E>{},
// 实例化时虽然传入的是Response<String>, 但.getGenericSuperclass()=MyTypeToken$0<E>
// 于是getType()返回的只是泛型参数类型E, 正真解析是按照Gson流程选择Map或者List


    public static void main(String args[]){
        MyTypeToken<String> sToken = new MyTypeToken<String>(){};

        Type type = TokenUtil.<List<String>>getType();
        // fromJson返回Map或者List, ClassCastException!
//        List<String> o = new Gson().fromJson(json, type);
        System.out.println("   type 的类型是 " + type.getClass());
        System.out.println("   type 的类型是 " + new MyTypeToken<List<String>>(){}.getType());
    }
}