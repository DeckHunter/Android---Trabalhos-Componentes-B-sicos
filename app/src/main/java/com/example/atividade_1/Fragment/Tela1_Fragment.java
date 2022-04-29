package com.example.atividade_1.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.atividade_1.Activity.TelaDividida;
import com.example.atividade_1.R;

public class Tela1_Fragment extends Fragment {

    private Button btm;
    private ListView listView;
    private String[] itens = {
            "Abecásia",
            "Afeganistão",
            "África do Sul",
            "Albânia",
            "Alemanha",
            "Andorra",
            "Angola",
            "Antígua e Barbuda",
            "Arábia Saudita",
            "Argélia",
            "Argentina",
            "Armênia",
            "Austrália",
            "Áustria",
            "Azerbaijão",
    };

    public Tela1_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tela1_, container, false);

        btm = view.findViewById(R.id.btmClick);
        listView = view.findViewById(R.id.itens);

        btm.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getContext(),"Clique Longo",Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Clique Rapido",Toast.LENGTH_SHORT).show();
            }
        });

        //Criar Adaptador De Tela
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );
        //Usando Adapter
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valorSelec = listView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(),valorSelec+" Clicado",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
