package model;

public class Root {

    private Sort sort;

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return "Root{" +
                "sort=" + sort +
                '}';
    }
}
