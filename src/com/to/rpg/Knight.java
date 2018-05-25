package com.to.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public class Knight extends Human {
    public Knight(double stat, String name) {
        super(stat, name);
    }

    public List<Knight> getLieges() {
        return lieges;
    }

    public void setLieges(List<Knight> lieges) {
        this.lieges = lieges;
    }

    private List<Knight> lieges;

    @Override
    public List<Human> getSubordinates(){
        List<Human> list = new ArrayList<>();
        list.add(this);
        lieges.forEach(knight -> list.addAll(knight.getSubordinates()));
        return list;
    }
}
