package ch27.b;

public class Test {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = C.class;
    Class<?> superClass = clazz.getSuperclass();
    System.out.println(superClass.getName());
    
    superClassName(clazz);

  }

  private static void superClassName(Class<?> clazz) {
    
    System.out.println(clazz.getName());
    if (clazz == Object.class) 
      return;
    superClassName(clazz.getSuperclass());
  }

}

