package rpg_lab;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private Axe axe;
    private Axe axeDurabilityZero;

    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 10;
    private Target target;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.axeDurabilityZero = new Axe(AXE_ATTACK, 0);

        this.target = Mockito.mock(Target.class);
    }

    @Test
    public void testAttackReducesDurability() {
        int expected = axe.getDurabilityPoints() - axe.getDurabilityReductionFactor();

        axe.attack(target);

        assertEquals(expected, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackThrowsIllegalStateWhenDurabilityZeroOrNegative() {
        axeDurabilityZero.attack(target);
    }
}
