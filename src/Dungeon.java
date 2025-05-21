public class Dungeon {
    PlayerCharacter hero;

    public Dungeon(PlayerCharacter hero) {
        this.hero = hero;
    }

    public void enter() {
        System.out.println("You entered the dungeon as a " + hero.name + "...");
        Enemy zombie = new Enemy("Zombie", 30, 20);

        int heroInit = hero.getInitiative();
        int enemyInit = zombie.getInitiative();

        System.out.println(hero.name + " rolls initiative: " + heroInit);
        System.out.println(zombie.name + " rolls initiative: " + enemyInit);

        boolean playerFirst = heroInit >= enemyInit;

        while (hero.isAlive() && zombie.isAlive()) {
            System.out.println("***BATTLE!!***");
            System.out.println(zombie.name + " HP: " + zombie.hp);
            System.out.println(hero.name + " HP: " + hero.hp);

            //PLAYER ATTACK
            if (playerFirst) {
                System.out.println(hero.name + " attacks!");
                zombie.hp -= hero.attack;
                System.out.println(zombie.name+" takes " + hero.attack + "damage!");

                if (zombie.isAlive()) {
                    zombie.attackPlayer(hero);
                }
            } else {
                zombie.attackPlayer(hero);

                if (hero.isAlive()) {
                    System.out.println(hero.name + " attacks!");
                    zombie.hp -= hero.attack;
                    System.out.println(zombie.name + " takes " + hero.attack + " damage!");
                }
            }
        }

        if (hero.isAlive()) {
            System.out.println("Victory! You defeated the " + zombie.name);
        } else {
            System.out.println("Defeat! " + hero.name + " has fallen!");
        }
    }
}

