public class Solution {
    private static void print(String message) {
        System.out.println(message);
    }
    private static void solve(int input) {
        String weird = "Weird";
        String notWird = "Not Weird";
        
        if(input % 2 != 0) {
            print(weird);
        } else {
            if(input % 2 == 0) {
                if(2 <= input && input <= 5) {
                    print(notWird);
                } else if (6 <= input && input <= 20) {
                    print(weird);
                } else {
                    print(notWird);
                }
            } 
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        solve(N);
        scanner.close();
    }
}
0|Add CommentPermalink


ksravankumar758 6 days ago
the correct output is

public static void main(String[] args) {
    int N = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    scanner.close();
    if(N%2!=0){
        System.out.println("Weird");
    }
    if(N%2==0){
        if((N>=2 && N<=5)||(N>20)){
            System.out.println("Not Weird");
        }
        if(N>=6 && N<=20){
            System.out.println("Weird");
        }
    }
}  
}

