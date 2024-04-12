package ru.inno.edu.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

class Stack<T>{
    Object[] vals=new Object[10];
    private int cur=0;

    public void push(T t){
        if(cur==vals.length){
            vals= Arrays.copyOf(vals, (int)(vals.length*1.5));
        }
        vals[cur++]=t;
        System.out.println("push cur = " + cur);
    }
    public T pop(){
        cur--;
        if(cur<0) throw new NoSuchElementException();
        T tmp=(T)vals[cur];
        vals[cur]=null;
        return tmp;
    }
}

