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

    }
}
