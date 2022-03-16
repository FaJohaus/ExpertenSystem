package utils;

public class utils {
    private static String[] wft = new String[] { "ja", "true" };
    private static String[] wff = new String[] { "falsch", "false" };

    public static Boolean trueOrfalse(String in) {

        boolean found = false;
        for (String string : wff) {
            found = string.equals(in);
        }
        if (found) {
            return false;
        }

        for (String string : wft) {
            found = string.equals(in);
        }
        if (found) {
            return true;
        }

        return null;

    }

}
