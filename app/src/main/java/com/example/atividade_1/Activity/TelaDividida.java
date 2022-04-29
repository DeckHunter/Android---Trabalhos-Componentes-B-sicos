package com.example.atividade_1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.atividade_1.Fragment.Tela1_Fragment;
import com.example.atividade_1.Fragment.Tela2_Fragment;
import com.example.atividade_1.R;

public class TelaDividida extends AppCompatActivity {

    private Button btmTela1;
    private Button btmTela2;

    private Tela1_Fragment tela_1_fragment;
    private Tela2_Fragment tela_2_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dividida);

        //Remover actionbar
        getSupportActionBar().setElevation(0);

        btmTela1 = findViewById(R.id.btmtela1);
        btmTela2 = findViewById(R.id.btmtela2);

        tela_1_fragment = new Tela1_Fragment();
        tela_2_fragment = new Tela2_Fragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, tela_1_fragment);
        transaction.commit();

        btmTela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Exibir Fragmentos
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, tela_1_fragment);
                transaction.commit();
            }
        });

        btmTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Exibir Fragmentos
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, tela_2_fragment);
                transaction.commit();
            }
        });
    }
}
