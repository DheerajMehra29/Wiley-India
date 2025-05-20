package Generics;

import java.util.ArrayList;

class RegularClass {
    int member;

    RegularClass(int member) {
        this.member = member;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }
}

class RegularChildClass extends RegularClass {
    RegularChildClass() {
        super(100);
    }
}

class GenericClass<T> {
    T member;

    GenericClass(T member) {
        this.member = member;
    }

    public T getMember() {
        return member;
    }

    public void setMember(T member) {
        this.member = member;
    }

    void displayType() {
        System.out.println(member.getClass().getName());
    }

    void printAll(Arraylist<? super T> arr) {
        System.out.println("I work with arraylists");
    }
}

public class Generic {
    public static void main(String[] args) {
        RegularClass regular = new RegularClass(5);
        RegularChildClass child = new RegularChildClass();

        GenericClass<Integer> generic = new GenericClass<>(5);
        generic.displayType();

        GenericClass<RegularChildClass> generic2 = new GenericClass<>(child);
        generic2.displayType();
    }
}
