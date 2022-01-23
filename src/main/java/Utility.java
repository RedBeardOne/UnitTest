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
        List<String> collect = new ArrayList<>();
        String rez = "";
        StringBuilder builder = new StringBuilder(rez);
        int temp = 0;
        if (seconds >= 0) {
            int year = seconds / 31_536_000;
            temp = seconds % 31_536_000;

            int day = temp / 86_400;
            temp = temp % 86_400;

            int hours = temp / 3600;
            temp = temp % 3600;

            int minutes = temp / 60;
            temp = temp % 60;

            if (year > 0 && year < 3) {
                collect.add(String.format("%d year", year));
            }
            if (year >= 3) {
                collect.add(String.format("%d years", year));
            }
            if (day == 1) {
                collect.add(String.format("%d day", day));
            }
            if (day > 1) {
                collect.add(String.format("%d days", day));
            }
            if (hours == 1) {
                collect.add(String.format("%d hour", hours));
            }
            if (hours > 1) {
                collect.add(String.format("%d hours", hours));
            }
            if (minutes == 1) {
                collect.add(String.format("%d minute", minutes));
            }
            if (minutes > 1) {
                collect.add(String.format("%d minutes", minutes));
            }
            if (temp == 1) {
                collect.add(String.format("%d second", temp));
            }
            if (temp > 1) {
                collect.add(String.format("%d seconds", temp));
            }
            int size = collect.size();
            ListIterator<String> iter = collect.listIterator();
            while (iter.hasNext()) {
                builder.append(iter.next());
                if (iter.hasNext() && iter.nextIndex() + 1 != size) {
                    builder.append(", ");
                } else if (iter.hasNext()) {
                    builder.append(" and ");
                }
            }
        }
        return builder.toString();
    }

    private static boolean isNumber(String s) {
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(s).matches();
    }
}
