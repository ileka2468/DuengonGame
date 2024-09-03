package Characters.Monster;

import Characters.CharacterEntity;

public class Monster extends CharacterEntity {
    public String monsterName;
    public Monster(String monsterName, int health, int strength, int craft){
        super(health, strength, craft);
        this.monsterName = monsterName;
    }
}
