package org.example.repository;
import org.example.themain.Product;

public class Repository {
    Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    //добавление
    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;

        products = tmp;
    }

    //удаление
    public void removeById(int removeId) {
        Product[] tmp = new Product[products.length - 1];
        int indexTo = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                tmp[indexTo] = product;
                indexTo++;
            }
        }
        products = tmp;
    }
}


