package Characters;

import NonCharacterEntities.Items.Item;

import java.util.ArrayList;

public abstract class CharacterEntity {
    private int health;
    private int strength;
    private int craft;

    public CharacterEntity (int health, int strength, int craft){
        this.health = health;
        this.strength = strength;
        this.craft = craft;
    }

    public int getCraft() {
        return craft;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void addHealth(int health){
        this.health += health;
    }

    public void removeHealth(int health){
        this.health -= health;
    }

    public void addStrength(int strength){
        this.strength += strength;
    }

    public void removeStrength(int strength){
        this.strength -= strength;
    }

    public void addCraft(int craft){
        this.craft += craft;
    }

    public void removeCraft(int craft){
        this.craft -= craft;
    }
}