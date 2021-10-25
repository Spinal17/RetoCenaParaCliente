package restlight.request;

import org.json.JSONArray;
import org.json.JSONObject;
import restlight.Request;
import restlight.RequestBody;
import restlight.ResponseBody;
import restlight.org.json.JSON;

public class JsonRequest extends Request.Parse<JSON> {
  
  public JsonRequest() {
    super();
  }

  public JsonRequest(String method, String url) {
    super(method, url);
  }

  public JsonRequest(String method, String url, RequestBody body) {
    super(method, url, body);
  }  
    
  public static class Object extends Request.Parse<JSONObject> {
    @Override
    public JSONObject parseResponse(ResponseBody response) throws Exception {
      String json = response.string(getCharset());
      return new JSONObject(json);
    }
  }
  
  public static class Array extends Request.Parse<JSONArray> {
    @Override
    public JSONArray parseResponse(ResponseBody response) throws Exception {
      String json = response.string(getCharset());
      return new JSONArray(json);
    }
  }
  
  @Override
  public JSON parseResponse(ResponseBody response) throws Exception {
    String json = response.string(getCharset());
    return JSON.of(json);
  }
}
