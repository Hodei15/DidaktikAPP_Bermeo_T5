package com.example.didaktikapp.Model;

import android.view.View;
import android.widget.ImageView;

public class EsperaOntziak implements Runnable{

    private Argazkiak_Ontziak argazki;
    public EsperaOntziak(Argazkiak_Ontziak argazki){
        this.argazki = argazki;
        Thread t = new Thread(this);
        t.setPriority(5);
        t.start();
    }

    public Argazkiak_Ontziak getArgazki() {
        return argazki;
    }

    public void setArgazki(Argazkiak_Ontziak argazki) {
        this.argazki = argazki;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
            argazki.getErakutsi().setImageResource(argazki.getImgCarta());
        }catch (Exception e){
        }
    }
}
