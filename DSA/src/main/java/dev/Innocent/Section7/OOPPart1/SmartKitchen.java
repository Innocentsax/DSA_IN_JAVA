package dev.Innocent.Section7.OOPPart1;

public class SmartKitchen {
    private CoffeeMaker brewMaster;
    private Refrigerator iceBox;
    private DishWasher dishWasher;
}

class CoffeeMaker{
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void brewCoffee(){
        if(hasWorkToDo){
            System.out.println("Brewing coffee");
            hasWorkToDo = false;
        }
    }
}
