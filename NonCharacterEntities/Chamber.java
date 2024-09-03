package NonCharacterEntities;

import Characters.Monster.Monster;
import NonCharacterEntities.Items.Item;

import java.util.ArrayList;
import java.util.Collections;

public class Chamber {
    private ArrayList<Item> items;
    private final ArrayList<NonStaticDoor> doors;
    public String chamberName;

    public Chamber (String chamberName, Item... items){
        doors = new ArrayList<>();
        this.items = new ArrayList<>();
        this.chamberName = chamberName;
        Collections.addAll(this.items, items);
    }

    public Chamber (String chamberName){
        doors = new ArrayList<>();
        this.chamberName = chamberName;
    }

    public void addDoor(Chamber nextChamber, Monster monster){
        NonStaticDoor door = new NonStaticDoor(nextChamber, this, monster);
        doors.add(door);
    }

    public void addDoor(Chamber nextChamber){
        NonStaticDoor door = new NonStaticDoor(nextChamber, this);
        doors.add(door);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<NonStaticDoor> getDoors() {
        return doors;
    }
}
