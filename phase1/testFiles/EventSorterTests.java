import entities.Event;
import presenters.EventSorter;
import org.junit.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class EventSorterTests {
    static ArrayList<Event> eventInfo = new ArrayList<Event>();
    static LocalDateTime date1 = LocalDateTime.of(2020, Month.NOVEMBER, 19, 18, 0,0);
    static LocalDateTime date2 = LocalDateTime.of(2020, Month.NOVEMBER, 18, 18, 0,0);
    static LocalDateTime date3 = LocalDateTime.of(2020, Month.NOVEMBER, 18, 17, 0,0);
    static Event e1 = new Event(1, "Desmos", date1, 1, 1, 1);
    static Event e2 = new Event(2, "ABRA CADABRA", date2, 1, 1, 1);
    static Event e3 = new Event(3, "cobra", date3, 1, 2, 1);

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

    @Test(timeout = 50)
    public void testSortedByTime() throws Exception {
        ArrayList<Event> sortedEvents = new ArrayList<Event>();
        sortedEvents.add(e3);
        sortedEvents.add(e2);
        sortedEvents.add(e1);
        ArrayList<Event> sorted = EventSorter.sortByTime(eventInfo);
        assertEquals(sortedEvents, sorted);
    }



}
