package dev.Innocent.Section7.Streams;

public class BassClass {
    public final void recommendedMethod(){
        System.out.println("[BaseClass.recommendedMethod]: Best way to do it");
        optionalMethod();
        mandatoryMethod();
    }

    protected void optionalMethod(){
        System.out.println("[BaseClass.optionalMethod]: Customize Optional Method");
    }

    private void mandatoryMethod(){
        System.out.println("[BaseClass.mandatoryMMethod]: NON-NEGOTIABLE");
    }

    public static void recommendedStatic(){
        System.out.println("[BaseClass.recommendedStatic] BEST Way to Do it");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic(){
        System.out.println("[BaseClass.optionalStatic]: Optional");
    }

    private static void mandatoryStatic(){
        System.out.println("[BaseClass.mandatoryStatic]: MANDATORY");
    }

    public static void main(String[] args) {
        BassClass parent = new BassClass();
        ChildClass child = new ChildClass();
        BassClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("---------------------------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("----------------------------------");
        child.recommendedMethod();


        System.out.println("----------------------------------");
        parent.recommendedStatic();
        System.out.println("---------------------------------");
        childReferredToAsBase.recommendedStatic();
        System.out.println("----------------------------------");
        child.recommendedStatic();

        String xArgument = "This is all i have got to say about this section";
        doXYZ(xArgument, 16);
    }

    private static void doXYZ(String x, int y){
        final String c = x + y;
        System.out.println("c = " + c);
    }
}
