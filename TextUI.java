import Characters.Monster.Monster;
import NonCharacterEntities.Action;
import NonCharacterEntities.Chamber;
import NonCharacterEntities.Dungeon;
import NonCharacterEntities.NonStaticDoor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextUI {
    private int count = 0;

    public void play(Dungeon d) {
        while (!d.isFinished() && (d.getPlayer().getHealth() > 0)){
            print(d);
            Action a = ask(d);
            a.execute();
        }
        if (d.getPlayer().getHealth() <= 0){
            System.out.println("You lost.");
        } else {
            System.out.println("You made it!");
        }

    }

    private void print(Dungeon d) {
        Chamber currentRoom = d.getCurrentRoom();
        String s = String.format("You are in the chamber of %s with %d door(s)\n",
                currentRoom.chamberName, currentRoom.getDoors().size());
        String s1 = String.format("There are %d item(s) in the room\n", currentRoom.getItems() != null ? currentRoom.getItems().size() : 0);
        System.out.printf("%s%s", s, s1);

        int doorCount = 1;
        for (NonStaticDoor door : currentRoom.getDoors()) {
            System.out.printf("Door number %d: ", doorCount);
            if (door.getMonster() != null) {
                Monster monster = door.getMonster();
                System.out.printf("is guarded by a %s that has %d strength, %d craft, and %d health.\n", monster.monsterName, monster.getStrength(), monster.getCraft(), monster.getHealth());
            } else {
                System.out.println("is unguarded.");
            }
            doorCount++;
        }
    }

    private Action ask(Dungeon d) {
        StringBuilder s = new StringBuilder();
        s.append("Here are your options:\n");
        ArrayList<Action> actions = d.getActions();
        for (int i = 0; i < actions.size(); i++) {
            Action a = actions.get(i);
            s.append("\t" + i + ": " + a.toString() + "\n");
        }
        System.out.println(s + "\n");

        // ask for action
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int command = Integer.parseInt(reader.readLine());
            return actions.get(command);
        } catch (IOException e) {
            throw new RuntimeException("Printer Error");
        }
    }
}


