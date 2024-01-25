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
    private Paint paint = new Paint();
    private List<Path> paths = new ArrayList<>();
    private Path currentPath;
    private float startX, startY;
    private List<Argazki> gorputza;
    private List<Argazki> gorputzaOndo;
    private ImageView img_correcto;

    public ZatiTxo(Context context, AttributeSet attrs) {
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
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                // Guardar la posición inicial al tocar la imagen
                startX = finishX;
                startY = finishY;
                for(int i=0;i<gorputza.size() && !valido;i++) {
                    boolean a = startX >= gorputza.get(i).getX();
                    boolean b = startX <= (gorputza.get(i).getX() + gorputza.get(i).getWidth());
                    boolean c1 = startY >= gorputza.get(i).getY() - gorputza.get(i).getHeight();
                    boolean c2 = startY >= (gorputza.get(i).getY() - (gorputza.get(i).getHeight() * 2));
                    boolean d = startY <= (gorputza.get(i).getHeight() + gorputza.get(i).getY());
                    boolean e = !gorputza.get(i).isLotuta();
                    if (startX >= gorputza.get(i).getX() && startX <= (gorputza.get(i).getX() + gorputza.get(i).getWidth()) && startY >= (gorputza.get(i).getY() - (gorputza.get(i).getHeight() * 2)) && startY <= (gorputza.get(i).getHeight() + gorputza.get(i).getY()) && !gorputza.get(i).isLotuta()) {
                        valido = true;
                        currentPath = new Path();
                        paths.add(currentPath);
                        currentPath.moveTo(finishX, finishY);
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                for(int i=0;i<gorputza.size() && !valido;i++) {
                    if (startX >= gorputza.get(i).getX() && startX <= (gorputza.get(i).getX() + gorputza.get(i).getWidth()) && startY >= (gorputza.get(i).getY() - (gorputza.get(i).getHeight() * 2)) && startY <= (gorputza.get(i).getHeight() + gorputza.get(i).getY()) && !gorputza.get(i).isLotuta()) {
                        valido = true;
                        currentPath.reset();
                        currentPath.moveTo(startX, startY);
                        currentPath.lineTo(finishX, finishY);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                boolean dentro = false;
                int gorputza_bikote=-1;
                int gorputzaOndo_bikote=-1;
                int index_gorputza=-1;
                int index_gorputzaOndo=-1;
                for(int i=0;i<gorputza.size() && !valido;i++){
                    if (startX >= gorputza.get(i).getX() && startX <= (gorputza.get(i).getX() + gorputza.get(i).getWidth()) && startY >= (gorputza.get(i).getY() - (gorputza.get(i).getHeight() * 2)) && startY <= (gorputza.get(i).getHeight() + gorputza.get(i).getY()) && !gorputza.get(i).isLotuta()) {
                        valido = true;
                        currentPath.reset();
                        currentPath.moveTo(startX, startY);
                        currentPath.lineTo(finishX, finishY);
                        gorputza_bikote = gorputza.get(i).getBikote();
                        index_gorputza = i;
                    }
                }
                if(valido) {
                    for (int i = 0; i < gorputzaOndo.size() && !dentro; i++) {


                        if (finishX >= gorputzaOndo.get(i).getX() && finishX <= (gorputzaOndo.get(i).getX() + gorputzaOndo.get(i).getWidth()) && finishY >= (gorputzaOndo.get(i).getY() - (gorputzaOndo.get(i).getHeight() * 2)) && finishY <= (gorputzaOndo.get(i).getHeight() + gorputzaOndo.get(i).getY()) && !gorputzaOndo.get(i).isLotuta()) {
                            dentro = true;
                            currentPath.reset();
                            currentPath.moveTo(startX, startY);
                            currentPath.lineTo(finishX, finishY);
                            gorputzaOndo_bikote = gorputzaOndo.get(i).getBikote();
                            index_gorputzaOndo = i;
                        }
                    }
                    if (!dentro) {
                        try {
                            this.paths.remove(paths.size() - 1);
                        } catch (Exception e) {
                        }
                    } else if (dentro && gorputza_bikote != gorputzaOndo_bikote) {
                        try {
                            this.paths.remove(paths.size() - 1);
                            this.img_correcto.setImageResource(R.drawable.cruz);
                            EsperaImagen espera = new EsperaImagen(this.img_correcto);
                            this.img_correcto.setVisibility(View.VISIBLE);
                        } catch (Exception e) {

                        }
                    } else {
                        try {
                            gorputza.get(index_gorputza).setLotuta(true);
                            gorputzaOndo.get(index_gorputzaOndo).setLotuta(true);
                            this.img_correcto.setImageResource(R.drawable.tick);
                            EsperaImagen espera = new EsperaImagen(this.img_correcto);
                            this.img_correcto.setVisibility(View.VISIBLE);
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



    public void limpiarDibujo() {
        paths.clear();
        invalidate();
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
