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

    public TownEstate(Human owner, String address){
        this.address = address;
        this.owner = owner;
    }

    @Override
    public Human getOwner() {
        return owner;
    }

    @Override
    public void moveOwnership(Human newOwner) {
        owner = newOwner;
    }

    @Override
    public void setOwner(Human owner) {
        this.owner=owner;
    }

    public String toString(){
        return "TownEstate owned by "+getOwner()+"\n";
    }
}
