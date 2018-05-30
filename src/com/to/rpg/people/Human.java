package com.to.rpg.people;

import com.to.rpg.properties.IEstate;
import com.to.rpg.War;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * github.com/aleqsio
 * Created by Aleksander Mikucki (@aleqsio) on 25.05.2018.
 */
public class Human {
    private double stat;
    private String name;
    private Human senior;
    private List<IEstate> goods;
    protected List<Knight> subordinates;


    public Human(double stat, String name) {
        this.stat = stat;
        this.name = name;
        this.goods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Human> getSubordinates(){
        return Collections.emptyList();
    }

    public Optional<Human> getSenior(){
        if(senior == null)
            return Optional.empty();
        else
            return Optional.of(senior);
    }

    public void giveGood(IEstate good){
        good.moveOwnership(this);
        goods.add(good);
    }

    public double getStat() {
        return stat;
    }

    public static double getCombinedStat(List<Human> group){
        return group.stream().map(Human::getStat).reduce(Double::sum).orElse(0d);
    }

    public void transferGoods(Human other){
        goods.forEach(other::giveGood);
    }

    public War.WarResult declareWar(Human other){
        return new War(this, other).wage();
    }

    protected void addSubordinate(Knight subordinate) throws MultipleSeniorException, TooManySubordinatesException {
        if(subordinate.getSenior().isPresent()) throw new MultipleSeniorException();
        if(subordinates.size() >= 7) throw new TooManySubordinatesException();
        subordinate.setSenior(this);
        subordinates.add(subordinate);
    }

    protected void setSenior(Human senior){
        this.senior = senior;
    }
}
