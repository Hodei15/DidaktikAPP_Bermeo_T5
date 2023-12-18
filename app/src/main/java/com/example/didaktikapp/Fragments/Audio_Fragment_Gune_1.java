package com.example.didaktikapp.Fragments;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;

import com.example.didaktikapp.R;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Audio_Fragment_Gune_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Audio_Fragment_Gune_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Audio_Fragment_Gune_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag2.
     */
    // TODO: Rename and change types and number of parameters
    public static Audio_Fragment_Gune_1 newInstance(String param1, String param2) {
        Audio_Fragment_Gune_1 fragment = new Audio_Fragment_Gune_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio_gune_1, container, false);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_audio_gune_1, container, false);
    }

    private MediaPlayer player;
    private SeekBar barraAudio;
    private int audioarenposizioa = 0;
    private Runnable runnable;
    private Handler handler = new Handler();;
    private boolean playing = false;
    SharedPreferences prefs;
    private ScrollView textua;
    private ImageView Play;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Play = (ImageView) view.findViewById(R.id.img_Audio_2play);
        barraAudio = view.findViewById(R.id.id_audioBarra_G2);
        player = MediaPlayer.create(getActivity(), R.raw.audio_kontserbak);
        barraAudio.setMax(player.getDuration());
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        textua = view.findViewById(R.id.testua_Gune_2);
        runnable = new Runnable() {
            @Override
            public void run() {
                if (player != null) {
                    int mCurrentPosition = player.getCurrentPosition();
                    barraAudio.setProgress(mCurrentPosition);

                }
                handler.postDelayed(this, 100);
            }
        };
        handler.postDelayed(runnable, 100);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!playing) {
                    Play.setImageResource(R.drawable.pausa);
                    start();
                }else{
                    Play.setImageResource(R.drawable.play);
                    pause();
                }
            }
        });
        barraAudio.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    player.seekTo(progress);

                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                player.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.start();
            }
        });
    }
    //audioa hasieratzeko metodoa
    private void start() {
        if (!player.isPlaying() && !playing) {
            player.seekTo(audioarenposizioa);
            player.start();
            playing = true;

        }
        //audioa geratu den lekuan hasieratzen da
        else if (playing){
            int position = prefs.getInt("mediaPosition",0);
            player.seekTo(position);
        }
    }
    //audioa gelditzeko metodoa
    private void pause(){
        if(player.isPlaying()){
            audioarenposizioa = player.getCurrentPosition();
            player.stop();
            playing = false;
        }
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}