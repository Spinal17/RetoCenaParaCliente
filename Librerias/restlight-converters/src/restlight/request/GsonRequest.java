package restlight.request;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.Reader;
import restlight.Request;
import restlight.ResponseBody;

public class GsonRequest<T> extends Request.Parse<T> {

  private static Gson defaultGson = new Gson();
    
  private final Gson gson;
  final TypeAdapter<T> adapter;

  /**
   * Make a request and return a parsed object from JSON.
   *
   * @param gson
   * @param adapter Relevant class object, for Gson's reflection
   */
  public GsonRequest(Gson gson, TypeAdapter<T> adapter) {
    this.gson = gson;
    this.adapter = adapter;
  }
  
  public static <V> GsonRequest<V> of(Gson gson, Class<V> classOf) {
    return new GsonRequest<V>(gson, gson.getAdapter(classOf));
  }
  public static <V> GsonRequest<V> of(Class<V> classOf) {
    return of(defaultGson, classOf);
  }
  
  public static <V> GsonRequest<V> of(Gson gson, TypeToken<V> type) {
    return new GsonRequest<V>(gson, gson.getAdapter(type));
  }
  public static <V> GsonRequest<V> of(TypeToken<V> type) {
    return of(defaultGson, type);
  }

  public static Gson getDefaultGson() {
    return defaultGson;
  }
  public static void setDefaultGson(Gson defaultGson) {
    GsonRequest.defaultGson = defaultGson;
  }

  public final TypeAdapter<T> getAdapter() {
    return adapter;
  }

  public Gson getGson() {
    return gson;
  }

  @Override public T parseResponse(ResponseBody response) throws Exception {
    Reader json = response.charStream(getCharset());
    //String json = response.string(getCharset());
    JsonReader reader = gson.newJsonReader(json);
    return adapter.read(reader);
  }
}