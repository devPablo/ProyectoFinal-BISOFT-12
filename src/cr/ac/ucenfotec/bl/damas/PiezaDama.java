package cr.ac.ucenfotec.bl.damas;

import cr.ac.ucenfotec.bl.piezas.ColorPieza;
import cr.ac.ucenfotec.bl.piezas.IPieza;

public class PiezaDama implements IPieza {
    int posX;
    int posY;
    boolean color;
    IPieza mejora;
    public PiezaDama() {
    }

    public PiezaDama(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public PiezaDama(int posX, int posY, ColorPieza color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color.valueOf();
        this.mejora = null;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    public boolean validarMovimiento(int posX, int posY, int posXFinal, int posYFinal) {

        if(this.mejora != null) {
           //Movimiento mejorado
        }

        return false;
    }

    public void mejorar(IPieza mitipoPieza){
        this.mejora = mitipoPieza;
    }

}
