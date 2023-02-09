package rpg_lab;

public interface Weapon {
    int getAttackPoints();

    int getDurabilityPoints();

    int getDurabilityReductionFactor();

    void attack(Target target);
}
