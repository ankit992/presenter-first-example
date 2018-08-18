package in.co.ankitarora.chatapplication.chat;

import in.co.ankitarora.chatapplication.Event;

public interface ChatModel {
    void sendChatMessageToServer(String message);

    void onMessageFromServer(Event capture);

    String getCurrentMessage();
}
