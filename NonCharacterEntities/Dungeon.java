package NonCharacterEntities;

import Characters.PlayerCharacters.PlayerCharacter;
import NonCharacterEntities.Items.Item;

import java.util.ArrayList;

public class Dungeon {
    private final PlayerCharacter player;
    private final Chamber entryChamber;
    private final Chamber goalChamber;
    private Chamber currentChamber;
    public Dungeon(PlayerCharacter player, Chamber entryChamber, Chamber goalChamber){
        this.player = player;
        this.entryChamber = entryChamber;
        currentChamber = entryChamber;
        this.goalChamber = goalChamber;
    }

    public boolean isFinished(){
        return currentChamber == goalChamber;
    }
    public void proceed(int doorToGoTo){
        currentChamber = currentChamber.getDoors().get(doorToGoTo).getNext();
    }

    public Chamber getCurrentRoom(){
        return currentChamber;
    }

    public ArrayList<Action> getActions(){
        ArrayList<Action> actionsArray = new ArrayList<>();
        boolean noMonsters = true;
        int count = 0;
        for (NonStaticDoor door : currentChamber.getDoors()){
            if (door.getMonster() != null){
                noMonsters = false;
                actionsArray.add(new Fight(String.format("Fight the %s monster.", door.getMonster().monsterName), count, this));
            }
        }
        int count2 = 0;
        for (NonStaticDoor door : currentChamber.getDoors()){
            if (noMonsters){
                actionsArray.add(new Move("Move to door " + count2 + 1, count2, this));
            }
        }
        if (currentChamber.getItems() != null){
            if (!currentChamber.getItems().isEmpty()){
                for (Item i : currentChamber.getItems()){
                    boolean alreadyHasItem = false;
                    for (Item playerItem : player.getInventory()) {
                        if (playerItem.getItemName().equals(i.getItemName())) {
                            alreadyHasItem = true;
                            break;
                        }
                    }
                    if (!alreadyHasItem) { // Only if the player doesn't already have the item
                        actionsArray.add(new Pick("Pickup the " + i.getItemName(), 0, this));
                    }
                }
            }
        }

        return actionsArray;
    }

    public PlayerCharacter getPlayer() {
        return player;
    }
}
