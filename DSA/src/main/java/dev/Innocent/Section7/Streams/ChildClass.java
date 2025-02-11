package dev.Innocent.Section7.Streams;

public class ChildClass extends BassClass{
    @Override
    protected void optionalMethod() {
        System.out.println("[Child:optionalMethod] EXTRA Stuff Here");
        super.optionalMethod();
    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("[Child:recommendedMethod]: I'll do things my way");
//        optionalMethod();
//    }

    private final void mandatoryMethod(){
        System.out.println("[Child:mandatoryMethod]: My own important stuff");
    }

    private final void recommendedMMethod(){

    }
}
