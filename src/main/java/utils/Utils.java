package utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.DataProvider;

public class Utils {

    public static void waitForSeconds(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static Dotenv dotEnv() {
        return Dotenv.configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }

    @DataProvider(name = "dpLogInTest")
    public static Object[][] dpLogInTest() {
        return new Object[][]{
                {"", ""},
                {"nekimail@mail.com", ""},
                {"", "123456789"},
                {"admin", "admin"},
                {"nekimail@mail.com", "123456789"}
        };
    }


}
