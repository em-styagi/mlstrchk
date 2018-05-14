
public class MlStringCheck {

    private String testString;
    public MlStringCheck (String test) {
        testString = test;
    }

    public boolean startsWithCapital() {
        //String starts with a capital letter
        return testString.matches("(^[A-Z].*)");
    }

    public boolean endsWithPeriod() {
        //String ends with a period character “."
        return testString.matches("(.*\\.$)");
    }

    public boolean containsEvenCountOfQuotes() {
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

    public boolean containsNoPeriodOtherThanEnd() {
        //String has no period characters other than the last character
        String intermediateString = new String(testString.substring(0,(testString.length()-1)));

        if (intermediateString.contains(".")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean noNumbersBelowThirteen() {
        //Numbers below 13 are spelled out (”one”, “two”, "three”, etc…)
        /* is it sufficient to check for the numbers 1-12 within
           the string and have those strings which contain these
           numbers fail?
           how do we know if the spelling of a number is correct?
           how do we know if the intent was to have a number? */
        if (testString.matches("(.*[0-9,10,11,12].*)")) {
            return false;
        } else {
            return true;
        }
    }

    public static void main (String[] args) {
        MlStringCheck mysc = new MlStringCheck("The quick brown fox said \"hello Mr lazy dog\".");

        int passCount = 0;
        int testCount = 0;

        testCount++;
        if (mysc.startsWithCapital()) {
            passCount++;
            System.out.println("passed");
        }

        testCount++;
        if (mysc.endsWithPeriod()) {
            passCount++;
            System.out.println("passed");
        }

        testCount++;
        if (mysc.containsEvenCountOfQuotes()) {
            passCount++;
            System.out.println("passed");
        }

        testCount++;
        if (mysc.containsNoPeriodOtherThanEnd()) {
            passCount++;
            System.out.println("passed");
        }

        testCount++;
        if (mysc.noNumbersBelowThirteen()){
            passCount++;
            System.out.println("passed");
        }

        System.out.println("Checks: " + testCount + " Passed: " + passCount + " Failed: " + (testCount-passCount));
    }
}
