package com.example.asend.popapr;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button b1,b2;
    EditText ed1,ed2;

    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void Go(View v) {
        if(ed1.getText().toString().equals("admin") &&
                ed2.getText().toString().equals("admin")) {
            //on creer une nouvelle intent on definit la class de depart ici this et la class d'arrivé ici UserList
            Intent intent=new Intent(this,UserList.class);
            //intent.putExtra("prenom", ed1.getText().toString());
            //on lance l'intent, cela a pour effet de stoper l'activité courante et lancer une autre activite ici SecondActivite
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

            counter--;

            if (counter == 0) {
                b1.setEnabled(false);
            }
        }
    }
}
