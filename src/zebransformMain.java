
import java.io.IOException;
import zebransform.action.ZebransformSideway;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pawn
 */
public class zebransformMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        if("1".equals(args[0])){
            if(args.length==3){
                ZebransformSideway converter=new ZebransformSideway();
                converter.transform(args[1],args[2]);
            }
            else if(args.length==4){
                ZebransformSideway converter=new ZebransformSideway();
                converter.transform(args[1],args[2],new Integer(args[3]));
            }
        }
    }
    
}
