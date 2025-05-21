import java.util.Random;

public class Enemy {
    String name;
    int hp;
    int attack;

    public Enemy(String name,int hp, int attack){
        this.name=name;
        this.hp=hp;
        this.attack=attack;
    }
    public void attackPlayer(PlayerCharacter player){
        System.out.println(name+" attacks for "+attack+ "!");
        player.takeDamage(attack);
    }
    public boolean isAlive(){
        return hp>0;
    }

    public int getInitiative(){
        return new Random().nextInt(20)+1;
    }

}
