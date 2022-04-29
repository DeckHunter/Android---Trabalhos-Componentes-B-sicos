package com.example.atividade_1.Fragment;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.atividade_1.R;

import static android.content.Context.AUDIO_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tela2_Fragment extends Fragment {

    private ImageButton play;
    private ImageButton pause;
    private ImageButton reset;
    private MediaPlayer mediaPlayer;
    public Tela2_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tela2_, container, false);

        play = view.findViewById(R.id.play);
        pause = view.findViewById(R.id.pause);
        reset = view.findViewById(R.id.reset);

        mediaPlayer = MediaPlayer.create(getContext(),R.raw.bach);

        //Play
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer != null){
                    mediaPlayer.start();
                    Toast.makeText(getContext(),"Voce Clicou No Play", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Pause
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    Toast.makeText(getContext(),"Voce Clicou No Pause", Toast.LENGTH_LONG).show();
                }
            }
        });
        //Reset
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    Toast.makeText(getContext(),"Voce Clicou No Parar", Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;
    }


}
