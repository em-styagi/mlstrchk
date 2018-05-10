
import java.util.Arrays;

public class MlStringCheck {

    private static boolean startsWithCapital(String test) {
        //String starts with a capital letter
        return test.matches("(^[A-Z].*)");
    }

    private static boolean endsWithPeriod(String test) {
        //String ends with a period character “."
        return test.matches("(.*\\.$)");
    }

    private static boolean containsEvenCountOfQuotes(String test) {
        //String has an even number of quotation marks
        int count = 0;

        for (int i=0; i<test.length(); i++) {
            if (test.charAt(i) == '"')
                count+=1;
        }

        if ( (count % 2) == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public static void main (String[] args) {
        //String has no period characters other than the last character
        //Numbers below 13 are spelled out (”one”, “two”, "three”, etc…)

        String[] aValidStr = new String[4];
        String[] anInvalidStr = new String[4];

        aValidStr[0] = "The quick brown fox said \"hello Mr lazy dog\".";
        aValidStr[1] = "The quick brown fox said hello Mr lazy dog.";
        aValidStr[2] = "One lazy dog is too few, 13 is too many.";
        aValidStr[3] = "One lazy dog is too few, thirteen is too many.";

        anInvalidStr[0] = "The quick brown fox said \"hello Mr. lazy dog\".";
        anInvalidStr[1] = "the quick brown fox said \"hello Mr lazy dog\".";
        anInvalidStr[2] = "\"The quick brown fox said \"hello Mr lazy dog.\"";
        anInvalidStr[3] = "One lazy dog is too few, 12 is too many.";

        System.out.println("\nValid Strings:");
        for (int i=0; i<4; i++) {
           System.out.println (aValidStr[i]);
        }

        System.out.println("\nInvalid Strings:");
        for (int i=0; i<4; i++) {
           System.out.println (anInvalidStr[i]);
        }

        if (startsWithCapital(aValidStr[0])) {
            System.out.println("passed");
        }

        if (endsWithPeriod(aValidStr[0])) {
            System.out.println("passed");
        }

        if (containsEvenCountOfQuotes(aValidStr[0])) {
            System.out.println("passed");
        }
    }
}
