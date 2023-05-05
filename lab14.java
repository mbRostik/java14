import java.util.*;
import java.io.*;

public class lab14 {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Potriben parametr vukluka: name faila");
      return;
    }
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(args[0]));
      String line = reader.readLine();
      while (line != null) {
        System.out.println("Vvedenui riadok: " + line);
        StringTokenizer tokenizer = new StringTokenizer(line);
        System.out.print("Riadok skladaietsia z: ");
        while (tokenizer.hasMoreTokens()) {
          String token = tokenizer.nextToken();
          try {
            double num = Double.parseDouble(token);
            System.out.print(num + " - ce 4islo  = " + num + ".0");
          } catch (NumberFormatException e) {
            System.out.print(token);
          }
          if (tokenizer.hasMoreTokens()) {
            System.out.print(", ");
          }
        }
        System.out.println();
        line = reader.readLine();
      }
    } catch (FileNotFoundException e) {
      System.out.println("File ne znaideno");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
