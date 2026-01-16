package arsh.java.recursion.backtraking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    // ---------------- MAIN METHOD (PSVM) ----------------
    public static void main(String[] args) {

        CombinationSum1 obj = new CombinationSum1();

        // INPUT
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        // FUNCTION CALL
        List<List<Integer>> result = obj.combinationSum(candidates, target);

        // OUTPUT
        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    // ---------------- COMBINATION SUM LOGIC ----------------
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // backtracking start from index 0
        findCombination(candidates, 0, target, result, new ArrayList<>());

        return result;
    }

    // ---------------- BACKTRACKING FUNCTION ----------------
    private void findCombination(
            int[] arr,
            int index,
            int target,
            List<List<Integer>> ans,
            List<Integer> ds) {

        // BASE CASE: agar saare elements check ho gaye
        if (index == arr.length) {
            // agar target exactly 0 hua
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); // deep copy
            }
            return;
        }

        // OPTION 1: PICK current element (can be reused unlimited times)
        if (arr[index] <= target) {

            ds.add(arr[index]); // choose

            // same index because element can be reused
            findCombination(arr, index, target - arr[index], ans, ds);

            ds.remove(ds.size() - 1); // backtrack
        }

        // OPTION 2: NOT PICK current element
        findCombination(arr, index + 1, target, ans, ds);
    }
}
