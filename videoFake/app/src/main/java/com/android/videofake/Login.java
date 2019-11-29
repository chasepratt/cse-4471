package com.android.videofake;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Login extends Activity {
    private TextView userName, password;
    private ImageView send;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        userName = (TextView) findViewById(R.id.Username);
        password = (TextView) findViewById(R.id.password);
        send= (ImageView) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendInfo();
            }
        });
    }

    private void sendInfo() {
        String name =  userName.getText().toString();
        String pw = password.getText().toString();
        User user = new User(name, pw);
        DatabaseReference  mDatabase=reference.child("users");
        mDatabase.push().setValue(user);
        Toast.makeText(getApplicationContext(), "Log in failed", Toast.LENGTH_LONG).show();
    }

}
