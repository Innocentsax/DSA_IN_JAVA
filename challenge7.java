    // Input a year and find whether it is a leap year or not
    public static void leapYear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kindly input a digit: ");
        Integer num = scanner.nextInt();
        if (num == 365){
            System.out.println(num +"days, It's a year not a leap year.");
        } else if (num == 366) {
            System.out.println(num + "days is a leap year");
        }else {
            System.out.println("Your input is invalid");
        }
    }

    // Take two numbers and print the sum of both
    public static void addSum(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kindly enter First integer: ");
        Integer num1 = scanner.nextInt();

        System.out.println("Kindly enter Second integer: ");
        Integer num2 = scanner.nextInt();

        Integer result = num1 + num2;
        System.out.println("The sum of the first and second Integer is " + result);
    }

    // Take  a number as input and print the multplication table for it
    public static void multiplicationTimeTable(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kindly enter a number to get your Multiplication timeTable: ");
        int num = scanner.nextInt();

        for (int i = 1; i < 13; i++) {
            int result = num *  i;
            System.out.println(num + " x " + i + " = " + result);
        }

    }
