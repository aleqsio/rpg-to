package com.to.rpg.properties;

import com.to.rpg.people.Human;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public interface IEstate {
    Human getOwner();
    void moveOwnership(Human newOwner);

}
