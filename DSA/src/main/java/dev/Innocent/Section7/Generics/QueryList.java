package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> extends ArrayList<T>{
//    private List<T> items;

    public QueryList(){

    }

    public QueryList(List<T> items) {
        super(items);
//        this.items = items;
    }

    public QueryList<T> getMatches(String field, String value){
        QueryList<T> matches = new QueryList<>();
        for(var item : this){
            if(item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }
        return matches;
    }
}
