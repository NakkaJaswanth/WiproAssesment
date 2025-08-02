package javawipro;

abstract class Person {
 
 public abstract void eat();
 public abstract void exercise();
}


class Athlete extends Person {
 @Override
 public void eat() {
     System.out.println("Athlete eats a balanced diet with proteins, carbs, and vegetables.");
 }

 @Override
 public void exercise() {
     System.out.println("Athlete exercises rigorously with intense workouts and training sessions.");
 }
}

class LazyPerson extends Person {
 @Override
 public void eat() {
     System.out.println("Lazy person eats junk food like pizza, burgers, and chips.");
 }

 @Override
 public void exercise() {
     System.out.println("Lazy person avoids exercise and prefers lounging on the couch.");
 }
}

public class persons {
 public static void main(String[] args) {
     
     Person athlete = new Athlete();
     Person lazyPerson = new LazyPerson();
     System.out.println("Athlete:");
     athlete.eat();
     athlete.exercise();
     System.out.println("\nLazy Person:");
     lazyPerson.eat();
     lazyPerson.exercise();
 }
}
