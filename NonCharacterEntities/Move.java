package NonCharacterEntities;

public class Move extends Action {
    public Move(String action, int door, Dungeon d){
        super(action, door, d);
    }

    public void execute(){
        d.proceed(this.door);
        System.out.println("\nYou moved through door " + this.door);
    }
}
