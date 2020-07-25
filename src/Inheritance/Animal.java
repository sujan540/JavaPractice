package Inheritance;

/**
 * Created by sujan on 6/13/16.
 */
public class Animal implements EarthSpecies, Food {

    @Override
    public void types(){
        System.out.println("Animal call");
    }

    public void eat(){
        System.out.println("Animal eat food");
    }


    public static void main(String[] args) {
        Animal animal = new Animal();
    }
}
