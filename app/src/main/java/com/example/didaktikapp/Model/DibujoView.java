package com.example.didaktikapp.Model;

// DibujoView.java
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

public class DibujoView extends View {
    private Paint paint = new Paint();
    private List<Path> paths = new ArrayList<>();
    private Path currentPath;
    private float startX, startY;
    private List<Argazki> arrainak;
    private List<Argazki> latak;
    private ImageView img_correcto;

    public DibujoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        int colore = ContextCompat.getColor(context, R.color.azul_dibujo);
        paint.setColor(colore);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Path path : paths) {
            canvas.drawPath(path, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float finishX = event.getX();
        float finishY = event.getY();
        boolean valido = false;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = finishX;
                startY = finishY;
                Log.d(TAG,"Start Y: "+ startY);
                for(int i=0;i<arrainak.size() && !valido;i++) {
                    boolean a = startX >= arrainak.get(i).getX();
                    boolean b = startX <= (arrainak.get(i).getX() + arrainak.get(i).getWidth());
                    boolean c1 = startY >= arrainak.get(i).getY() - arrainak.get(i).getHeight();
                    boolean c2 = startY >= (arrainak.get(i).getY() - (arrainak.get(i).getHeight() * 2)) ;
                    boolean d = startY <= (arrainak.get(i).getHeight() + arrainak.get(i).getY());
                    boolean e = !arrainak.get(i).isLotuta();

                    if (startX >= arrainak.get(i).getX() && startX <= (arrainak.get(i).getX() + arrainak.get(i).getWidth()) && startY >= (arrainak.get(i).getY() - (arrainak.get(i).getHeight() * 2)) && startY <= (arrainak.get(i).getHeight() + arrainak.get(i).getY()) && !arrainak.get(i).isLotuta()) {
                        valido = true;
                        currentPath = new Path();
                        paths.add(currentPath);
                        currentPath.moveTo(finishX, finishY);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                for(int i=0;i<arrainak.size() && !valido;i++){
                    if (startX >= arrainak.get(i).getX() && startX <= (arrainak.get(i).getX() + arrainak.get(i).getWidth()) && startY >= (arrainak.get(i).getY() - (arrainak.get(i).getHeight() * 2)) && startY <= (arrainak.get(i).getHeight() + arrainak.get(i).getY()) && !arrainak.get(i).isLotuta()) {
                        valido = true;
                        currentPath.reset();
                        currentPath.moveTo(startX, startY);
                        currentPath.lineTo(finishX, finishY);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                boolean dentro = false;
                int arrain_bikote=-1;
                int lata_bikote=-1;
                int index_arrain=-1;
                int index_lata=-1;

                for(int i=0;i<arrainak.size() && !valido;i++){
                    if (startX >= arrainak.get(i).getX() && startX <= (arrainak.get(i).getX() + arrainak.get(i).getWidth()) && startY >= (arrainak.get(i).getY() - (arrainak.get(i).getHeight() * 2)) && startY <= (arrainak.get(i).getHeight() + arrainak.get(i).getY()) && !arrainak.get(i).isLotuta()) {
                        valido = true;
                        currentPath.reset();
                        currentPath.moveTo(startX, startY);
                        currentPath.lineTo(finishX, finishY);
                        arrain_bikote = arrainak.get(i).getBikote();
                        index_arrain = i;
                    }
                }
                if(valido) {
                    for (int i = 0; i < latak.size() && !dentro; i++) {


                        if (finishX >= latak.get(i).getX() && finishX <= (latak.get(i).getX() + latak.get(i).getWidth()) && finishY >= (latak.get(i).getY() - (latak.get(i).getHeight() * 2)) && finishY <= (latak.get(i).getHeight() + latak.get(i).getY()) && !latak.get(i).isLotuta()) {
                            dentro = true;
                            currentPath.reset();
                            currentPath.moveTo(startX, startY);
                            currentPath.lineTo(finishX, finishY);
                            lata_bikote = latak.get(i).getBikote();
                            index_lata = i;
                        }
                    }

                    if (!dentro) {
                        try {
                            this.paths.remove(paths.size() - 1);
                        }catch (Exception e){
                        }
                    }else if(dentro && arrain_bikote!=lata_bikote){
                        try {
                            this.paths.remove(paths.size() - 1);
                            this.img_correcto.setImageResource(R.drawable.cruz);
                            EsperaImagen espera = new EsperaImagen(this.img_correcto);
                            this.img_correcto.setVisibility(View.VISIBLE);
                        }catch(Exception e){

                        }
                    }else{
                        try{
                            arrainak.get(index_arrain).setLotuta(true);
                            latak.get(index_lata).setLotuta(true);
                            this.img_correcto.setImageResource(R.drawable.tick);
                            EsperaImagen espera = new EsperaImagen(this.img_correcto);
                            this.img_correcto.setVisibility(View.VISIBLE);
                        }catch(Exception e){
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

    public void limpiarDibujo() {
        paths.clear();
        invalidate();
    }

    public void onTouchEvent(int actionDown, Button btnPrueba) {
    }

    public List<Argazki> getArrainak() {
        return arrainak;
    }

    public void setArrainak(List<Argazki> arrainak) {
        this.arrainak = arrainak;
    }

    public List<Argazki> getLatak() {
        return latak;
    }

    public void setLatak(List<Argazki> latak) {
        this.latak = latak;
    }

    public ImageView getImg_correcto() {
        return img_correcto;
    }

    public void setImg_correcto(ImageView img_correcto) {
        this.img_correcto = img_correcto;
    }
}