package PrintStructure;

public class CalculateChar {
    public static void main(String[] args) {
        String str =  "gjsfgbjgf5bnm 89djbjj1"; // Read input string from user
        int i=0,sum = 0;
        int currentNumber = 0;

        while (i<str.length()) {
            char ch = str.charAt(i);
            if (ch>='0'&& ch<='9') {
                currentNumber = currentNumber * 10 + Integer.parseInt(String.valueOf(ch));
            } else {
                sum += currentNumber;
                currentNumber = 0;
            }
            i++;
            
        }
        sum += currentNumber;

        System.out.println("Sum of all numbers in the string: " + sum);
    }
   
}
