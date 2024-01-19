package com.example.didaktikapp.Fragments;

import static java.lang.Math.abs;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.didaktikapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Jolasa_Fragment_Gune_4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Jolasa_Fragment_Gune_4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Jolasa_Fragment_Gune_4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Jolasa_Fragment_Gune_4.
     */
    // TODO: Rename and change types and number of parameters
    public static Jolasa_Fragment_Gune_4 newInstance(String param1, String param2) {
        Jolasa_Fragment_Gune_4 fragment = new Jolasa_Fragment_Gune_4();
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
        return inflater.inflate(R.layout.fragment_jolasa_gune_4, container, false);
    }

    private ImageView cabeza;
    private ImageView pierna_DER;
    private ImageView pierna_IZQ;
    private ImageView brazo_DER;
    private ImageView brazo_IZQ;
    private ImageView torso;
    private ImageView cabeza_Ondo;
    private ImageView pierna_DER_Ondo;
    private ImageView pierna_IZQ_Ondo;
    private ImageView brazo_DER_Ondo;
    private ImageView brazo_IZQ_Ondo;
    private ImageView torso_Ondo;
    private float xDelta, yDelta;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cabeza = view.findViewById(R.id.cabeza);
        pierna_DER = view.findViewById(R.id.pierna_DER);
        pierna_IZQ = view.findViewById(R.id.pierna_IZQ);
        brazo_DER = view.findViewById(R.id.brazo_DER);
        brazo_IZQ = view.findViewById(R.id.brazo_IZQ);
        torso = view.findViewById(R.id.torso);
        cabeza_Ondo = view.findViewById(R.id.cabeza_Ondo);
        pierna_DER_Ondo = view.findViewById(R.id.pierna_DER_Ondo);
        pierna_IZQ_Ondo = view.findViewById(R.id.pierna_IZQ_Ondo);
        brazo_DER_Ondo = view.findViewById(R.id.brazo_DER_Ondo);
        brazo_IZQ_Ondo = view.findViewById(R.id.brazo_IZQ_Ondo);
        torso_Ondo = view.findViewById(R.id.torso_Ondo);
        boolean cabezaDrag = false;
        boolean brazoIZQDrag = false;
        boolean brazoDERDrag = false;
        boolean piernaIZQDrag = false;
        boolean piernaDERDrag = false;
        boolean torsoDrag = false;


/*
        cabeza.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                // ... (otros códigos)

                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        // ... (otros códigos)
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // Mover la imagen solo si el arrastre está habilitado
                        if (cabezaDrag) {
                            cabeza.setX(x - xDelta);
                            cabeza.setY(y - yDelta);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        // Al soltar la imagen, verifica si está sobre la imagen "Cabeza_Ondo"
                        if (isViewOverlapping(cabeza, cabeza_Ondo)) {
                            // La cabeza está sobre "Cabeza_Ondo", deshabilita el arrastre
                            cabezaDrag = false;
                        }
                        break;
                }
                return true;
            }
        });
        pierna_DER.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        // Guardar la posición inicial al tocar la imagen
                        xDelta = x - pierna_DER.getX();
                        yDelta = y - pierna_DER.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // Mover la imagen según la posición del dedo
                        pierna_DER.setX(x - xDelta);
                        pierna_DER.setY(y - yDelta);
                        break;
                }
                return true;
            }
        });
        pierna_IZQ.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        // Guardar la posición inicial al tocar la imagen
                        xDelta = x - pierna_IZQ.getX();
                        yDelta = y - pierna_IZQ.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // Mover la imagen según la posición del dedo
                        pierna_IZQ.setX(x - xDelta);
                        pierna_IZQ.setY(y - yDelta);
                        break;
                }
                return true;
            }
        });
        brazo_DER.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        // Guardar la posición inicial al tocar la imagen
                        xDelta = x - brazo_DER.getX();
                        yDelta = y - brazo_DER.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // Mover la imagen según la posición del dedo
                        brazo_DER.setX(x - xDelta);
                        brazo_DER.setY(y - yDelta);
                        break;
                }
                return true;
            }
        });
        brazo_IZQ.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        // Guardar la posición inicial al tocar la imagen
                        xDelta = x - brazo_IZQ.getX();
                        yDelta = y - brazo_IZQ.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // Mover la imagen según la posición del dedo
                        brazo_IZQ.setX(x - xDelta);
                        brazo_IZQ.setY(y - yDelta);
                        break;
                }
                return true;
            }
        });
        torso.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        // Guardar la posición inicial al tocar la imagen
                        xDelta = x - torso.getX();
                        yDelta = y - torso.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // Mover la imagen según la posición del dedo
                        torso.setX(x - xDelta);
                        torso.setY(y - yDelta);
                        break;
                }
                return true;
            }
        });

    }
    private boolean isViewOverlapping(View firstView, View secondView) {
        Rect rectFirstView = new Rect();
        firstView.getHitRect(rectFirstView);

        Rect rectSecondView = new Rect();
        secondView.getHitRect(rectSecondView);

        return Rect.intersects(rectFirstView, rectSecondView);
    }
*/
    }
}
