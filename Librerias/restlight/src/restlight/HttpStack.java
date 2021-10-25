package restlight;

import java.io.IOException;

public interface HttpStack {

  /**
   * Ejecuta una petición.
   *
   * @param request petición a ejecutar
   *
   * @return el resultado de la petición realizada
   *
   * @throws java.lang.Exception
   */
  public ResponseBody execute(Request request) throws IOException;
}