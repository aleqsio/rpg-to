package com.to.rpg.properties;

import com.to.rpg.people.Human;
import com.to.rpg.properties.IEstate;

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
        double dividedSurface = surface / owners.size();
        owners.forEach(owner -> newEstates.add(new LandEstate(owner, this.address, dividedSurface)));
        return newEstates;
    }
    public String toString(){
        return "LandEstate owned by "+getOwner()+" with surface "+surface+"\n";
    }

    @Override
    public void setOwner(Human owner) {
        this.owner=owner;
    }
}