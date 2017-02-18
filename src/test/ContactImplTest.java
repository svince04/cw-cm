package test;

import impl.ContactImpl;
import org.junit.Before;
import org.junit.Test;
import spec.Contact;

import static org.junit.Assert.*;

/**
 * Created by essvee on 17/02/2017.
 */
public class ContactImplTest {

    @Test
    public void testGetId() {
        Contact carl = new ContactImpl(3, "Carl", "Inherently unstable person");
        int result = carl.getId();
        assertEquals(3, result);
    }

    @Test
    public void testGetName() {
        Contact carl = new ContactImpl(3, "Carl", "Inherently unstable person");
        String result = carl.getName();
        assertEquals("Carl", result);
    }

    @Test
    public void testGetNotes() {
        Contact carl = new ContactImpl(3, "Carl", "Inherently unstable person");
        String result = carl.getNotes();
        assertEquals("Inherently unstable person", result);
    }

    @Test
    public void testBriefConstructorId() {
        Contact viv = new ContactImpl(67, "Viv");
        int result = viv.getId();
        assertEquals(67, result);
    }

    @Test
    public void testBriefConstructorName() {
        Contact viv = new ContactImpl(67, "Viv");
        String result = viv.getName();
        assertEquals("Viv", result);
    }

    @Test
    public void testSetNotes() {
        Contact viv = new ContactImpl(65, "Viv");
        viv.addNotes("Dark horse");
        String result = viv.getNotes();
        assertEquals("Dark horse", result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testLongConstructorNegativeId() {
        Contact carl = new ContactImpl(-7, "Carl", "Inherently unstable person");
    }
}