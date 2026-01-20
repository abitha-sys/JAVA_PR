import java.util.Scanner;

public class Array {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- ARRAY OPERATIONS MENU ---");
            System.out.println("1. Find Missing Number");
            System.out.println("2. Find Min & Max");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Linear Search");
            System.out.println("5. Pair Sum");
            System.out.println("6. Reverse Array");
            System.out.println("7. Merge Arrays ");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    System.out.println("--- Missing Number ---");
                    int arr[] = {1, 2, 4, 5};
                    int ex_sum = 5 * (5 + 1) / 2;
                    int ac_sum = 0;

                    for (int i = 0; i < arr.length; i++) {
                        ac_sum += arr[i];
                    }

                    System.out.println("Array: {1, 2, 4, 5}");
                    System.out.println("Missing number: " + (ex_sum - ac_sum));
                    break;
                }

                case 2: {
                    System.out.println("--- Min & Max ---");
                    int arr1[] = {4, 7, 2, 3, 5};
                    int max = arr1[0], min = arr1[0];

                    for (int i = 1; i < arr1.length; i++) {
                        if (arr1[i] > max) max = arr1[i];
                        if (arr1[i] < min) min = arr1[i];
                    }

                    System.out.println("Array: {4, 7, 2, 3, 5}");
                    System.out.println("Minimum: " + min);
                    System.out.println("Maximum: " + max);
                    break;
                }

                case 3: {
                    System.out.println("--- Bubble Sort ---");
                    System.out.print("Enter number of elements: ");
                    int n = sc.nextInt();
                    int[] arr2 = new int[n];

                    System.out.println("Enter elements:");
                    for (int i = 0; i < n; i++) {
                        arr2[i] = sc.nextInt();
                    }

                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - 1 - i; j++) {
                            if (arr2[j] > arr2[j + 1]) {
                                int temp = arr2[j];
                                arr2[j] = arr2[j + 1];
                                arr2[j + 1] = temp;
                            }
                        }
                    }

                    System.out.println("Sorted array:");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr2[i] + " ");
                    }
                    System.out.println();
                    break;
                }

                case 4: {
                    System.out.println("--- Linear Search ---");
                    System.out.print("Enter number of elements: ");
                    int n = sc.nextInt();
                    int[] searchArr = new int[n];

                    System.out.println("Enter elements:");
                    for (int i = 0; i < n; i++) {
                        searchArr[i] = sc.nextInt();
                    }

                    System.out.print("Enter element to search: ");
                    int key = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (searchArr[i] == key) {
                            System.out.println("Element found at index " + i);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Element not found");
                    }
                    break;
                }

                case 5: {
                    System.out.println("--- Pair Sum ---");
                    System.out.print("Enter number of elements: ");
                    int n = sc.nextInt();
                    int[] pairArr = new int[n];

                    System.out.println("Enter elements:");
                    for (int i = 0; i < n; i++) {
                        pairArr[i] = sc.nextInt();
                    }

                    System.out.print("Enter target sum: ");
                    int target = sc.nextInt();
                    boolean pairFound = false;

                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (pairArr[i] + pairArr[j] == target) {
                                System.out.println(pairArr[i] + " + " + pairArr[j] + " = " + target);
                                pairFound = true;
                            }
                        }
                    }

                    if (!pairFound) {
                        System.out.println("No pair found");
                    }
                    break;
                }

                case 6: {
                    System.out.println("--- Reverse Array ---");
                    System.out.print("Enter size of array: ");
                    int m = sc.nextInt();
                    int[] a = new int[m];
                    int[] b = new int[m];

                    System.out.println("Enter elements:");
                    for (int i = 0; i < m; i++) {
                        a[i] = sc.nextInt();
                    }

                    for (int i = 0; i < m; i++) {
                        b[i] = a[m - 1 - i];
                    }

                    System.out.println("Reversed array:");
                    for (int i = 0; i < m; i++) {
                        System.out.print(b[i] + " ");
                    }
                    System.out.println();
                    break;
                }

               case 7: {
    System.out.println("--- Merge Two Arrays ---");

    System.out.print("Enter size of first array: ");
    int m = sc.nextInt();
    int[] a = new int[m];

    System.out.println("Enter elements of first array:");
    for (int i = 0; i < m; i++) {
        a[i] = sc.nextInt();
    }

    System.out.print("Enter size of second array: ");
    int n = sc.nextInt();
    int[] b = new int[n];

    System.out.println("Enter elements of second array:");
    for (int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
    }

    int[] arr3 = new int[m + n];

    for (int i = 0; i < m; i++) {
        arr3[i] = a[i];
    }

    for (int i = 0; i < n; i++) {
        arr3[i + m] = b[i];
    }

    System.out.println("Merged array:");
    for (int i = 0; i < arr3.length; i++) {
        System.out.print(arr3[i] + " ");
    }
    System.out.println();
    break;
}


                case 8:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 8);

       
    }
}
