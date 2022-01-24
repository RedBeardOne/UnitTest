import java.util.*;
import java.util.regex.Pattern;

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

    public static String formatDuration(int seconds) {
        String res = "";
        int[] units = new int[] {31536000, 86400, 3600, 60, 1};
        String[] labels = new String[] {"year", "day", "hour", "minute", "second"};

        if (seconds == 0) return "now";

        for (int i = 0; i < 5; i++) {
            if (seconds >= units[i]) {
                int q = seconds / units[i];
                seconds = seconds % units[i];
                res += (res.equals("") ? "" : (seconds == 0 ? " and " : ", "))
                        + q + " " + labels[i] + (q > 1 ? "s" : "");
            }
        }
        return res;
    }

    private static boolean isNumber(String s) {
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(s).matches();
    }
}
