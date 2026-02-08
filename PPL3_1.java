import java.util.Scanner;


public class StringOperation {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the string : ");
        String s1 = sc.nextLine();


        boolean exit = false;


        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Convert to Uppercase");
            System.out.println("2. Convert to Lowercase");
            System.out.println("3. Get Length");
            System.out.println("4. Compare with another string");
            System.out.println("5. Reverse the string");
            System.out.println("6. Capitalize words");
            System.out.println("7. Search for substring");
            System.out.println("8. Replace Substring");
            System.out.println("9. Exit");


            int choice = sc.nextInt();
            sc.nextLine(); // consume newline


            switch (choice) {


                case 1:
                    System.out.println("Uppercase: " + s1.toUpperCase());
                    break;


                case 2:
                    System.out.println("Lowercase: " + s1.toLowerCase());
                    break;


                case 3:
                    System.out.println("Length: " + s1.length());
                    break;


                case 4:
                    System.out.println("Enter another string:");
                    String s2 = sc.nextLine();
                    System.out.println("Strings are equal: " + s1.equals(s2));
                    break;


                case 5:
                    String reversed = new StringBuilder(s1).reverse().toString();
                    System.out.println("Reversed string: " + reversed);
                    break;


                case 6:
                    String[] words = s1.split("\\s+");
                    StringBuilder capitalized = new StringBuilder();


                    for (String word : words) {
                        capitalized.append(
                                word.substring(0, 1).toUpperCase()
                                + word.substring(1).toLowerCase()
                                + " "
                        );
                    }
                    System.out.println("Capitalized string: " + capitalized.toString().trim());
                    break;


                case 7:
                    System.out.println("Enter substring to search:");
                    String sub = sc.nextLine();


                    if (s1.contains(sub)) {
                        System.out.println("Substring is present");
                    } else {
                        System.out.println("Substring is not present");
                    }
                    break;


                case 8:
                    System.out.println("Enter word to replace:");
                    String oldWord = sc.nextLine();


                    System.out.println("Enter new word:");
                    String newWord = sc.nextLine();


                    String replaced = s1.replace(oldWord, newWord);
                    System.out.println("After replacement: " + replaced);
                    break;


                case 9:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;


                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }


        
    }
}
