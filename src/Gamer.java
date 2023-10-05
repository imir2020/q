import java.util.Random;


import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Gamer extends Being {
    private int maxHealth;
    private int attack;
    private int defence;
    private int damage;
    private int healingEvent;
    private int health;

    public Gamer(GamerBuilder gamerBuilder) {
        this.maxHealth = gamerBuilder.maxHealth;
        this.health = gamerBuilder.maxHealth;
        this.attack = gamerBuilder.attack;
        this.defence = gamerBuilder.defence;
        this.damage = gamerBuilder.damage;
        this.healingEvent = gamerBuilder.healingEvent;

    }



    public int healing() {
        int tempHealth = (int) (health + maxHealth * 0.3);
        boolean isNotMoreMax = tempHealth <= maxHealth;
        if (healingEvent > 0) {
            health = isNotMoreMax ? tempHealth : maxHealth;
            healingEvent--;
            return health;
        }
        return health;
    }

    public void hit(Being attackedBeing) {
        int maxIntOnCubs = 6;
        int minIntOnCubs = 1;
        int forSuccessHit = 5;
        int attackMod = (this.getAttack() - attackedBeing.getDefence()) + 1;
        if (attackMod < 0) {
            attackMod *= -1;
        }
        int cubsAmount = attackMod;
        boolean isSuccess = false;
        for (int i = 0; i < cubsAmount; i++) {
            int randInteger = new Random().nextInt(minIntOnCubs, maxIntOnCubs);
            if (randInteger >= forSuccessHit) {
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
            System.out.println("Gamer's Death!!!");
        }
    }

    public static class GamerBuilder {
        int maxHealth;
        private int attack;
        private int defence;
        private int damage;
        private int healingEvent;
        private int health;


        public GamerBuilder setMaxHealth(int maxHealth) {
            this.maxHealth = maxHealth;
            this.health = this.maxHealth;
            return this;
        }

        public GamerBuilder setAttack(int attack) {
            this.attack = attack;
            return this;

        }

        public GamerBuilder setDefence(int defence) {
            this.defence = defence;
            return this;
        }

        public GamerBuilder setDamage(int damage) {
            this.damage = damage;
            return this;
        }

        public GamerBuilder setHealingEvent(int healingEvent) {
            this.healingEvent = healingEvent;
            return this;
        }

        public Gamer build() {
            return new Gamer(this);
        }
    }


}
