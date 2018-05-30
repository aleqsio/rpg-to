package com.to.rpg.properties;

import com.to.rpg.people.Human;
import com.to.rpg.properties.IEstate;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public class TownEstate implements IEstate {
    private Human owner;
    private String address;

    @Override
    public Human getOwner() {
        return owner;
    }

    @Override
    public void moveOwnership(Human newOwner) {
        owner = newOwner;
    }
}
