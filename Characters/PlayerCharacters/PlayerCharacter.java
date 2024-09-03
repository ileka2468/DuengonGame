package Characters.PlayerCharacters;

import Characters.CharacterEntity;
import NonCharacterEntities.Items.Item;

import java.util.ArrayList;

public class PlayerCharacter extends CharacterEntity {
    public final String playerName;
    private ArrayList<Item> inventory;
    public PlayerCharacter(int health, int strength, int craft, String CharacterName){
        super(health, strength, craft);
        this.playerName = CharacterName;
        this.inventory = new ArrayList<>();
    }

    public void pickupItem(Item i){
        inventory.add(i);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
}
