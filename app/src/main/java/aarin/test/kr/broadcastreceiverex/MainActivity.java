package aarin.test.kr.broadcastreceiverex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStatic;
    Button btnDynamic;
    TextView brText;

    BroadcastReceiver mReceiver;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStatic = (Button) findViewById(R.id.btnS);
        btnDynamic = (Button) findViewById(R.id.btnD);
        brText = (TextView) findViewById(R.id.br_text);

        btnStatic.setOnClickListener(this);
        btnDynamic.setOnClickListener(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction("aarin.test.kr.broadcastreceiverex.SEND_BROAD_CAST");

        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String sendString =intent.getStringExtra("sendString to Dynamic");
                Toast.makeText(MainActivity.this, sendString, Toast.LENGTH_SHORT).show();
            }
        };

        registerReceiver(mReceiver, filter);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnS :
                Toast.makeText(this, "Static Clicked", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent("aarin.test.kr.broadcastreceiverex.SEND_BROAD_CAST");
                sendIntent.putExtra("isBoolean", true);
                sendIntent.putExtra("sendInteger", 123);
                sendIntent.putExtra("sendString", "Intent String");
                sendBroadcast(sendIntent);
                break;
            case R.id.btnD :
                Toast.makeText(this, "Dynamic Clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                return;

        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
