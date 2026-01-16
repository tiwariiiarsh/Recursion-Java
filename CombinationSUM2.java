package arsh.java.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSUM2 {

    // ---------------- MAIN METHOD (PSVM) ----------------
    public static void main(String[] args) {

        CombinationSUM2 obj = new CombinationSUM2();

        // INPUT
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        // FUNCTION CALL
        List<List<Integer>> result = obj.combinationSum2(candidates, target);

        // OUTPUT
        System.out.println("Combinations that sum to " + target + " :");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    // ---------------- COMBINATION SUM II LOGIC ----------------
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // Step 0: Sort array (VERY IMPORTANT for duplicates handling)
        Arrays.sort(candidates);

        // Step 1: Build unique values list & their counts
        List<Integer> values = new ArrayList<>(); // unique numbers
        List<Integer> counts = new ArrayList<>(); // count of each number

        for (int num : candidates) {
            // agar list empty hai ya last element alag hai
            if (values.isEmpty() || values.get(values.size() - 1) != num) {
                values.add(num);
                counts.add(1);
            } else {
                // same element mila → count badhao
                counts.set(counts.size() - 1, counts.get(counts.size() - 1) + 1);
            }
        }

        // Result list
        List<List<Integer>> result = new ArrayList<>();

        // Step 2: Backtracking call
        backtrack(values, counts, 0, target, new ArrayList<>(), result);

        return result;
    }

    // ---------------- BACKTRACKING FUNCTION ----------------
    private void backtrack(
            List<Integer> values,
            List<Integer> counts,
            int index,
            int target,
            List<Integer> current,
            List<List<Integer>> result) {

        // BASE CASE 1: Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current)); // deep copy
            return;
        }

        // BASE CASE 2: Index out of bounds
        if (index == values.size()) {
            return;
        }

        // OPTION 1: Skip current number
        backtrack(values, counts, index + 1, target, current, result);

        // OPTION 2: Take current number (if available & <= target)
        int val = values.get(index);

        if (counts.get(index) > 0 && val <= target) {

            // Choose
            current.add(val);
            counts.set(index, counts.get(index) - 1);

            // Stay at same index (because same number can repeat limited times)
            backtrack(values, counts, index, target - val, current, result);

            // Unchoose (BACKTRACK)
            counts.set(index, counts.get(index) + 1);
            current.remove(current.size() - 1);
        }
    }
}
