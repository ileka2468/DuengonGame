package NonCharacterEntities;

public abstract class Action {
    public String actionName;
    public int door;
    public Dungeon d;
    public Action(String actionName, int door, Dungeon d){
        this.actionName = actionName;
        this.door = door;
        this.d = d;
    }
    abstract public void execute();

    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return actionName;
    }
}
