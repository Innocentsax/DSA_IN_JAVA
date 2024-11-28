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
        if(this.root == null || item == null){
            return false;
        }
        ListItem currentItem = this.root;
        ListItem parentItem = null;

        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison < 0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }else {
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent){
        if (item.next() == null && item.previous() == null) {
            if(parent == null){
                this.root = null;
            } else if (parent.next() == item) {
                parent.setNext(null);
            }else {
                parent.setPrevious(null);
            }
        }
    }

    @Override
    public void traverse(ListItem root) {

    }
}