package rtu.klokov.practics.prac14;

import java.util.ArrayList;
import java.util.Collections;

public class Shirt {
    String num;
    String name;
    String color;
    String size;

    public Shirt(String info){
        ArrayList<String> infoList = new ArrayList<>();
        Collections.addAll(infoList, info.split(","));
        num = infoList.get(0);
        name = infoList.get(1);
        color= infoList.get(2);
        size= infoList.get(3);
    }

    public String toString(){
        return "Номер: "+ num +" Название: "+ name +" Цвет: "+color+" Размер: "+size;
    }
}
