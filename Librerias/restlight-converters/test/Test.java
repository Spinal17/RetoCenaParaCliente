import restlight.MultipartBody;
import restlight.org.json.JSON;
import restlight.request.JsonRequest;

public class Test {   
  
  public static void main(String[] args) throws Exception { 
    MultipartBody body = new MultipartBody();
    body.addParam("first", "Jesus");
    body.addParam("last", "Bx"); 
    body.addFile("archivo", new byte[]{'H', 'O', 'L', 'A', ' ', 'M', 'U', 'N', 'D', 'O'}, "texto.txt");
    
    JsonRequest request = new JsonRequest(
            "POST", "http://127.0.0.1/test.php", body);
    
    JSON json = request.executeResult();
    System.out.println(json.toString(1));
  }
}
