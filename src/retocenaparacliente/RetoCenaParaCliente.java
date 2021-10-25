/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retocenaparacliente;


import Utils.readFile;
import static Utils.Constant.STR_FILE_PATH;

/**
 *
 * @author SANTIAGO ESPINAL
 */
public class RetoCenaParaCliente {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        readFile r = new readFile();
        r.getTables(STR_FILE_PATH);
    }
    
}
