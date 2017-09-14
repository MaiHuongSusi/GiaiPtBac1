package com.bkdn.maihuong.giaiptbac1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    TextView tvkq;
    Button btnback;
    int a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvkq = (TextView) findViewById(R.id.tvkq);
        btnback = (Button) findViewById(R.id.btnback);
        Intent callerIntent = getIntent();
        Bundle packBundle = callerIntent.getBundleExtra("My Package");
        a = packBundle.getInt("soA");
        b = packBundle.getInt("soB");
        giaiPTBN(a,b);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ResultActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                myIntent.putExtra("My Package",bundle);
                Toast.makeText(ResultActivity.this, "Wellcome back to MainActivity ! Your last edit text : a = "+a+", b = "+b,Toast.LENGTH_LONG).show();
                startActivity(myIntent);

            }
        });

    }

    private void giaiPTBN(int a, int b) {
        if(a==0) {
            if (b == 0) {
                tvkq.setText("Phương trình vô số nghiệm");
            } else {
                tvkq.setText("Phương trình vô nghiệm");
            }
        } else {
            tvkq.setText("Nghiệm của Phương trình: "+String.valueOf((float)-b/a));
        }
    }
}

