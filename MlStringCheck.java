
public class MlStringCheck {

    private String testString;

    public MlStringCheck (String test) {
        testString = test;
    }

    private boolean startsWithCapital() {
        //String starts with a capital letter
        return testString.matches("(^[A-Z].*)");
    }

    private boolean endsWithPeriod() {
        //String ends with a period character “."
        return testString.matches("(.*\\.$)");
    }

    private boolean containsEvenCountOfQuotes() {
        //String has an even number of quotes appearing
        int count = 0;

        for (int i=0; i<testString.length(); i++) {
            if (testString.charAt(i) == '"')
                count+=1;
        }

        if ( (count % 2) == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    private boolean containsNoPeriodOtherThanEnd() {
        //String has no period characters other than the last character
        String intermediateString = new String(testString.substring(0,(testString.length()-1)));

        if (intermediateString.contains(".")) {
            return false;
        } else {
            return true;
        }
    }

    private boolean noNumbersBelowThirteen() {
        //Numbers below 13 are spelled out (”one”, “two”, "three”, etc…)
        /* is it sufficient to check for the numbers 1-12 within
           the string and have those strings which contain these
           numbers fail?
           how do we know if the spelling of a number is correct?
           how do we know if the intent was to have a number? */
        if (testString.matches(".*(?: [0-9] | 10 | 11 | 12 ).*")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidSentence() {
        System.out.println("Testing: " + testString);
        if (this.startsWithCapital() == false) {
            System.out.println("Invalid: sentence does not start with capital letter\n");
            return false;
        }

        if (this.endsWithPeriod() == false) {
            System.out.println("Invalid: sentence does not end with a period\n");
           return false;
        }

        if (this.containsEvenCountOfQuotes() == false) {
            System.out.println("Invalid: sentence contains an uneven number of quotes\n");
            return false;
        }

        if (this.containsNoPeriodOtherThanEnd() == false) {
            System.out.println("Invalid: sentence contains a period in the middle\n");
            return false;
        }

        if (this.noNumbersBelowThirteen() == false) {
            System.out.println("Invalid: sentence contains numbers 1-12\n");
            return false;
        }

        System.out.println("Valid\n");
        return true;
    }

    public static void main (String[] args) {
        MlStringCheck validStr1 = new MlStringCheck("The quick brown fox said \"hello Mr lazy dog\".");
        MlStringCheck validStr2 = new MlStringCheck("The quick brown fox said hello Mr lazy dog.");
        MlStringCheck validStr3 = new MlStringCheck("One lazy dog is too few, 13 is too many.");
        MlStringCheck validStr4 = new MlStringCheck("One lazy dog is too few, thirteen is too many.");

        MlStringCheck invalidStr1 = new MlStringCheck("The quick brown fox said \"hello Mr. lazy dog\".");
        MlStringCheck invalidStr2 = new MlStringCheck("the quick brown fox said \"hello Mr lazy dog\".");
        MlStringCheck invalidStr3 = new MlStringCheck("\"The quick brown fox said \"hello Mr lazy dog.\"");
        MlStringCheck invalidStr4 = new MlStringCheck("One lazy dog is too few, 12 is too many.");

        int passCount = 0;
        int testCount = 0;

        testCount++;
        if (validStr1.isValidSentence() == true) {
            passCount++;
        }

        testCount++;
        if (validStr2.isValidSentence() == true) {
            passCount++;
        }
        testCount++;
        if (validStr3.isValidSentence() == true) {
            passCount++;
        }
        testCount++;
        if (validStr4.isValidSentence() == true) {
            passCount++;
        }
        testCount++;
        if (invalidStr1.isValidSentence() == false) {
            passCount++;
        }
        testCount++;
        if (invalidStr2.isValidSentence() == false) {
            passCount++;
        }
        testCount++;
        if (invalidStr3.isValidSentence() == false) {
            passCount++;
        }
        testCount++;
        if (invalidStr4.isValidSentence() == false) {
            passCount++;
        }
        System.out.println("Checks: " + testCount + " Passed: " + passCount + " Failed: " + (testCount-passCount));
    }
}
