package com.bkdn.maihuong.giaiptbac1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnkq;
    EditText edt1, edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        btnkq = (Button) findViewById(R.id.btnkq);


        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                try {
                    int a = Integer.parseInt(edt1.getText().toString());
                    int b = Integer.parseInt(edt2.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putInt("soA", a);
                    bundle.putInt("soB", b);
                    myIntent.putExtra("My Package", bundle);
                    startActivity(myIntent);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error: Wrong number format", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
