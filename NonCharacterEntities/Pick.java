package NonCharacterEntities;

import NonCharacterEntities.Items.Item;

public class Pick extends Action {
    public Pick(String action, int door, Dungeon d){
        super(action, door, d);
    }

    public void execute(){
        Item item = this.d.getCurrentRoom().getItems().get(door);
        if (d.getPlayer().getInventory().size() < 2){
            d.getPlayer().pickupItem(item);
            System.out.println("You picked up a " + item.getItemName() + ". " + item);
        } else {
            System.out.println("Your inventory is full.");
        }


    }
}
