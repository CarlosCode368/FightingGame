import java.util.Scanner;

public class MainMenu {
        static Scanner scanner = new Scanner(System.in);
        static PlayerCharacter selectedHero=null;

    public static void main(String[] args) {
        boolean Isrunning = true;

        while (Isrunning) {
            System.out.println("""
                       ******BLOOD QUEST******
                    
                        1. Choose Hero
                    
                        2. Enter Dungeon
                    
                        3. Hall of Treasures
                    
                        x. Exit Game
                    """);
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "1" -> chooseHero();
                case "2" -> {
                    if (selectedHero == null) {
                        System.out.println("You must choose a hero first!");
                    } else {
                       Dungeon dungeon=new Dungeon(selectedHero);
                       dungeon.enter();
                    }
                }
                case "3" -> System.out.println("hall of treasures coming soon");
                case "x" -> {
                    System.out.println("The adventure will continue...");
                    Isrunning = false;
                }

                default -> System.out.println("Invalid input. Please try again.");
            }
        }
        scanner.close();
    }

    static void chooseHero() {
        System.out.println("""
                1.Warrior - A tough armored veteran of many battles
                            (HP:100,ATK:15,DEF:5) 
                """);
        System.out.println("Select your hero: ");
        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) {
            selectedHero = new PlayerCharacter("Warrior", 100, 15, 8);
            System.out.println("You have chosen the Warrior!");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

