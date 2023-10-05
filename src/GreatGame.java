

public class GreatGame {

    public static void main(String[] args) throws InterruptedException {

        Gamer gamer = new Gamer.GamerBuilder().setMaxHealth(20).setAttack(2).setDefence(9)
                .setDamage(2).setHealingEvent(4).build();
        Monster monster = new Monster.MonsterBuilder().setMaxHealth(50).setAttack(1).setDamage(2)
                .setDefence(5).build();

        while (gamer.getHealth() > 0 && monster.getHealth() > 0) {
            gamer.hit(monster);
            System.out.println("Gamer hitting monster");

            Thread.sleep(500);

            monster.hit(gamer);
            System.out.println("Monster hitting gamer");

            System.out.println("Здоровье игрока: " + gamer.getHealth());
            System.out.println("Здоровье монстра: " + monster.getHealth());

            if (gamer.getHealth() < 0.3 * gamer.getMaxHealth()&&gamer.getHealingEvent()!=0) {
                gamer.healing();
                System.out.println("Игрок излечился: " + gamer.getHealth());
            }
            if (gamer.getHealth() <= 0) {
                gamer.death();
                break;
            }
            if (monster.getHealth() <= 0) {
                monster.death();
                break;
            }
        }
    }
}

