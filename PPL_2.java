class PRACT3{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main text: ");
        String text = sc.nextLine();

        int choice;

        do {
            System.out.println("\n--- TEXT TRANSFORMER MENU ---");
            System.out.println("1. Convert to Uppercase");
            System.out.println("2. Convert to Lowercase");
            System.out.println("3. Compare Two Strings");
            System.out.println("4. Search Substring");
            System.out.println("5. Replace Substring");
            System.out.println("6. Extract Digits");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    char[] up = text.toCharArray();
                    for (int i = 0; i < up.length; i++) {
                        if (up[i] >= 'a' && up[i] <= 'z') {
                            up[i] = (char) (up[i] - 32);
                        }
                    }
                    System.out.println("Uppercase Text: " + new String(up));
                    break;

                case 2:
                    char[] low = text.toCharArray();
                    for (int i = 0; i < low.length; i++) {
                        if (low[i] >= 'A' && low[i] <= 'Z') {
                            low[i] = (char) (low[i] + 32);
                        }
                    }
                    System.out.println("Lowercase Text: " + new String(low));
                    break;

                case 3:
                    System.out.print("Enter second string: ");
                    String s2 = sc.nextLine();

                    boolean equal = true;

                    if (text.length() != s2.length()) {
                        equal = false;
                    } else {
                        for (int i = 0; i < text.length(); i++) {
                            if (text.charAt(i) != s2.charAt(i)) {
                                equal = false;
                                break;
                            }
                        }
                    }

                    if (equal)
                        System.out.println("Strings are Equal");
                    else
                        System.out.println("Strings are NOT Equal");

                    break;

                case 4:
                    System.out.print("Enter substring to search: ");
                    String sub = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i <= text.length() - sub.length(); i++) {
                        int j;
                        for (j = 0; j < sub.length(); j++) {
                            if (text.charAt(i + j) != sub.charAt(j)) {
                                break;
                            }
                        }
                        if (j == sub.length()) {
                            found = true;
                            break;
                        }
                    }

                    if (found)
                        System.out.println("Substring Found");
                    else
                        System.out.println("Substring Not Found");

                    break;

                case 5:
                    System.out.print("Enter word to replace: ");
                    String oldWord = sc.nextLine();
                    System.out.print("Enter new word: ");
                    String newWord = sc.nextLine();

                    String result = "";
                    int i = 0;

                    while (i < text.length()) {
                        boolean match = true;

                        if (i + oldWord.length() <= text.length()) {
                            for (int j = 0; j < oldWord.length(); j++) {
                                if (text.charAt(i + j) != oldWord.charAt(j)) {
                                    match = false;
                                    break;
                                }
                            }
                        } else {
                            match = false;
                        }

                        if (match) {
                            result += newWord;
                            i += oldWord.length();
                        } else {
                            result += text.charAt(i);
                            i++;
                        }
                    }

                    text = result;
                    System.out.println("Updated Text: " + text);
                    break;

                case 6:
                    String digits = "";

                    for (int k = 0; k < text.length(); k++) {
                        char ch = text.charAt(k);
                        if (ch >= '0' && ch <= '9') {
                            digits += ch;
                        }
                    }

                    System.out.println("Extracted Digits: " + digits);
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }


        } while (choice != 7);

           }
}

