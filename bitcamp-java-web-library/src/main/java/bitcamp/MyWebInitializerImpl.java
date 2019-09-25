package bitcamp;

import javax.servlet.ServletContext;

public class MyWebInitializerImpl implements MyWebInitializer {
  
  @Override
  public void start(ServletContext ctx) {
    System.out.println("MyWebInitializerImpl.. ok!");

  }
}
