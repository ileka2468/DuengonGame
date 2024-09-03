package NonCharacterEntities;
import Characters.Monster.Monster;

public class Door {
    public static void connect(Chamber from, Chamber to){
        from.addDoor(to);
//        to.addDoor(from);
    }
    public static void connect(Chamber from, Chamber to, Monster monster){
        from.addDoor(to, monster);
//        to.addDoor(from, monster);
    }
}
