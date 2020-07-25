package Amazon;

import java.util.*;

/**
 * Created by maharsu on 6/29/20.
 */
public class test4 {
    static List<String> largestItemAssociation(List<PairString> itemAssociation) {

        List<List<String>> combined = new ArrayList<>();

        List<String> pairStrings = new ArrayList<>();

        for (final PairString pairString : itemAssociation) {

            String[] pairs = pairString.getPairs();

            if (pairStrings.isEmpty()) {
                for (final String pair : pairs) {
                    pairStrings.add(pair);
                }
                combined.add(pairStrings);
                continue;
            } else {
                if (pairStrings.contains(pairs[0])) {
                    combined.remove(pairStrings);
                    pairStrings.add(pairs[1]);
                    combined.add(pairStrings);
                } else {
                    pairStrings = new ArrayList<>();
                    for (String pair : pairs) {
                        pairStrings.add(pair);
                    }
                    combined.add(pairStrings);
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (final List<String> combinedPairs : combined) {
            if (result.isEmpty()) {
                result = combinedPairs;
            } else {
                if (result.size() < combinedPairs.size()) {
                    result = combinedPairs;
                }
            }
        }
        return result;
    }


    static class PairString {

        //Assumption pairs is sorted
        String[] pairs = new String[2];


        PairString(String item1, String item2) {
            pairs[0] = item1;
            pairs[1] = item2;
        }

        String[] getPairs() {
            return pairs;
        }
    }

    public static void main(String[] args) {

        PairString pairString1 = new PairString("item1", "item2");
        PairString pairString2 = new PairString("item2", "item3");
        PairString pairString3 = new PairString("item4", "item5");

        List<String> test = largestItemAssociation(Arrays.asList(pairString1, pairString2, pairString3));

        for (String t : test) {
            System.out.println(t);
        }
    }


}
