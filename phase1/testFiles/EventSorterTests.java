import entities.Event;
import presenters.EventSorter;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EventSorterTests {

    static ArrayList<Event> eventInfo = new ArrayList<Event>();
    static Event e1 = new Event(1, "Desmos", "00000", 1, 1, 1);
    static Event e2 = new Event(2, "ABRA CADABRA", "0001", 1, 1, 1);
    static Event e3 = new Event(3, "cobra", "0002", 1, 2, 1);

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        eventInfo.add(e1);
        eventInfo.add(e2);
        eventInfo.add(e3);
    }

    @Test(timeout = 50)
    public void testSortByTitle() throws Exception {
        ArrayList<Event> sortedEvents = new ArrayList<Event>();
        sortedEvents.add(e2);
        sortedEvents.add(e3);
        sortedEvents.add(e1);
        ArrayList<Event> sorted = EventSorter.sortByTitle(eventInfo);
        assertEquals(sortedEvents, sorted);
    }

    @Test(timeout = 50)
    public void testSortBySpeaker() throws Exception {
        ArrayList<Event> sortedEvents = new ArrayList<Event>();
        sortedEvents.add(e1);
        sortedEvents.add(e2);
        sortedEvents.add(e3);
        ArrayList<Event> sorted = EventSorter.sortBySpeaker(eventInfo);
        assertEquals(sortedEvents, sorted);
    }




}
