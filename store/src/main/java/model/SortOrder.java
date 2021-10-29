package model;

public enum SortOrder {
    ASC (1),
    DESC (-1),
    NO (0);

    private final int sortCoef;

    SortOrder(int sortCoef) {
        this.sortCoef = sortCoef;
    }

    public int getSortCoef() {
        return sortCoef;
    }
}
