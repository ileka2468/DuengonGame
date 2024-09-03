import NonCharacterEntities.Dungeon;

public class PrintError extends Exception{
    PrintError(Dungeon d, Exception e){
        super("wrong");
        System.out.println();
    }
}
