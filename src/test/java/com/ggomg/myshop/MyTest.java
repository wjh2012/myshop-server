package com.ggomg.myshop;

public class MyTest {

    Parent parent = new Child();
    parent.play();

}


class Parent{

}

class Child extends Parent{
    private String word;

    public void play(){
        System.out.println("pass me the ball!");
    }
}