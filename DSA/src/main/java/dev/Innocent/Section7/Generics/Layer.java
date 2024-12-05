package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.List;

public class Layer <T extends Mappable>{
    private List<T> layerElement;

    public Layer(T[] layerElement) {
        this.layerElement = new ArrayList<T>(List.of(layerElement));
    }

    public void addElements(T... elements){
        layerElement.addAll(List.of(elements));
    }

    public void renderLayer(){
        for(T element : layerElement){
            element.render();
        }
    }
}
