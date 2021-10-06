package model;

//Class was changed to apply Singleton Design pattern. Will be rolled back after task pass

public class Root {

    private static Root root;

    public static Root getRoot() {
        if (root == null) {
            root = new Root();
        }
        return root;
    }

    private Root() {

    }

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
