package utils;

public class utils {
    private static String[] wft = new String[] { "ja", "true", "j", "y" };
    private static String[] wff = new String[] { "falsch", "false", "nein", "n" };

    public static Boolean trueOrfalse(String in) {

        boolean found = false;
        for (String string : wff) {
            found = found || string.equalsIgnoreCase(in);
        }
        if (found) {
            return false;
        }

        for (String string : wft) {
            found = found || string.equalsIgnoreCase(in);
        }
        if (found) {
            return true;
        }

        return null;

    }

}
