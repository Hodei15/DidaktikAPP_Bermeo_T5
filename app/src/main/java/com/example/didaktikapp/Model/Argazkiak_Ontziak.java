package com.example.didaktikapp.Model;

import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class Argazkiak_Ontziak {
    protected ImageView imgCarta;
    protected ImageView itsasontzia;
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

    public Argazkiak_Ontziak(ImageView imgCarta,ImageView itsasontzia,ImageView erakutsi, int bikote, float height, float width,int x, int y){
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

    public ImageView getImgCarta() {
        return imgCarta;
    }
    public void setImg(ImageView imgCarta) {
        this.imgCarta = imgCarta;
    }
    public ImageView getItsasontzia() {
        return itsasontzia;
    }
    public void setItsasontzia(ImageView itsasontzia) {
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

    public void setImgCarta(ImageView imgCarta) {
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
        return lotuta;
    }

    public void setGorantz(boolean gorantz) {
        this.lotuta = lotuta;
    }
}
