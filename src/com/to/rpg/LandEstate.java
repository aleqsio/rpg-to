package com.to.rpg;

import java.util.ArrayList;
import java.util.List;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public class LandEstate implements IEstate {
    public LandEstate(Human owner, String address, double surface) {
        this.owner = owner;
        this.address = address;
        this.surface = surface;
    }

    private Human owner;
    private final String address;
    private final double surface;


    @Override
    public Human getOwner() {
        return owner;
    }

    @Override
    public void moveOwnership(Human newOwner) {
        owner = newOwner;
    }

    public double getSurface() {
        return surface;
    }

    public String getAddress() {
        return address;
    }

    public List<LandEstate> divideBetween(List<Human> owners){
        List<LandEstate> newEstates = new ArrayList<>();
        owners.forEach(owner -> newEstates.add(new LandEstate(owner,this.address,surface/newEstates.size())));
        return newEstates;
    }
}