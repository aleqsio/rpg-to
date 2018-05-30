package com.to.rpg.people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public class Knight extends Human {

    public Knight(double stat, String name) {
        super(stat, name);
        super.subordinates = new ArrayList<>();
    }

    public void addLiege(Knight subordinate) throws MultipleSeniorException, TooManySubordinatesException {
        super.addSubordinate(subordinate);
    }

    @Override
    public List<Human> getSubordinates(){
        return Collections.unmodifiableList(super.subordinates);
    }
}
