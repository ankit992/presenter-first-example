package in.co.ankitarora.chatapplication.chat;

public class ChatPresenter {
    public ChatPresenter(ChatModel model, ChatView view) {
        view.sendClicked(() -> model.sendChatMessageToServer(view.getChatMessage()));
        model.onMessageFromServer(() -> view.showMessageFromServer(model.getCurrentMessage()));
    }
}
