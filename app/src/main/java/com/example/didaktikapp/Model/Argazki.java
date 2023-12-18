package com.example.didaktikapp.Model;

import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class Argazki {

    protected ImageView img;
    protected int bikote;
    float width;
    float height;
    int x;
    int y;
    boolean lotuta;
    private ViewTreeObserver viewTreeObserver;

    public Argazki(){
    }

    public Argazki(ImageView img, int bikote, float height, float width,int x, int y){
        this.img=img;
        this.bikote=bikote;
        this.height=height;
        this.width=width;
        this.x = x;
        this.y = y;
        this.lotuta = false;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
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
}
