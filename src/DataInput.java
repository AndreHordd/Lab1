import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {
    /**
     * Приймає введення з консолі та повертає його у вигляді Long
     */
    public static Long getLong() throws IOException{
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }

    /**
     * Приймає введення з консолі та повертає його у вигляді Float
     */
    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    /**
     * Приймає введення з консолі та повертає його у вигляді Integer
     */
    public static Integer getInt() {
        while (true) {
            try {
                String s = getString();
                return Integer.valueOf(s);
            } catch (NumberFormatException e) {
                System.out.println("Некоректне число.\nБудь ласка, спробуйте ще раз:");
            } catch (IOException e) {
                System.out.println("Помилка вводу.\nБудь ласка, спробуйте ще раз:");
            }
        }
    }

    /**
     * Приймає введення з консолі та повертає його у вигляді String
     */
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    /**
     * Приймає введення з консолі та повертає його у вигляді Double
     */
    public static Double getDouble() {
        while (true) {
            try {
                String s = getString();
                return Double.valueOf(s);
            } catch (NumberFormatException e) {
                System.out.println("Некоректне число.\nБудь ласка, спробуйте ще раз:");
            } catch (IOException e) {
                System.out.println("Помилка вводу.\nБудь ласка, спробуйте ще раз:");
            }
        }
    }


}