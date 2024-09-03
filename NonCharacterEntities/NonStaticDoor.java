package NonCharacterEntities;

import Characters.Monster.Monster;

public class NonStaticDoor {
    private  final Chamber next;
    private final Chamber current;
    private Monster monster;

    NonStaticDoor(Chamber next, Chamber current){
        this.next = next;
        this.current = current;
    }

    NonStaticDoor(Chamber next, Chamber current, Monster monster){
        this.next = next;
        this.current = current;
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Chamber getNext() {
        return next;
    }

    public Chamber getCurrent() {
        return current;
    }
}
