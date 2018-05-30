package com.to.rpg;

import com.to.rpg.people.Human;

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
