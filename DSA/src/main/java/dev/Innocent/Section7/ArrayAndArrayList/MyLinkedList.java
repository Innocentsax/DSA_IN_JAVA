package dev.Innocent.Section7.ArrayAndArrayList;

public class MyLinkedList implements NodeList{
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (true){
            int comparison = currentItem.compareTo(newItem);
            if(comparison < 0){
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else {
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0) {
                if(currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }else {
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }else {
                return false;
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {

    }
}