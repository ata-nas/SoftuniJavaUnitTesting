package rpg_lab;

public class Axe implements Weapon {

    private int attackPoints;
    private int durabilityPoints;
    private int durabilityReductionFactor;

    public Axe(int attackPoints, int durabilityPoints) {
        this(attackPoints, durabilityPoints, 1);
    }

    public Axe(int attackPoints, int durabilityPoints, int durabilityReductionFactor) {
        this.attackPoints = attackPoints;
        this.durabilityPoints = durabilityPoints;
        this.durabilityReductionFactor = durabilityReductionFactor;
    }

    @Override
    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public int getDurabilityPoints() {
        return durabilityPoints;
    }

    @Override
    public int getDurabilityReductionFactor() {
        return durabilityReductionFactor;
    }

    @Override
    public void attack(Target target) {
        if (durabilityPoints <= 0) {
            throw new IllegalStateException("Axe is broken.");
        }

        target.takeAttack(getAttackPoints());
        durabilityPoints -= durabilityReductionFactor;
    }
}
