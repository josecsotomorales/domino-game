/*
 *@author: Jose Carlos Soto
 */
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Ficha {
    private int sum;
    private char orient;
    private Media media;
    private  boolean activa;
    private int v1,  v2,  px,  py;
    private Image imf, backV;

    
    public Ficha(int v1, int v2) {
        activa = true;
        this.v1 = v1;
        this.v2 = v2;
        media = new Media();
        imf = media.cIcon("fichas/" + v1 + "-" + v2 + ".png").getImage();
        backV = media.cIcon("fichas/backV.png").getImage();
    }

    public int getSum() {
        sum=v1 + v2;
        return sum;
    }

    public void setOrient(char orient) {
        this.orient = orient;
    }

    public char getOrient() {
        return orient;
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

    public char nextOrienI() {
        char c = 'q';
        switch (orient) {
            case 'a':
                c = 'r';
                break;
            case 'r':
                c = 'a';
                break;
            case 'v':
                c = 'h';
                break;
            case 'h':
                c = 'v';
                break;
            case 'e':
                c = 'n';
                break;
            case 'n':
                c = 'w';
                break;
            case 's':
                c = 'e';
                break;
            case 'w':
                c = 's';
                break;

        }
        return c;
    }

    public char nextOrienD() {
        char c = 'q';
        switch (orient) {
            case 'a':
                c = 'r';
                break;
            case 'r':
                c = 'a';
                break;
            case 'v':
                c = 'h';
                break;
            case 'h':
                c = 'v';
                break;
            case 'e':
                c = 's';
                break;
            case 'n':
                c = 'e';
                break;
            case 's':
                c = 'w';
                break;
            case 'w':
                c = 'n';
                break;

        }
        return c;
    }

    public AffineTransform getOrientG() {
        AffineTransform posW = new AffineTransform(
                Math.cos(Math.toRadians(90)), -Math.sin(Math.toRadians(90)),
                Math.sin(Math.toRadians(90)), Math.cos(Math.toRadians(90)),
                this.getPx(), this.getPy() + 30);
        AffineTransform posE = new AffineTransform(
                Math.cos(Math.toRadians(270)), -Math.sin(Math.toRadians(270)),
                Math.sin(Math.toRadians(270)), Math.cos(Math.toRadians(270)),
                this.getPx() + 60, this.getPy());
        AffineTransform posN = new AffineTransform(
                Math.cos(Math.toRadians(0)), -Math.sin(Math.toRadians(0)),
                Math.sin(Math.toRadians(0)), Math.cos(Math.toRadians(0)),
                this.getPx(), this.getPy());
        AffineTransform posS = new AffineTransform(
                Math.cos(Math.toRadians(180)), -Math.sin(Math.toRadians(180)),
                Math.sin(Math.toRadians(180)), Math.cos(Math.toRadians(180)),
                this.getPx() + 30, this.getPy() + 60);
        AffineTransform i;
        switch (orient) {
            case 'a':
                i = posN;
                break;
            case 'r':
                i = posE;
                break;
            case 'v':
                i = posN;
                break;
            case 'h':
                i = posE;
                break;
            case 'e':
                i = posE;
                break;
            case 'n':
                i = posN;
                break;
            case 's':
                i = posS;
                break;
            case 'w':
                i = posW;
                break;
            default:
                i = null;
        }
        return i;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    public void setPx(int x) {
        px = x;
    }

    public void setPy(int y) {
        py = y;
    }

    public boolean isDoble() {
        if (v1 == v2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esActiva() {
        return activa;
    }

    public void setActiva(boolean b) {
        activa = b;
    }

    public Image getImf() {
        if (orient == 'r' || orient == 'a') {
            return backV;
        } else {
            return imf;
        }
    }
public String toString(){
    return v1+"-"+v2;
}
}
