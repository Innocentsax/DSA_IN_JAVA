/** Task
For this practice challenge, write a simple greeter function.

If it is passed in a name NAME, return "Hello, NAME!".
If it is called without a name, return "Hello there!".*/

class Challenge {
    // Complete this function to return either
    // "Hello, [name]!" or "Hello there!"
    // based on the input
    
    public static String sayHello(String name) {
        // You can print to STDOUT for debugging if you need to:
        if (name != null && !name.isEmpty()){
          return "Hello, " + name + "!";
        }else {
          return "Hello there!";
        }
          //System.out.println();
        
        
        // but you need to return the correct value in order to pass the challenge
       // return name; // TODO: return the correct value
    }
}
