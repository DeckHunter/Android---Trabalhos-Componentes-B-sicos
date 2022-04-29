package com.example.atividade_1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.atividade_1.R;

public class MainActivity extends AppCompatActivity {

    public TextView cor1;
    public TextView cor2;
    public Switch ativar;
    public RadioButton radio3;
    public RadioButton radio4;
    private static final String[] completar = new String[]{
            "Brasil","Alemanha","Cuba","Argentina","Russia","EUA",
            "Africa","Egito","Roma","Arabe","França","Italia",
            "Paraguai","Uruaguai","China","Japão"
    };

    private Button btmnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cor1 =  findViewById(R.id.cor1);
        ativar = findViewById(R.id.switch1);
        radio3 = findViewById(R.id.radioButton3);
        radio4 = findViewById(R.id.radioButton4);

        btmnext = findViewById(R.id.btmnext);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoC);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,completar);
        autoCompleteTextView.setAdapter(arrayAdapter);

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter(MainActivity.this,
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.planets_array));
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spinner.setAdapter(adapter);

        btmnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TelaDividida.class);
                startActivity(intent);
            }
        });

        radio3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radio3.isChecked()){
                    radio3.setTextColor(getResources().getColor(R.color.ativado));
                }else{
                    radio3.setTextColor(getResources().getColor(R.color.desativado));
                }
            }
        });

        radio4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radio4.isChecked()){
                    radio4.setTextColor(getResources().getColor(R.color.ativado));
                }else{
                    radio4.setTextColor(getResources().getColor(R.color.desativado));
                }
            }
        });

        ativar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ativar.isChecked()){
                    cor1.setTextColor(getResources().getColor(R.color.ativado));
                    cor1.setText("Cor: Vermelho");
                } else {
                    cor1.setTextColor(getResources().getColor(R.color.desativado));
                    cor1.setText("Cor: Azul");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_1:
                Toast.makeText(MainActivity.this,"Clique : Menu Teste 1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_2:
                Toast.makeText(MainActivity.this,"Clique : Menu Teste 2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_3:
                Toast.makeText(MainActivity.this,"Clique : Menu Teste 3",Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
