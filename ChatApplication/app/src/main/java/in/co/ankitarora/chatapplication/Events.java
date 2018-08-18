package in.co.ankitarora.chatapplication;

import java.util.LinkedList;

public class Events {

    public static void fire(LinkedList<Event> events) {
        for (Event event:events) {
            event.run();
        }
    }
}
