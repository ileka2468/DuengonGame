package NonCharacterEntities;

import Characters.Monster.Monster;
import Characters.PlayerCharacters.PlayerCharacter;
import NonCharacterEntities.Items.Item;

import java.util.Arrays;
import java.util.Random;

public class Fight extends Action {
    public Fight(String action, int door, Dungeon d){
        super(action, door, d);
    }

    public void execute(){
        Monster monster = d.getCurrentRoom().getDoors().get(this.door).getMonster();
        PlayerCharacter player = d.getPlayer();
        fight(monster, player);
    }

    private void fight(Monster monster, PlayerCharacter player){
        String type = monster.getCraft() == 0 ? "strength" : "craft";
        int playerFightPoints;
        int monsterFightPoints;
        int playerDiceRoll;
        int monsterDiceRoll;
        Random random = new Random();

        if ("strength".equals(type)) {
            System.out.println("This is a strength fight");
            monsterFightPoints = monster.getStrength();
            playerFightPoints = player.getStrength() + player.getInventory().stream().mapToInt(Item::getStrength).sum();
            playerDiceRoll = random.nextInt(6) + 1;
            monsterDiceRoll = random.nextInt(6) + 1;
        } else {
            System.out.println("This is a craft fight");
            monsterFightPoints = monster.getCraft();
            playerFightPoints = player.getCraft() + player.getInventory().stream().mapToInt(Item::getCraft).sum();
            playerDiceRoll = random.nextInt(6) + 1;
            monsterDiceRoll = random.nextInt(6) + 1;
        }

        System.out.println("Player's fight points: " + playerFightPoints);
        System.out.println("Monster's fight points: " + monsterFightPoints);
        System.out.println("Player's dice roll: " + playerDiceRoll);
        System.out.println("Monster's dice roll: " + monsterDiceRoll);

        playerFightPoints += playerDiceRoll;
        monsterFightPoints += monsterDiceRoll;

        if (playerFightPoints > monsterFightPoints) {
            int difference = playerFightPoints - monsterFightPoints;
            monster.removeHealth(difference);
            System.out.println("Monster loses " + difference + " health");
        } else if (monsterFightPoints > playerFightPoints) {
            int difference = monsterFightPoints - playerFightPoints;
            player.removeHealth(difference);
            System.out.println("Player loses " + difference + " health");
        } else {
            System.out.println("The fight is a tie, no one loses health.");
        }

        if (monster.getHealth() <= 0) {
            d.getCurrentRoom().getDoors().get(this.door).setMonster(null);
            System.out.println("The " + monster.monsterName + " was slain at door " + this.door);
        }
    }


}
