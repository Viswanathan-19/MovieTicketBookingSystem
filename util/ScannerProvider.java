package util;

import java.util.Scanner;

public class ScannerProvider {
    
      private static final Scanner sc=new Scanner(System.in);
      
      private ScannerProvider(){}

      public static Scanner getScanner(){ return sc;}

}
