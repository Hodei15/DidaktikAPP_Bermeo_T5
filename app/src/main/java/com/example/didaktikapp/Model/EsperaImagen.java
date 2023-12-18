package com.example.didaktikapp.Model;

import android.view.View;
import android.widget.ImageView;

public class EsperaImagen implements Runnable{

    private ImageView img;
    public EsperaImagen(ImageView img){
        this.img = img;
        Thread t = new Thread(this);
        t.setPriority(5);
        t.start();
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
            this.img.setVisibility(View.INVISIBLE);
        }catch (Exception e){
        }
    }
}
