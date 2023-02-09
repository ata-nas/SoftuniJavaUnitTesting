package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class HeroTest {
    Weapon weapon;
    Target target;
    Hero hero;

    @Before
    public void setUp() {
        this.weapon = mock(Weapon.class);
        this.target = mock(Target.class);
        this.hero = new Hero("Test", weapon);
    }

    @Test
    public void testAttackGetExperienceWhenTargetDies() {
        int targetExperience = 10;
        int expected = hero.getExperience() + targetExperience;

        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(targetExperience);

        hero.attack(target);

        assertEquals(expected, hero.getExperience());
    }
}