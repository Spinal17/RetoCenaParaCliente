/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import restlight.Request;
import restlight.ResponseBody;
import static Utils.Constant.STR_EMPTY;
import static Utils.Constant.STR_GET;
import static Utils.Constant.STR_QUOTATION_MARKS;
import static Utils.Constant.STR_URL_WEB_SERVICE;


/**
 *
 * @author SANTIAGO ESPINAL
 */
public class Decrypt {
    
   public static String code(String strCode) throws Exception {
    Request request = new Request(
            STR_GET, STR_URL_WEB_SERVICE + strCode);

    try (ResponseBody response = request.execute()) {
      return (response.string(request.getCharset())).replace(STR_QUOTATION_MARKS, STR_EMPTY);
    }
  }

  
}