# Online Store (study project)

## Task 02_git
We will store source code of our OnlineStore in GitHub. Before start you should read and understand git principals and main git commands.

Please create GitHub repo and append your trainer to this repo!

While doing each task, you should create a separate branch with the name of the topic, e.g. 02_git, push you task code to this branch and create a pull request from your branch to master branch, and assign it to your trainer.

Status: completed;

## Task 03_oop
Before start creating source code, read carefully all materials about OOP. It is not only 3 principles for interview;)

Store functionality should be based on above principles.

Classes to create:

- Product with such attributes as [name, rate, price]
- Category classes with the name attribute, for each store category [bike, phone, milk]
- Store - class that should handle category list and products that belong to each category
- RandomStorePopulator - utility class that will populate out store/category with fake data using Faker lib
- StoreApp - class with main method to execute our store scenario.

When invoke main method, application should init store with categories and products and pretty print this data. Also, categories should be read dynamically (at runtime), from base category package using reflections lib.

Status: In progress