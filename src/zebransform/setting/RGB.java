/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zebransform.setting;

/**
 *
 * @author Pawn
 */
public class RGB {
    
    private int a;
    private int r;
    private int g;
    private int b;

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * @return the r
     */
    public int getR() {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * @return the g
     */
    public int getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }
    
    public void setRGB(int rgb){
        this.a=(rgb>>>24)&0xff;
        this.r=(rgb>>>16)&0xff;
        this.g=(rgb>>>8)&0xff;
        this.b=rgb&0xff;
    }
    
    public int getRGB(){
        return a<<24|r<<16|g<<8|b;
    }
    
    
    
}
