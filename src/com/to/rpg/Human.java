package com.to.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public class Human {
    private double stat;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Human(double stat, String name) {
        this.stat = stat;
        this.name = name;
    }

    public List<Human> getSubordinates(){
        List<Human> list = new ArrayList<>();
        list.add(this);
        return list;
    }

    public double getStat() {
        return stat;
    }
    public static double getCombinedStat(List<Human> group){
        return group.stream().map(Human::getStat).reduce(Double::sum).orElse(0d);
    }
}
