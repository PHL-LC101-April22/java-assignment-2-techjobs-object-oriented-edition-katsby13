package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId () {
        Job test1 = new Job();
        Job test2 = new Job();
        assertNotEquals(test1, test2);
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job test3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertTrue(test3 instanceof Job);
        assertTrue(test3.getName() == "Product tester");
        assertTrue(test3.getEmployer() instanceof Employer);
        assertTrue(test3.getLocation() instanceof Location);
        assertTrue(test3.getPositionType() instanceof PositionType);
        assertTrue(test3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(test3.getName(), "Product tester");
        assertEquals(test3.getEmployer().getValue(), "ACME");
        assertEquals(test3.getLocation().getValue(), "Desert");
        assertEquals(test3.getPositionType().getValue(), "Quality Control");
        assertEquals(test3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality () {
        Job test4 = new Job("Tester", new Employer("Testing Place"), new Location("Place"), new PositionType("Testing"), new CoreCompetency("Good at testing"));
        Job test5 = new Job("Tester", new Employer("Testing Place"), new Location("Place"), new PositionType("Testing"), new CoreCompetency("Good at testing"));
        assertFalse(test4.equals(test5));
    }
}
