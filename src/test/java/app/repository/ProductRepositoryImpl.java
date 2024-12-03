package app.repository;

import app.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> database = new ArrayList<>();
    private long currentId = 0;

    @Override
    public Product save(Product product) {
        product.setId(++currentId);
        database.add(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return database;
    }

    @Override
    public Product findById(Long id) {
        return database
                .stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Product product) {
        Long id = product.getId();
        double newPrice = product.getPrice();

        Product existProduct = findById(id);
        if (existProduct != null) {
            existProduct.setPrice(newPrice);
        }
    }

    @Override
    public void removeById(Long id) {
        database.removeIf(x -> x.getId().equals(id));
    }

    public static void main(String[] args) {
        ProductRepository repository = new ProductRepositoryImpl();
        repository.save(new Product("Banana", 120, true));
        repository.save(new Product("Apple", 90, true));
        repository.save(new Product("Peach", 180, true));

        repository.findAll().forEach(x-> System.out.println(x));

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(5L));

        repository.update(new Product(2L,95));
        System.out.println(repository.findById(2L));
        System.out.println();
        repository.removeById(2L);
        repository.findAll().forEach(x-> System.out.println(x));




    }
}