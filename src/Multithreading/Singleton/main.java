package Multithreading.Singleton;

import Multithreading.Singleton.EnumSingleTon;

/**
 * Created by sujan on 6/13/16.
 */
public class main {
    public static void main(String[] args){
        EnumSingleTon.INSTANCE.show();
        StaticSingleTon.getInstance().show();
    }
}
