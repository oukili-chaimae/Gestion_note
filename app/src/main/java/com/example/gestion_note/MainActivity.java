package com.example.gestion_note;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

Button b;
Button btn2, btn3;
Spinner sp;
private ArrayList<String> data = new ArrayList<>();
private ArrayList<String> data2 = new ArrayList<>();
private ArrayList<String> data3= new ArrayList<>();
//private ArrayList<String> data4 = new ArrayList<>();
private TextView resultat;

EditText addNote;
TextView moy;
Spinner addModule;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addModule = findViewById(R.id.addModule);
        addNote = findViewById(R.id.addNote);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouter();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();
            }
        });

       }

     /*  public void  displayToast(View V){
        b=(Button)findViewById(R.id.button2) ;
        sp=(Spinner)findViewById(R.id.addModule);
        b.setOnClickListener(v ->{
            String module =sp.getSelectedItem().toString();
            makeText(getBaseContext(),module, LENGTH_SHORT).show();
        });

       }*/

       public void ajouter(){
           Float som = Float.valueOf(0);
           Float m = Float.valueOf(0);
        Float note= Float.valueOf(addNote.getText().toString());
        String module= addModule.getSelectedItem().toString();
        data.add(module);
        data2.add(String.valueOf(note));
           TableLayout table =(TableLayout) findViewById(R.id.table1);
           TableRow row = new TableRow(this);
           TextView t1 = new TextView(this);
           TextView t2 = new TextView(this);
         //  TextView t3 = new TextView(this);
           for (int i=0; i<data.size(); i++) {

               String mod = data.get(i);
               Float not = Float.valueOf(data2.get(i));
               t1.setText(mod);
               t2.setText(String.valueOf(not));
               som+=not;
               m=som/data2.size();
             data3.add(String.valueOf(m));

           }
           row.addView(t1);
           row.addView(t2);
           table.addView(row);
           addNote.setText("");



       }

        public void calculer(){

            makeText(getBaseContext(),String.valueOf(data3.get(data3.size()-1)), LENGTH_SHORT).show();
            resultat= (TextView) findViewById(R.id.moy);
            resultat.setText(data3.get(data3.size()-1));





        }
}
