package testFiles;

import entities.Menu;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTests {
    @Test
    public void testGetOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("messages");
        options.add("contacts");
        options.add("events");
        Menu m1 = new Menu(options);
        //Assert.assertArrayEquals();
    }
}