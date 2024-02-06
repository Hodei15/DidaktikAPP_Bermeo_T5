package com.example.didaktikapp.Model;

import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class Argazkiak_Ontziak {
    protected int imgCarta;
    protected int itsasontzia;
    protected ImageView erakutsi;
    protected int bikote;
    float width;
    float height;
    int x;
    int y;
    boolean lotuta;
    boolean gorantz;
    private ViewTreeObserver viewTreeObserver;

    public Argazkiak_Ontziak(){
    }

    public Argazkiak_Ontziak(int imgCarta,int itsasontzia,ImageView erakutsi, int bikote, float height, float width,int x, int y){
        this.imgCarta=imgCarta;
        this.itsasontzia=itsasontzia;
        this.erakutsi=erakutsi;
        this.bikote=bikote;
        this.height=height;
        this.width=width;
        this.x = x;
        this.y = y;
        this.lotuta = false;
        this.gorantz = false;
    }

    public int getImgCarta() {
        return imgCarta;
    }
    public void setImg(int imgCarta) {
        this.imgCarta = imgCarta;
    }
    public int getItsasontzia() {
        return itsasontzia;
    }
    public void setItsasontzia(int itsasontzia) {
        this.itsasontzia = itsasontzia;
    }

    public int getBikote() {
        return bikote;
    }

    public void setBikote(int bikote) {
        this.bikote = bikote;
    }

    public ViewTreeObserver getViewTreeObserver() {
        return viewTreeObserver;
    }

    public void setImgCarta(int imgCarta) {
        this.imgCarta = imgCarta;
    }

    public ImageView getErakutsi() {
        return erakutsi;
    }

    public void setErakutsi(ImageView erakutsi) {
        this.erakutsi = erakutsi;
    }

    public void setViewTreeObserver(ViewTreeObserver viewTreeObserver) {
        this.viewTreeObserver = viewTreeObserver;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLotuta() {
        return lotuta;
    }

    public void setLotuta(boolean lotuta) {
        this.lotuta = lotuta;
    }

    public boolean isGorantz() {
        return gorantz;
    }

    public void setGorantz(boolean gorantz) {
        this.gorantz = gorantz;
    }
}
