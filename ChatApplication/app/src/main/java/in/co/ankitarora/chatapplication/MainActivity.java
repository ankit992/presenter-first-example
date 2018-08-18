package in.co.ankitarora.chatapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import in.co.ankitarora.chatapplication.DI.DependencyRegistry;
import in.co.ankitarora.chatapplication.chat.ChatFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initFragment(DependencyRegistry.getInstance().getChatFragment());
    }

    private void initFragment(ChatFragment chatFragment) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,chatFragment);
        fragmentTransaction.commit();
    }
}
