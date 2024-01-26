package com.example.didaktikapp.Model;

// ZatiTxo.java
import static android.service.controls.ControlsProviderService.TAG;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;

import com.example.didaktikapp.R;

import java.util.ArrayList;
import java.util.List;

public class ZatiTxo extends View {
    private float startX, startY;
    private List<Argazki> gorputza;
    private List<Argazki> gorputzaOndo;
    private ImageView img_correcto;

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public boolean isJolasa_amaituta() {
        return jolasa_amaituta;
    }

    public void setJolasa_amaituta(boolean jolasa_amaituta) {
        this.jolasa_amaituta = jolasa_amaituta;
    }

    private  boolean jolasa_amaituta;

    public ZatiTxo(Context context, AttributeSet attrs) {
        super(context, attrs);
        jolasa_amaituta=false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float finishX = event.getX();
        float finishY = event.getY();
        boolean valido = false;
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                // Guardar la posición inicial al tocar la imagen
                startX = finishX;
                startY = finishY;
                for(int i=0;i<gorputza.size();i++) {
                    boolean a = startX >= gorputza.get(i).getX();
                    boolean b = startX <= (gorputza.get(i).getX() + gorputza.get(i).getWidth());
                    boolean c1 = startY >= gorputza.get(i).getY() - gorputza.get(i).getHeight();
                    boolean c2 = startY >= (gorputza.get(i).getY() - (gorputza.get(i).getHeight() * 2));
                    boolean d = startY <= (gorputza.get(i).getHeight() + gorputza.get(i).getY());
                    boolean e = gorputza.get(i).isLotuta();

                    if (startX >= gorputza.get(i).getX() && startX <= (gorputza.get(i).getX() + gorputza.get(i).getWidth()) && startY >= gorputza.get(i).getY() && startY <= (gorputza.get(i).getHeight() + gorputza.get(i).getY()) && !gorputza.get(i).isLotuta()) {
                        gorputza.get(i).setDrag(true);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                for(int i=0;i<gorputza.size() && !valido;i++) {
                    if (gorputza.get(i).isDrag()) {
                        gorputza.get(i).getImg().setX(gorputza.get(i).getX()-(startX-finishX));
                        gorputza.get(i).getImg().setY(gorputza.get(i).getY()-(startY-finishY));
                        //gorputza.get(i).setX(gorputza.get(i).getX()-(startX-finishX));
                        //gorputza.get(i).setY(gorputza.get(i).getY()-(startX-finishY));
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                boolean dentro = false;
                int gorputza_bikote=-1;
                int gorputzaOndo_bikote=-1;
                int index_gorputza=-1;
                int index_gorputzaOndo=-1;

                for(int i=0;i<gorputza.size();i++) {
                    gorputza.get(i).setDrag(false);
                }

                for(int i=0;i<gorputza.size() && !valido;i++){
                    if (startX >= gorputza.get(i).getX() && startX <= (gorputza.get(i).getX() + gorputza.get(i).getWidth()) && startY >= (gorputza.get(i).getY() - gorputza.get(i).getHeight()) && startY <= (gorputza.get(i).getHeight() + gorputza.get(i).getY()) && !gorputza.get(i).isLotuta()) {
                        valido = true;
                        gorputza_bikote = gorputza.get(i).getBikote();
                        index_gorputza = i;
                    }
                }
                if(valido) {
                    for (int i = 0; i < gorputzaOndo.size() && !dentro; i++) {
                        if (finishX >= gorputzaOndo.get(i).getX() && finishX <= (gorputzaOndo.get(i).getX() + gorputzaOndo.get(i).getWidth()) && finishY >= gorputzaOndo.get(i).getY() && finishY <= (gorputzaOndo.get(i).getHeight() + gorputzaOndo.get(i).getY()) && !gorputzaOndo.get(i).isLotuta()) {
                            dentro = true;
                            gorputzaOndo_bikote = gorputzaOndo.get(i).getBikote();
                            index_gorputzaOndo = i;
                        }
                    }
                    if (dentro && gorputza_bikote != gorputzaOndo_bikote) {
                        try {
                            this.img_correcto.setImageResource(R.drawable.cruz);
                            EsperaImagen espera = new EsperaImagen(this.img_correcto);
                            this.img_correcto.setVisibility(View.VISIBLE);
                        } catch (Exception e) {

                        }
                    } else {
                        try {
                            //Argazkia lekuan kokatzen du
                            gorputza.get(index_gorputza).getImg().setX(gorputzaOndo.get(index_gorputzaOndo).getImg().getX());
                            gorputza.get(index_gorputza).getImg().setY(gorputzaOndo.get(index_gorputzaOndo).getImg().getY());
                            for(int i=0;i<gorputza.size();i++){
                                if(gorputza.get(i).bikote==gorputza_bikote){
                                    gorputza.get(index_gorputza).setLotuta(true);
                                }
                            }
                            gorputzaOndo.get(index_gorputzaOndo).setLotuta(true);
                            this.img_correcto.setImageResource(R.drawable.tick);
                            EsperaImagen espera = new EsperaImagen(this.img_correcto);
                            this.img_correcto.setVisibility(View.VISIBLE);

                            boolean jolasa_amaituta_prob = true;
                            for(int i =0;i<gorputza.size() && jolasa_amaituta_prob;i++){
                                if(!gorputza.get(i).isLotuta()){
                                    jolasa_amaituta_prob = false;
                                }
                            }
                            if(jolasa_amaituta_prob){
                                this.jolasa_amaituta = true;
                            }

                        } catch (Exception e) {
                        }
                    }
                }
                break;
            default:
                return false;
        }

        // Invalidar la vista para que se repinte
        invalidate();
        return true;
    }

    public void onTouchEvent(int actionDown, Button btnPrueba) {
    }

    public List<Argazki> getGorputza() {
        return gorputza;
    }

    public void setGorputza(List<Argazki> gorputza) {
        this.gorputza = gorputza;
    }

    public List<Argazki> getGorputzaOndo() {
        return gorputzaOndo;
    }

    public void setGorputzaOndo(List<Argazki> gorputzaOndo) {
        this.gorputzaOndo = gorputzaOndo;
    }

    public ImageView getImg_correcto() {
        return img_correcto;
    }

    public void setImg_correcto(ImageView img_correcto) {
        this.img_correcto = img_correcto;
    }
}
