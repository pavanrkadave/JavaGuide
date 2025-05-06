package oop.generics;

public class Rack<T, U> {

    T item;
    U quantity;

    public Rack(T item, U quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public U getQuantity() {
        return quantity;
    }

    public void setQuantity(U quantity) {
        this.quantity = quantity;
    }
}
