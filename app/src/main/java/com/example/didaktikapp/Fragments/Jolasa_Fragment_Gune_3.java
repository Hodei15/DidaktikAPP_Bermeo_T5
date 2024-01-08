package com.example.didaktikapp.Fragments;

import static android.service.controls.ControlsProviderService.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.example.didaktikapp.Model.Argazki;
import com.example.didaktikapp.Model.DibujoView;
import com.example.didaktikapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jolasa_Fragment_Gune_3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jolasa_Fragment_Gune_3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Jolasa_Fragment_Gune_3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Jolasa_Fragment_Gune_3 newInstance(String param1, String param2) {
        Jolasa_Fragment_Gune_3 fragment = new Jolasa_Fragment_Gune_3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jolasa_gune_3, container, false);
    }
    ImageView mural;
    double argazkiZabalera;
    double argazkiAltuera;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mural = (ImageView) view.findViewById(R.id.Murala);

        ViewTreeObserver viewTreeObserver = mural.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int[] locationOnScreen = new int[2];
                mural.getLocationOnScreen(locationOnScreen);
                argazkiZabalera = mural.getWidth();
                argazkiAltuera = mural.getHeight();
                Log.d(TAG,"Finish X: "+ argazkiAltuera);
                Log.d(TAG,"Finish y: "+ argazkiZabalera);
            }
        });
        mural.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float clicX = event.getX();
                float clicY = event.getY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        Log.d(TAG,"Finish X: "+ clicX);
                        Log.d(TAG,"Finish Y: "+ clicY);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }
        });

    }
}