package com.to.rpg;

import com.to.rpg.people.*;
import com.to.rpg.properties.IEstate;
import com.to.rpg.properties.LandEstate;
import com.to.rpg.properties.TownEstate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Lancelot", "Gawain", "Geraint", "Percival", "Bors the Younger", "Lamorak", "Kay", "Gareth", "Bedivere", "Gaheris"};
        King king = new King(20, "King Arthur");
        List<Knight> constituents = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            constituents.add(new Knight(new Random().nextInt(20), names[new Random().nextInt(names.length)]));
        }
        for (int i = 0; i < 20; i++) {
            Knight leader = constituents.get(i);
            for (int j = 0; j < 20; j++) {
                if(new Random().nextInt(5)>0){
                    continue;
                }
                Knight sub = constituents.get(j);
                try {
                    leader.addSubordinate(sub);
                } catch (MultipleSeniorException | TooManySubordinatesException ignored) {
                }
            }
        }
        List<IEstate> estateList = new ArrayList<>();
        for (Knight knight:constituents
             ) {
            estateList.add(new LandEstate(knight,"adress of land estate",new Random().nextDouble()));
            estateList.add(new TownEstate(knight,"adress of town estate"));
            if(!knight.getSenior().isPresent()){
                try {
                    king.addSubordinate(knight);
                } catch (MultipleSeniorException | TooManySubordinatesException ignored) {
                }
            }
        }

       Kingdom kingdom = new Kingdom(king,estateList);
        System.out.println(estateList);
        System.out.println("--------------");
        War.WarResult sampleWar = constituents.get(0).declareWar(constituents.get(1),kingdom);
        System.out.println(sampleWar);
        System.out.println(kingdom.getEstates());
    }
}
