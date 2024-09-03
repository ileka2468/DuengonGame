package NonCharacterEntities.Items;

public abstract class Item {
    private final String itemName;
    private final String description;
    private final int strength;
    private final int craft;

    public Item(String name, String description, int strength, int craft){
        this.itemName = name;
        this.description = description;
        this.strength = strength;
        this.craft = craft;
    }

    public String getItemName() {
        return itemName;
    }

    public int getStrength() {
        return strength;
    }

    public int getCraft() {
        return craft;
    }

    @Override
    public String toString() {
        return String.format("\n%s: %s\n", itemName, description);
    }
}
