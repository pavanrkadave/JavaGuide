package oop.generics;

public class Box<S> {
    S content;

    public Box(S content) {
        this.content = content;
    }

    public S getContent() {
        return content;
    }
}
