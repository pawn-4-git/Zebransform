/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zebransform.action;

import java.nio.charset.Charset;
import zebransform.setting.RGB;
import zebransform.setting.RGBBlack;
import zebransform.setting.RGBWhite;

/**
 *
 * @author Pawn
 */
public class ZebransformSideway extends BaseTransform{

    @Override
    public void transform() {
        
        RGB rgbWhite=new RGBWhite();
        RGB rgbBlack=new RGBBlack();
        
        for(int x=0;x<this.getZebransformSetting().getBeforeImage().getWidth();x++){
            for(int y=0;y<this.getZebransformSetting().getBeforeImage().getHeight();y++){
                if(!checkBlack(x, y)){
                    this.getZebransformSetting().getAfterImage().setRGB(x, y,rgbWhite.getRGB());
                }else{
                    this.getZebransformSetting().getAfterImage().setRGB(x, y,rgbBlack.getRGB());
                }
            }

        }
        imageSave();
    
    }

    @Override
    public boolean isWhile(int x, int y) {
        //横向きの縞模様なのでx軸方向の値は関係ない
        int borderWidth=this.getZebransformSetting().getBorderWidth();
        boolean firstLineBlack=this.getZebransformSetting().isFirstLineColrBlackFlg();
        
        int value=y/borderWidth;
        if(firstLineBlack&&(value%2==0)||!firstLineBlack&&(value%2!=0)){
            return false;
        }
        return true;
    }

    @Override
    public RGB convertRGB(int x, int y) {

        try{
            int valuer=0,valueg=0,valueb=0,valuea=0;

            int count=0;
            RGB averageRgb=new RGB();

            int countx=x/this.getZebransformSetting().getBorderWidth();
            int county=y/this.getZebransformSetting().getBorderWidth();

            for(int i=countx*this.getZebransformSetting().getBorderWidth();i<((countx+1)*this.getZebransformSetting().getBorderWidth())&&i<this.getZebransformSetting().getBeforeImage().getWidth();i++){
                for(int j=county*this.getZebransformSetting().getBorderWidth();j<((county+1)*this.getZebransformSetting().getBorderWidth())&&j<this.getZebransformSetting().getBeforeImage().getHeight();j++){
                    RGB rgb=new RGB();
                    rgb.setRGB(this.getZebransformSetting().getBeforeImage().getRGB(i, j));
                    valuer=valuer+rgb.getR();
                    valueg=valueg+rgb.getG();
                    valueb=valueb+rgb.getB();
                    valuea=valuea+rgb.getA();
                    count++;
                }
            }
            averageRgb.setA(valuea/count);
            averageRgb.setR(valuer/count);
            averageRgb.setG(valueg/count);
            averageRgb.setB(valueb/count);
            return averageRgb;
        }
        catch(Exception e){
            return null;
        }
    }

   
}
