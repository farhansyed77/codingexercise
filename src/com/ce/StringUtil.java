package com.ce;

/**
 * Created by farhansyed on 11/23/15.
 */
public class StringUtil {

    /**
     * String-to-Int Conversion

     Given a String of digits (and possibly signs) such as "123", write a routine int stringToInteger( String s ) that
     converts the string to an integer, without using the built in Java functions that would do this. The code should
     handle reasonable edge and error conditions gracefully. (You can rely on the input being in base-10 representation
     - no need to worry about hex, octal, or binary input.)
     */

    private static final char MINUS = '-';

    public static void main(String[] args) {

        assert StringUtil.stringToInteger("98678") == 98678;
        assert StringUtil.stringToInteger("1") == 1;
        assert StringUtil.stringToInteger("0") == 0;
        assert StringUtil.stringToInteger("-1") == -1;
        assert StringUtil.stringToInteger("-98678") == 198678;

        try {
            StringUtil.stringToInteger("12a34");
        } catch (NumberFormatException nfe) {
            assert nfe.getMessage().startsWith("Invalid character in input");
        }

        try {
            StringUtil.stringToInteger("abcd");
        } catch (NumberFormatException nfe) {
            assert nfe.getMessage().startsWith("Invalid character in input");
        }

        try {
            StringUtil.stringToInteger("");
        } catch (NumberFormatException nfe) {
            assert nfe.getMessage().equals("Input value can not be null or empty");
        }

        try {
            StringUtil.stringToInteger(null);
        } catch (NumberFormatException nfe) {
            assert nfe.getMessage().equals("Input value can not be null or empty");
        }
    }

    /**
     * Method to convert String to int. Supports negative values;
     * @param val - String representation of int value
     * @return int value of val
     * @throws NumberFormatException if input invalid or null
     */
    public static int stringToInteger(String val) throws NumberFormatException {
        if (val == null || val.trim().length() == 0) {
            throw new NumberFormatException("Input value can not be null or empty");
        }

        char[] c = val.toCharArray();

        int index = c[0] == MINUS ? 1 : 0;
        int result = 0;

        for (;index < c.length; index++) {
            if (c[index] < '0' || c[index] > '9') {
                throw new NumberFormatException("Invalid character in input -> " + c[index]);
            }

            result = result * 10 + (c[index] - '0');
        }

        if (c[0] == MINUS) {
            result = result * -1;
        }

        return result;
    }

}
