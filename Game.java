import Characters.CharacterEntity;
import Characters.Monster.Monster;
import Characters.PlayerCharacters.CWizzard;
import Characters.PlayerCharacters.PlayerCharacter;
import Characters.PlayerCharacters.PythonSorcerer;
import NonCharacterEntities.Chamber;
import NonCharacterEntities.Door;
import NonCharacterEntities.Dungeon;
import NonCharacterEntities.Items.*;

import java.util.ArrayList;

public class Game {

    public static void main(String[] args) {
        Chamber[] chambers = new Chamber[] {
                new Chamber("Bytecode Bastion", new FlaskOfFastAPI()),
                new Chamber("Recursive Ruins"),
                new Chamber("Array Atrium"),
                new Chamber("Function Falls", new GarbageCollector()),
                new Chamber("Loop Labyrinth"),
                new Chamber("Class Citadel"),
                new Chamber("Variable Vault", new Malloc()),
                new Chamber("Algorithm Abbey"),
                new Chamber("Script Sanctum", new NumPyMatrix()),
                new Chamber("Syntax Shrine"),
                new Chamber("Buffer Boulevard", new ExceptionHandler()),
                new Chamber("Exception Enclave"),
                new Chamber("Library Lair", new SegFault()),
                new Chamber("Framework Fjord")
        };

        Door.connect(chambers[0], chambers[1]);
        Door.connect(chambers[1], chambers[2], new Monster("MemoryLeak", 2, 2,0));
        Door.connect(chambers[2], chambers[3]);
        Door.connect(chambers[3], chambers[4]);
        Door.connect(chambers[4], chambers[5], new Monster("InfiniteLoop", 4, 0,4 ));
        Door.connect(chambers[5], chambers[6]);
        Door.connect(chambers[6], chambers[7]);
        Door.connect(chambers[7], chambers[8], new Monster("Null Pointer", 6, 6, 0));
        Door.connect(chambers[8], chambers[9]);
        Door.connect(chambers[9], chambers[10], new Monster("Missing SemiColon", 8, 0, 7));
        Door.connect(chambers[10], chambers[11]);
        Door.connect(chambers[11], chambers[12]);
        Door.connect(chambers[12], chambers[13], new Monster("Syntax Error", 10, 9, 0));

        PlayerCharacter player = new CWizzard("Dennis M. Ritchie");
        Dungeon d = new Dungeon(player, chambers[0], chambers[13]);

        TextUI ui = new TextUI();
        ui.play(d);

    }




}
