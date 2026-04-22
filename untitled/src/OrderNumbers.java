// "New" means new compared to previous level
import java.util.Scanner;
import java.util.ArrayList;

public class OrderNumbers {
    public static void reorderNums(ArrayList<Integer> remainNums,
                                   ArrayList<Integer> reorderNums) {
        ArrayList<Integer> tmpRemainNums;
        int tmpRemovedNum;
        int i;

        if (remainNums.size() == 0) {
            System.out.print(reorderNums.get(0));
            System.out.print(reorderNums.get(1));
            System.out.println(reorderNums.get(2));
        }
        else {
            for (i = remainNums.size() - 1; i >= 0; --i) { // New: This line changed
                tmpRemainNums = new ArrayList<Integer>(remainNums); // Make a copy.
                tmpRemovedNum = tmpRemainNums.remove(i);
                reorderNums.add(tmpRemovedNum);
                reorderNums(tmpRemainNums, reorderNums);
                reorderNums.remove(reorderNums.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Integer> numsToReorder = new ArrayList<Integer>();
        ArrayList<Integer> resultNums = new ArrayList<Integer>();

        numsToReorder.add(1);
        numsToReorder.add(7);
        numsToReorder.add(8);

        reorderNums(numsToReorder, resultNums);
    }
}