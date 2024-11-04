package dev.Innocent.Section7.OOPPart1;

public class Painter {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Painter(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount){
        int tempAmount = tonerAmount + tonerLevel;
        if(tempAmount > 100 || tonerAmount < 0) return -1;
        tonerLevel += tonerAmount;
        return tonerLevel;
    }

    public int printPages(int pages){
        int jobPages = (duplex) ? (pages / 2) + (pages % 2) : pages;
        pagesPrinted += jobPages;
        return jobPages;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
