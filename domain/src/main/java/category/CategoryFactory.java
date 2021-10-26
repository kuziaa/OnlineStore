//package category;
//
//public class CategoryFactory {
//
//    public Category createCategory(String categoryName) {
//        try {
//            Class<?> clazz = Class.forName("category." + categoryName);
//            return getCategoryByReflection(clazz);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException("Class with name " + categoryName + " was not found." + "\n" + e);
//        }
//    }
//
//    private Category getCategoryByReflection(Class<?> newCategoryReflection) {
//        try {
//            return (Category) newCategoryReflection.newInstance();
//        } catch (InstantiationException | IllegalAccessException e) {
//            throw new RuntimeException("Cannot create object from class " + newCategoryReflection.getName() + "\n" + e);
//        }
//    }
//}
