package dev.Innocent.Section7.Streams;

public class BassClass {
    public void recommendedMethod(){
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

    public static void main(String[] args) {
        BassClass parent = new BassClass();
        ChildClass child = new ChildClass();
        BassClass childReferredToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("---------------------------------");
        childReferredToAsBase.recommendedMethod();
        System.out.println("----------------------------------");
        child.recommendedMethod();
    }
}
