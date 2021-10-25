package restlight;

/**
 *
 * @author jesus
 */
public class HttpRequest extends Request.Parse<ResponseBody>{

  public HttpRequest() {
    super();
  }

  public HttpRequest(String method, String url) {
    super(method, url);
  }

  public HttpRequest(String method, String url, RequestBody body) {
    super(method, url, body);
  }
    
  @Override
  public ResponseBody parseResponse(ResponseBody response) throws Exception {
    return response;
  }

  @Override
  public ResponseBody doParse(ResponseBody response) throws Exception {
    return parseResponse(response);
  }

  @Override
  public void atTheEnd(ResponseBody result) {
    super.atTheEnd(result);
    result.close();
  }
}
