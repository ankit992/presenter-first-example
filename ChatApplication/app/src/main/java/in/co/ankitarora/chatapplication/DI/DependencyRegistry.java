package in.co.ankitarora.chatapplication.DI;

import in.co.ankitarora.chatapplication.chat.ChatFragment;
import in.co.ankitarora.chatapplication.chat.ChatModel;
import in.co.ankitarora.chatapplication.chat.ChatModelImpl;
import in.co.ankitarora.chatapplication.chat.ChatPresenter;

public class DependencyRegistry {
    public static DependencyRegistry getInstance() {
        if (instance == null) {
            instance = new DependencyRegistry();
        }
        return instance;
    }

    //to be called only from Test methods/classes
    public static void setInstance(DependencyRegistry instance) {
        DependencyRegistry.instance = instance;
    }

    private static DependencyRegistry instance;

    private DependencyRegistry() {}

    public ChatFragment getChatFragment() {
        ChatFragment chatFragment=new ChatFragment();
        ChatModel chatModel= new ChatModelImpl();
        new ChatPresenter(chatModel,chatFragment);
        return chatFragment;
    }
}
