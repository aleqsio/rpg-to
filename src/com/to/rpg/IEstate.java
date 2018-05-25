package com.to.rpg;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public interface IEstate {
    Human getOwner();
    void moveOwnership(Human newOwner);
}
