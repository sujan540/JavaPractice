package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RiverRecord {


    public static int maxTrailing_1(List<Integer> levels) {
        int maxRecorded = -1;
        if (levels.size() < 100) {
            for (int i = 0; i < levels.size() - 1; i++) {
                for (int j = i; j < levels.size(); j++) {
                    if (levels.get(j) - levels.get(i) > 0 && levels.get(j) - levels.get(i) > maxRecorded) {
                        maxRecorded = levels.get(j) - levels.get(i);
                    }
                }
            }
            return maxRecorded;
        }
        final List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < levels.size() - 1; i++) {
            diff.add(levels.get(i + 1) - levels.get(i));
        }
        maxRecorded = diff.get(0);
        for (int i = 1; i < levels.size() - 1; i++) {
            if (diff.get(i - 1) > 0) {
                diff.set(i, diff.get(i) + diff.get(i - 1));
            }
            if (maxRecorded < diff.get(i)) {
                maxRecorded = diff.get(i);
            }
        }
        return maxRecorded == 0 ? -1 : maxRecorded;
    }

    public static int maxTrailing() {
        List<Integer> levels = new ArrayList<>();
        levels.add(980452);
        levels.add(970275);
        levels.add(968673);
        levels.add(938273);
        levels.add(929171);
        levels.add(879575);
        levels.add(861868);
        levels.add(854155);
        levels.add(806562);
        levels.add(768806);
        levels.add(768059);
        levels.add(746544);
        levels.add(743342);
        levels.add(739324);
        levels.add(714719);
        levels.add(711021);
        levels.add(709304);
        levels.add(703299);
        levels.add(700865);
        levels.add(691217);
        levels.add(686850);
        levels.add(682040);
        levels.add(658286);
        levels.add(644333);
        levels.add(634264);
        levels.add(624357);
        levels.add(608715);
        levels.add(605285);
        levels.add(595375);
        levels.add(565585);
        levels.add(563498);
        levels.add(552740);
        levels.add(543149);
        levels.add(541321);
        levels.add(540260);
        levels.add(525670);
        levels.add(512023);
        levels.add(511445);
        levels.add(461351);
        levels.add(445021);
        levels.add(420999);
        levels.add(419829);
        levels.add(375493);
        levels.add(362064);
        levels.add(354044);
        levels.add(352427);
        levels.add(339895);
        levels.add(310111);
        levels.add(280834);
        levels.add(279743);
        levels.add(235493);
        levels.add(221290);
        levels.add(183035);
        levels.add(176261);
        levels.add(167798);
        levels.add(164122);
        levels.add(151585);
        levels.add(149526);
        levels.add(143884);
        levels.add(139386);
        levels.add(120987);
        levels.add(120985);
        levels.add(87878);
        levels.add(37294);
        levels.add(31817);
        levels.add(25211);
        levels.add(21729);
        levels.add(20402);
//        if (levels != null && levels.size() > 2) {
//            int maxRecorded = -1;
//
//            for (int i = 0; i < levels.size() - 1; i++) {
//                for (int j = i; j < levels.size(); j++) {
//                   if(levels.get(j) - levels.get(i) > 0 && levels.get(j) - levels.get(i) > maxRecorded) {
//                       maxRecorded = levels.get(j) - levels.get(i);
//                   }
//                }
//            }
//
//
//            return maxRecorded;
//        }
//
//        return levels.get(1) - levels.get(0) > 0 ? levels.get(1) - levels.get(0) : -1;

//        int maxRecorded = -1;
//        int size = levels.size();
//
//        int maxRight = levels.get(size - 1);
//        for (int i = size - 2; i >= 0; i--) {
//            if (levels.get(i) > maxRecorded) {
//                maxRight = levels.get(i);
//            } else {
//                int diff = maxRight - levels.get(i);
//                if (diff > maxRecorded) {
//                    maxRecorded = diff;
//                }
//            }
//        }
//        return maxRecorded;

        if (levels != null && levels.size() > 2) {
            List<Integer> diff = new ArrayList<>();
            for (int i = 0; i < levels.size() - 1; i++) {
                diff.add(levels.get(i + 1) - levels.get(i));
            }

            int maxRecorded = diff.get(0);
            for (int i = 1; i < levels.size() - 1; i++) {
                if (diff.get(i - 1) > 0) {
                    diff.set(i, diff.get(i) + diff.get(i - 1));
                }
                if (maxRecorded < diff.get(i)) {
                    maxRecorded = diff.get(i);
                }
            }
            return maxRecorded == 0 ? -1 : maxRecorded;

        }
        return levels.get(1) - levels.get(0) > 0 ? levels.get(1) - levels.get(0) : -1;

//        int diff = levels.get(1) - levels.get(0);
//        int curr_sum = diff;
//        int max_sum = curr_sum;
//        int n = levels.size();
//
//        for(int i = 1; i < n - 1; i++)
//        {
//            // Calculate current diff
//            diff = levels.get(i + 1) - levels.get(i);
//
//            // Calculate current sum
//            if (curr_sum > 0)
//                curr_sum += diff;
//            else
//                curr_sum = diff;
//
//            // Update max sum, if needed
//            if (curr_sum > max_sum)
//                max_sum = curr_sum;
//        }
//
//        return max_sum;

//        int minEle = levels.get(0);
//        int maxEle = levels.get(0);
//        for (int i = 1; i < levels.size(); i++) {
//            minEle = Math.min(minEle, levels.get(i));
//            maxEle = Math.max(maxEle, levels.get(i));
//        }
//
//        return (maxEle - minEle);
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int levelsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> levels = IntStream.range(0, levelsCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());

        int result = RiverRecord.maxTrailing();

        System.out.println(result);

        //        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
