package Inheritance;

public interface EarthSpecies {
    default void types(){
        System.out.println("EarthSpecies call");
    }
}
