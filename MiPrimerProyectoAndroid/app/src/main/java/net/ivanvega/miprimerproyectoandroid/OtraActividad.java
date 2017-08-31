package net.ivanvega.miprimerproyectoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by alcohonsilver on 28/08/17.
 */

public class OtraActividad extends AppCompatActivity {

    EditText txt;
    Button btn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_otraactividad);

        Intent i = getIntent();

        ;
        ;

        this.setTitle(i.getStringExtra("param1"));
        Toast.makeText(this,
                String.valueOf(i.getIntExtra("param2",-1)),
                Toast.LENGTH_LONG
                ).show();

        txt = (EditText) findViewById(R.id.txtTexto);
        btn = (Button) findViewById(R.id.btnTexto);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("paramreturn",txt.getText().toString());

                setResult(RESULT_OK, i);

                finish();
            }
        });


    }
}
