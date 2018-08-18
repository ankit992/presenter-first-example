package in.co.ankitarora.chatapplication.chat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class ChatModelTest {

    private ChatModel chatModel= new ChatModelImpl();
    private String message = "hi";

    @Mock
    Runnable event;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testChatModelMessageSendReceive(){
        chatModel.onMessageFromServer(event);
        chatModel.sendChatMessageToServer(message);
        verify(event).run();
        String message = "Hello hi";
        assertEquals(chatModel.getCurrentMessage(),message);
    }
}
