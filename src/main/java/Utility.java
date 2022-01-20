import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Utility {
    public static boolean divisibleByThree(String number) {
        String[] split = number.split("");
        int result = Arrays.stream(split)
                .filter(Utility::isNumber)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(-1);
        return result % 3 == 0;
    }

    public static String encryptThis(String text) {
        String[] array = text.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > 0) {
                int chare = array[i].charAt(0);
                builder.append(array[i]);
                builder.deleteCharAt(0);
                String first = "";
                String last = "";
                if (builder.length() > 0) {
                    first = String.valueOf(builder.charAt(0));
                    builder.deleteCharAt(0);
                    if (builder.length() > 0) {
                        last = String.valueOf(builder.charAt(builder.length() - 1));
                        builder.deleteCharAt(builder.length() - 1);
                    }
                }
                array[i] = String.valueOf(new StringBuilder().append(chare).append(last).append(builder).append(first));
                builder.delete(0, builder.length());
            }
        }
        for (String s : array) {
            builder.append(String.format("%s ", s));
        }
        return builder.toString().trim();
    }

    private static boolean isNumber(String s) {
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(s).matches();
    }
}
