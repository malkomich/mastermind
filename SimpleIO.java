import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleIO
{
  static InputStreamReader r_in;
  static BufferedReader br_in;

  static
  {
    r_in = new InputStreamReader (System.in);
    br_in = new BufferedReader (r_in);
  }

  public static void println (String str)
  {
    System.out.println (str);
  }

  public static void print (String str)
  {
    System.out.print (str);
  }

  public static String readLine ()
  {
    String s;

    try {
      s = br_in.readLine ();
    } catch (java.io.IOException ex) {
      System.out.println ("IO Error! " + ex);
      s = null;
    }

    return s;
  }

  public static char readChar ()
  {
    String s;

    s = readLine ();
    if (s == null)
      return 0;
    else if (s.length () > 0)
      return s.charAt (0);
    else
      return '\n';
  }

}