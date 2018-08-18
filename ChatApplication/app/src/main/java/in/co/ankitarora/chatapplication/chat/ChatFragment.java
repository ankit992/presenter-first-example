package in.co.ankitarora.chatapplication.chat;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import in.co.ankitarora.chatapplication.Event;
import in.co.ankitarora.chatapplication.Events;
import in.co.ankitarora.chatapplication.R;

public class ChatFragment extends Fragment implements ChatView {
    private EditText editTextPhone;
    private ListView listViewMessages;
    private EditText editTextMessage;
    private Button buttonSend;
    private LinkedList<Event> sendClickedEvents = new LinkedList<>();
    private List<String> listMessagesArray = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;


    @Override
    public void sendClicked(Event event) {
        sendClickedEvents.add(event);
    }

    @Override
    public String getChatMessage() {
        return editTextMessage.getText().toString();
    }

    @Override
    public void showMessageFromServer(String message) {
        listMessagesArray.add(message);
        arrayAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View contentView = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView == null) {
            contentView = inflater.inflate(R.layout.fragment_chat, container, false);
        }
        bindViews(contentView);
        initializeViews();
        return contentView;
    }

    private void initializeViews() {
        buttonSend.setOnClickListener(view -> {
            if (!editTextMessage.getText().toString().isEmpty()) {
                listMessagesArray.add(editTextMessage.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                Events.fire(sendClickedEvents);
            }
        });

        arrayAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                listMessagesArray);

        listViewMessages.setAdapter(arrayAdapter);
    }

    private void bindViews(View contentView) {
        editTextPhone = contentView.findViewById(R.id.edit_text_phone_number);
        listViewMessages = contentView.findViewById(R.id.list_view_message_box);
        editTextMessage = contentView.findViewById(R.id.edit_text_message);
        buttonSend = contentView.findViewById(R.id.button_send);
    }


}
