import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 *
 */
@Setter
@Getter
public class Monster extends Being {
    private int maxHealth;
    private int attack;
    private int defence;
    private int damage;
    private int health;

    public Monster(MonsterBuilder monsterBuilder) {
        this.maxHealth = monsterBuilder.maxHealth;
        //this.health = monsterBuilder.maxHealth;
        this.attack = monsterBuilder.attack;
        this.defence = monsterBuilder.defence;
        this.damage = monsterBuilder.damage;
        this.health = monsterBuilder.health;
    }


    public int setDefence(int defence) {
        return this.defence = defence;
    }


    public void hit(Being attackedBeing) {
        int maxIntOnCubs = 6;
        int minIntOnCubs = 1;
        int attackMod = (this.getAttack() - attackedBeing.getDefence()) + 1;
        if (attackMod<0){
            attackMod*=-1;
        }
        int cubsAmount = attackMod;
        boolean isSuccess = false;
        for (int i = 0; i < cubsAmount; i++) {
            int randInteger = new Random().nextInt(minIntOnCubs, maxIntOnCubs);//РїРµСЂРІР°СЏ РіСЂР°РЅРёС†Р° РёСЃРєР»СЋС‡Р°РµС‚СЃСЏ?
            if (randInteger >= 5) {
                isSuccess = true;
                break;
            }
        }
        if (isSuccess) {
            int hitDamage = new Random().nextInt(0, this.getDamage());
            int health = attackedBeing.getHealth() - hitDamage;
            attackedBeing.setHealth(health);
        }
    }

    public void death() {
        if (health == 0) {
            System.out.println("Monster's Death!!!");
        }
    }

    public static class MonsterBuilder {
        private int maxHealth;
        private int attack;
        private int defence;
        private int damage;
        private int health;

        public MonsterBuilder setMaxHealth(int maxHealth) {
            this.maxHealth = maxHealth;
            this.health = this.maxHealth;
            return this;
        }

        public MonsterBuilder setAttack(int attack) {
            this.attack = attack;
            return this;
        }

        public MonsterBuilder setDefence(int defence) {
            this.defence = defence;
            return this;
        }

        public MonsterBuilder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        //        public MonsterBuilder setHealth(int health) {
//            this.health = health;
//            return this;
//        }
        public Monster build() {
            return new Monster(this);
        }
    }
}

