package restlight;

public class StringRequest extends Request.Parse<String> {

  public StringRequest() {
    super();
  }

  public StringRequest(String method, String url) {
    super(method, url);
  }

  public StringRequest(String method, String url, RequestBody body) {
    super(method, url, body);
  }
    
  @Override
  public String parseResponse(ResponseBody response) throws Exception {
   return response.string(getCharset());
  }
}
