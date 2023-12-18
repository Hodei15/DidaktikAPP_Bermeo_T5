package com.example.didaktikapp.Fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.didaktikapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bideo_Fragment_Gune_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bideo_Fragment_Gune_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private VideoView kontserbaVideo;
    private MediaController kontroladorea;

    public Bideo_Fragment_Gune_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag1.
     */
    // TODO: Rename and change types and number of parameters
    public static Bideo_Fragment_Gune_1 newInstance(String param1, String param2) {
        Bideo_Fragment_Gune_1 fragment = new Bideo_Fragment_Gune_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2,param2);
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bideo_gune_1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Videoa lortu
        kontserbaVideo = view.findViewById(R.id.KontsVideo);
        if (kontserbaVideo != null) {
            // URI konfiguratu gure bideorako
            String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.kontserbak;
            Uri uri = Uri.parse(videoPath);
            kontserbaVideo.setVideoURI(uri);
            //Bideoaren kontroladorea Sortu
            kontroladorea = new MediaController(getActivity());
            //kontserbaVideo.setVideoPath(videoPath);
            kontserbaVideo.setMediaController(kontroladorea);
            kontroladorea.setAnchorView(kontserbaVideo);
            // MediaController sortuta dagoela verifikatu videoa hasi baino lehen
            if (kontroladorea != null) {
                // Iniciar la reproducción del video
                kontserbaVideo.start();
            }
        }
        kontserbaVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                boolean bukatuta = true;
            }
        });
    }
}