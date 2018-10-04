/**
 * Ativ Aggarwal
 * aaggar9
 */
import java.util.Scanner;

public class ScannerFactory {
    static Scanner keyboardScanner;

    static Scanner getKeyboardScanner() {
        if (keyboardScanner == null)
            keyboardScanner = new Scanner(System.in);
        return keyboardScanner;
    }
}
