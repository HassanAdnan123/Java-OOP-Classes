import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Alien f = new Alien();
        Human h = new Human("Joe");
        Creature a = new Alien();
        Creature e = new Animal();  // Upcasting
        differentcreatures p = new Human();

        // Aliens Class
        f.eat();
        f.walk();

        // Multiple Inheritance
        h.differentiability();
        h.eat();
        h.walk();

        // Creature upcasted with Alien child class
        a.eat();
        a.walk();

        // Creature upcasted with Animal child class
        e.eat();
        e.walk();

        // Interface object
        p.differentiability();

    }
}

//Abstraction part (a) : 0-100% abs
abstract class Creature {
    int legs = 0;

    Creature(int noOfLegs){         // Polymorphism -> Overloading (Compile-time Polymorphism)
        this.legs = noOfLegs;
    }

    Creature(){

    }

    abstract void eat();    // Abstract method / method without a body

    void walk(){
        System.out.println(String.format("Creatures can walk by %d legs",legs));
    }
}

// Abstraction: part (b) -> 100% abs
interface differentcreatures {
    void differentiability();
    void setName(String name);
    String getName();
}

class Alien extends Creature {

    String name;

    Alien(int noOfLegs){
        super(noOfLegs);
    }

    Alien(){

    }

    void eat(){         // Polymorphism: Overriding (Runtime Polymorphism)
        System.out.println("Aliens eat humans.");
    }
}

class Animal extends Creature{

    Animal(int noOfLegs){
        super(noOfLegs);
    }

    Animal(){

    }

    void eat(){
        System.out.println("Animals eat various foods.");
    }
}

class Human extends Creature implements differentcreatures{

    String name;

    void eat(){
        System.out.println("Humans eat food.");
    }

    public void differentiability(){
        System.out.println("Because Humans have intelligent brains.");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    Human(String name){
        this.name = name;
    }

    Human(){

    }



}
