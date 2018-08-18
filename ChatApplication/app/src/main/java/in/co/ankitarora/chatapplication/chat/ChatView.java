package in.co.ankitarora.chatapplication.chat;

import in.co.ankitarora.chatapplication.Event;

public interface ChatView {
    void sendClicked(Event capture);

    String getChatMessage();

    void showMessageFromServer(String message);
}
