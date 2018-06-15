package com.to.rpg;

import com.to.rpg.people.Human;
import com.to.rpg.people.King;
import com.to.rpg.properties.IEstate;

import java.util.List;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 *
 * Class Kingdom plays the role of an estate manager
 */
public class Kingdom {
    private List<IEstate> estates;
    private King king;

    public Kingdom(King king, List<IEstate> estates){
        this.estates = estates;
        this.king = king;
    }

    public void moveEstates(Human to, Human from) {
        for (IEstate estate:estates
             ) {
            if(estate.getOwner()==from)
                estate.setOwner(to);
        }
    }

    public List<IEstate> getEstates() {
        return estates;
    }
}
