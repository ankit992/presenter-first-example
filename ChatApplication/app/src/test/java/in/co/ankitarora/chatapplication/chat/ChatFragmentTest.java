package in.co.ankitarora.chatapplication.chat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import in.co.ankitarora.chatapplication.BuildConfig;
import in.co.ankitarora.chatapplication.R;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 26, constants = BuildConfig.class)
public class ChatFragmentTest {
    private String message = "message";
    ChatFragment chatView = new ChatFragment();
    private EditText editTextPhone;
    private ListView listViewMessages;
    private Button buttonSend;
    private EditText editTextMessage;

    @Mock
    Runnable event;
    private String emptyMessage = "";

    @Test
    public void setup() {
        MockitoAnnotations.initMocks(this);
        startFragment(chatView);
        bindViews();
    }

    private void bindViews() {
        editTextPhone = chatView.getView().findViewById(R.id.edit_text_phone_number);
        listViewMessages = chatView.getView().findViewById(R.id.list_view_message_box);
        editTextMessage = chatView.getView().findViewById(R.id.edit_text_message);
        buttonSend = chatView.getView().findViewById(R.id.button_send);
    }

    @Test
    public void testViewHasRequiredFields() {
        assertNotNull(editTextMessage);
        assertNotNull(editTextPhone);
        assertNotNull(listViewMessages);
        assertNotNull(buttonSend);
    }

    @Test
    public void isMessageSendEventWorking_messageNotEmpty() {
        chatView.sendClicked(event);
        editTextMessage.setText(message);
        buttonSend.performClick();
        verify(event).run();
        assertEquals(chatView.getChatMessage(), message);
    }

    @Test
    public void isMessageSendEventWorking_emptyMessage() {
        chatView.sendClicked(event);
        editTextMessage.setText(emptyMessage);
        buttonSend.performClick();
        verify(event, times(0)).run();
        assertEquals(chatView.getChatMessage(), emptyMessage);
    }
}
