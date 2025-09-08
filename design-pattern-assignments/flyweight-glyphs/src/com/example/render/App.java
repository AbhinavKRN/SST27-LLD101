package com.example.render;
public class App {
    public static void main(String[] args) {
        Renderer r = new Renderer();
        String text = "Hello Flyweight! ".repeat(2000);
        System.out.println("Cost=" + r.render(text));
        System.out.println("Unique styles cached: " + r.getStyleCacheSize());
        System.out.println("Text length: " + text.length());
    }
}
