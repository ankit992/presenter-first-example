package in.co.ankitarora.chatapplication.chat;

import java.util.LinkedList;

import in.co.ankitarora.chatapplication.Event;
import in.co.ankitarora.chatapplication.Events;

public class ChatModelImpl implements ChatModel {
    private String name;
    private LinkedList<Event> onMessageFromServerEvents=new LinkedList<>();

    @Override
    public void sendChatMessageToServer(String message) {
        name = message;
        Events.fire(onMessageFromServerEvents);
    }

    @Override
    public void onMessageFromServer(Event event) {
        onMessageFromServerEvents.add(event);
    }

    @Override
    public String getCurrentMessage() {
        return "Hello " + name;
    }
}
