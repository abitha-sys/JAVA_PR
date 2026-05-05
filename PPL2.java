import java.util.Scanner;

public class ArrayPuzzleSolver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int choice;

        do {
            System.out.println("\n--- Array Puzzle Menu ---");
            System.out.println("1. Find Missing Number");
            System.out.println("2. Sort Array");
            System.out.println("3. Search Element");
            System.out.println("4. Find Largest");
            System.out.println("5. Find Smallest");
            System.out.println("6. Sum Pair Puzzle");
            System.out.println("7. Reverse Array");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                // 1. Missing Number
                case 1:
                    int expectedSum = n * (n + 1) / 2;
                    int actualSum = 0;

                    for (int i = 0; i < n; i++) {
                        actualSum += arr[i];
                    }

                    System.out.println("Missing Number: " + (expectedSum - actualSum));
                    break;

                // 2. Sort Array (Bubble Sort)
                case 2:
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (arr[j] > arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                            }
                        }
                    }

                    System.out.println("Sorted Array:");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                // 3. Search Element
                case 3:
                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (arr[i] == key) {
                            found = true;
                            break;
                        }
                    }

                    if (found)
                        System.out.println("Element Found");
                    else
                        System.out.println("Element Not Found");
                    break;

                // 4. Largest Element
                case 4:
                    int max = arr[0];
                    for (int i = 1; i < n; i++) {
                        if (arr[i] > max) {
                            max = arr[i];
                        }
                    }
                    System.out.println("Largest Element: " + max);
                    break;

                // 5. Smallest Element
                case 5:
                    int min = arr[0];
                    for (int i = 1; i < n; i++) {
                        if (arr[i] < min) {
                            min = arr[i];
                        }
                    }
                    System.out.println("Smallest Element: " + min);
                    break;

                // 6. Sum Pair Puzzle
                case 6:
                    System.out.print("Enter target sum: ");
                    int target = sc.nextInt();

                    boolean pairFound = false;
                    System.out.println("Pairs:");

                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] + arr[j] == target) {
                                System.out.println(arr[i] + " + " + arr[j]);
                                pairFound = true;
                            }
                        }
                    }

                    if (!pairFound) {
                        System.out.println("No pairs found");
                    }
                    break;

                // 7. Reverse Array
                case 7:
                    System.out.println("Reversed Array:");
                    for (int i = n - 1; i >= 0; i--) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
