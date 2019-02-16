/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zebransform.setting;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Pawn
 */
public class ZebransformSetting {
    
    private BufferedImage beforeImage;
    
    private BufferedImage afterImage;
    
    private int borderWidth=1;
    
    private boolean firstLineColrBlackFlg=true;
    
    private boolean sidewayFlg=true;
    
    private double boundaryValue=126;

    /**
     * @return the beforeImage
     */
    public BufferedImage getBeforeImage() {
        return beforeImage;
    }

    /**
     * @param beforeImage the beforeImage to set
     */
    public void setBeforeImage(BufferedImage beforeImage) {
        this.beforeImage = beforeImage;
    }
    
    public void setBeforeImage(String path) throws IOException{
        this.beforeImage=ImageIO.read(new File(path));
    }

    /**
     * @return the afterImage
     */
    public BufferedImage getAfterImage() {
        return afterImage;
    }

    /**
     * @param afterImage the afterImage to set
     */
    public void setAfterImage(BufferedImage afterImage) {
        this.afterImage = afterImage;
    }
    
    public void setAfterImage(String path) throws IOException{
        this.afterImage=ImageIO.read(new File(path));
    }


    /**
     * @return the borderWidth
     */
    public int getBorderWidth() {
        return borderWidth;
    }

    /**
     * @param borderWidth the borderWidth to set
     */
    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    /**
     * @return the sidewayFlg
     */
    public boolean isSidewayFlg() {
        return sidewayFlg;
    }

    /**
     * @param sidewayFlg the sidewayFlg to set
     */
    public void setSidewayFlg(boolean sidewayFlg) {
        this.sidewayFlg = sidewayFlg;
    }

    /**
     * @return the boundaryValue
     */
    public double getBoundaryValue() {
        return boundaryValue;
    }

    /**
     * @param boundaryValue the boundaryValue to set
     */
    public void setBoundaryValue(double boundaryValue) {
        this.boundaryValue = boundaryValue;
    }

    /**
     * @return the firstLineColrBlackFlg
     */
    public boolean isFirstLineColrBlackFlg() {
        return firstLineColrBlackFlg;
    }

    /**
     * @param firstLineColrBlackFlg the firstLineColrBlackFlg to set
     */
    public void setFirstLineColrBlackFlg(boolean firstLineColrBlackFlg) {
        this.firstLineColrBlackFlg = firstLineColrBlackFlg;
    }
    
    

   
    
    
    
}
