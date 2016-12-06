package aarin.test.kr.broadcastreceiverex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsend = (Button) findViewById(R.id.btnsend);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent("aarin.test.kr.broadcastreceiverex.SEND_BROAD_CAST");
                sendIntent.putExtra("isBoolean", true);
                sendIntent.putExtra("sendInteger", 123);
                sendIntent.putExtra("sendString", "Intent String");
                sendBroadcast(sendIntent);
            }
        });
    }


}
