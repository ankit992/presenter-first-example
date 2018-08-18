package in.co.ankitarora.chatapplication.chat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import in.co.ankitarora.chatapplication.Event;

import static org.mockito.Mockito.verify;

public class ChatPresenterTest {

    @Mock
    private ChatModel model;

    @Mock
    private ChatView view;

    @Captor
    private ArgumentCaptor<Event> runnableArgumentCaptor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        new ChatPresenter(model,view);
    }
    @Test
    public void whenSendClicked_sendMessageToServer(){
        verify(view).sendClicked(runnableArgumentCaptor.capture());
        runnableArgumentCaptor.getValue().run();
        String message =verify(view).getChatMessage();
        verify(model).sendChatMessageToServer(message);
    }

    @Test
    public void onMessageFromServer_showMessageOnView(){
        verify(model).onMessageFromServer(runnableArgumentCaptor.capture());
        runnableArgumentCaptor.getValue().run();
        String message= verify(model).getCurrentMessage();
        verify(view).showMessageFromServer(message);
    }
}
