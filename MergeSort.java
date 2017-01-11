import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int midInd = arr.length / 2;
        int rightStart = midInd + 1;

        int[] leftArr = Arrays.copyOfRange(arr, 0, midInd);
        int[] rightArr = Arrays.copyOfRange(arr, midInd, arr.length);

        return merge(sort(leftArr), sort(rightArr));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int arr1Ind = 0;
        int arr2Ind = 0;
        int[] mergedArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < mergedArr.length; i++) {
            if (arr1Ind >= arr1.length || arr2Ind < arr2.length && arr1[arr1Ind] >= arr2[arr2Ind]) {
                mergedArr[i] = arr2[arr2Ind];

                arr2Ind++;
            } else {
                mergedArr[i] = arr1[arr1Ind];

                arr1Ind++;
            }
        }

        return mergedArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 1, 4, 7, 10, 3};

        int[] sortedArr = sort(arr);

        for (int ele : sortedArr) {
            System.out.print(ele);
            System.out.print(", ");
        }

        System.out.println(" should have printed 1, 1, 3, 3, 4, 4, 7, 10");
    }
}
