
import org.json.JSONObject;
import restlight.Call;
import restlight.FormBody;
import restlight.org.json.JSON;
import restlight.request.JsonRequest;

/**
 *
 * @author jesus
 */
public class JsonTest {
    
    public Call<JSON> insert(
        String nombre, int edad, boolean soltera) {
      
        FormBody body = new FormBody()
            .add("nombre", nombre)
            .add("edad", edad)
            .add("soltera", soltera);

        JsonRequest request = new JsonRequest(
                "POST", "http://127.0.0.1/test.php", body);
        
        return request.newCall();
    }
    
    public void run() {
        Call<JSON> insert = insert(
                "Elizabéth Magaña", 22, true);
        
        try {
            JSON result = insert.execute();
            JSONObject json = result.getObject();
            System.out.println(json.toString(1));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new JsonTest().run();
    }
}
