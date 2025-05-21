import java.util.Random;

public class PlayerCharacter {
    String name;
    int hp;
    int attack;
    int defense;

public PlayerCharacter(String name, int hp, int attack, int defense){
    this.name=name;
    this.hp=hp;
    this.attack=attack;
    this.defense=defense;
}
    public int getInitiative() {
        return new Random().nextInt(20) + 1;
    }
public void takeDamage(int enemyAttack){
    int baseDamage=Math.max(1,enemyAttack-this.defense);


    //WARRIOR PASSIVE ABILITY
    if (name.equals("Warrior")){
        baseDamage=(int)(baseDamage*0.75);
        System.out.println("The Warrior used Shield Block! Damage reduced by 25%");
    }
    this.hp-=baseDamage;
    System.out.println(name+" takes "+baseDamage+"damage!(HP left: "+hp+ ")");
}
public boolean isAlive(){
    return this.hp>0;
}
public void showStats(){
    System.out.println(name + " - HP: " + hp + " | ATK: " + attack + " | DEF: " + defense);
}
}