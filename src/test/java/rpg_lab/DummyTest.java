package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int ALIVE_HEALTH = 100;
    private static final int ALIVE_EXPERIENCE = 10;
    private Dummy aliveDummy;

    private static final int DEAD_HEALTH = 0;
    private static final int DEAD_EXPERIENCE = 10;
    private Dummy deadDummy;

    private static final int ATTACK_POINTS = 10;

    @Before
    public void setUp() {
        this.aliveDummy = new Dummy(ALIVE_HEALTH, ALIVE_EXPERIENCE);
        this.deadDummy = new Dummy(DEAD_HEALTH, DEAD_EXPERIENCE);
    }

    @Test
    public void testTakeAttackLosesHealthIfAttacked() {
        int expected = aliveDummy.getHealth() - ATTACK_POINTS;
        aliveDummy.takeAttack(ATTACK_POINTS);
        assertEquals(expected, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeAttackThrowsIllegalStateIfIsDead() {
        deadDummy.takeAttack(0);
    }

    @Test
    public void testGiveExperienceIfIsDead() {
        int actual = deadDummy.  giveExperience();
        assertEquals(DEAD_EXPERIENCE, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testGiveExperienceThrowsIllegalStateIfNotDead() {
        aliveDummy.giveExperience();
    }
}
