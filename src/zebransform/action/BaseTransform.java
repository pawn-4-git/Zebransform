/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zebransform.action;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import zebransform.setting.RGB;
import zebransform.setting.ZebransformSetting;

/**
 *
 * @author Pawn
 */
public abstract class BaseTransform {
    
    private ZebransformSetting zebransformSetting;
    
    private String sourcePath,convertPath;
    
    
    public void transform(String sourcePath,String convertPath) throws IOException{
        this.setZebransformSetting(new ZebransformSetting());
        this.getZebransformSetting().setBeforeImage(sourcePath);
        this.getZebransformSetting().setAfterImage(sourcePath);
        this.getZebransformSetting().setSidewayFlg(true);
        this.sourcePath=sourcePath;
        this.convertPath=convertPath;
        transform();
    }
    
    public void transform(String sourcePath,String convertPath,int border) throws IOException{
        this.setZebransformSetting(new ZebransformSetting());
        this.getZebransformSetting().setBeforeImage(sourcePath);
        this.getZebransformSetting().setAfterImage(sourcePath);
        this.getZebransformSetting().setSidewayFlg(true);
        this.getZebransformSetting().setBorderWidth(border);
        this.sourcePath=sourcePath;
        this.convertPath=convertPath;
        transform();
    }
    
    public abstract void transform();
    
    public boolean checkBlack(int x,int y){
        if(isWhile(x, y)){
            return false;
        }
        
        int valuer=0,valueg=0,valueb=0;
        
        int linen=0;
        
        RGB rgb=convertRGB(x, y);
        rgb.setRGB(this.getZebransformSetting().getBeforeImage().getRGB(x, y));
        
        double value=Math.sqrt(rgb.getR()*rgb.getR()+rgb.getG()*rgb.getG()+rgb.getB()*rgb.getB());
        
        //境界値よりも値が大きい場合白と判断する
        if(this.getZebransformSetting().getBoundaryValue()<value){
            return false;
        }
        
        return true;
    }
    
    public abstract RGB convertRGB(int x,int y);
    

    /**
     * 必ず白になる領域の判定
     * @param x
     * @param y
     * @return 
     */
    public abstract boolean isWhile(int x,int y);

    /**
     * @return the zebransformSetting
     */
    public ZebransformSetting getZebransformSetting() {
        return zebransformSetting;
    }

    /**
     * @param zebransformSetting the zebransformSetting to set
     */
    public void setZebransformSetting(ZebransformSetting zebransformSetting) {
        this.zebransformSetting = zebransformSetting;
    }
    
    public void imageSave(){
        try {
            ImageIO.write(this.zebransformSetting.getAfterImage(),"jpg",new File(convertPath));
        } catch (IOException ex) {
            Logger.getLogger(BaseTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the sourcePath
     */
    public String getSourcePath() {
        return sourcePath;
    }

    /**
     * @param sourcePath the sourcePath to set
     */
    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    /**
     * @return the convertPath
     */
    public String getConvertPath() {
        return convertPath;
    }

    /**
     * @param convertPath the convertPath to set
     */
    public void setConvertPath(String convertPath) {
        this.convertPath = convertPath;
    }
    
    
    
}
