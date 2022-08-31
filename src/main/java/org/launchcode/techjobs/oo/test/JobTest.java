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

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job test6 = new Job("Tester", new Employer("Testing Place"), new Location("Place"), new PositionType("Testing"), new CoreCompetency("Good at testing"));
        assertEquals(test6.toString().charAt(0), '\n');
        assertEquals(test6.toString().charAt(test6.toString().length() -1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData () {
        Job test7 = new Job("Tester", new Employer("Testing Place"), new Location("Place"), new PositionType("Testing"), new CoreCompetency("Good at testing"));
        assertTrue(test7.toString().contains("\nID: 4"));
        assertTrue(test7.toString().contains("\nName: Tester"));
        assertTrue(test7.toString().contains("\nEmployer: Testing Place"));
        assertTrue(test7.toString().contains("\nLocation: Place"));
        assertTrue(test7.toString().contains("\nPosition Type: Testing"));
        assertTrue(test7.toString().contains("\nCore Competency: Good at testing"));
        assertEquals(test7.toString(), "\nID: " + test7.getId() + "\nName: Tester\nEmployer: Testing Place\nLocation: Place\nPosition Type: Testing\nCore Competency: Good at testing\n");
    }

    @Test
    public void testToStringHandlesEmptyField () {
        Job test8 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(test8.toString(), "\nID: " + test8.getId() + "\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n");
    }
}
