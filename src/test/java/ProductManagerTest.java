import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Book book1 = new Book(1, "Book1", "A.Author11", 100);
    Book book2 = new Book(2, "Book2", "A.Author12", 110);
    Smartphone phone1 = new Smartphone(4, "phone1", 15_000, "land1");
    Smartphone phone2 = new Smartphone(5, "phone2", 20_000, "land2");
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    @Test
    public void testFindAll() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, phone1, phone2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testRepositoryRemoveById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);
        repo.removeById(2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, phone1, phone2};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testBookAuthor() {
        manager.add(book2);

        String actual = book2.getAuthor();
        String expected = "A.Author12";

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testSmartphoneLand() {
        manager.add(phone2);

        String actual = phone2.getProducer();
        String expected = "land2";

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testProductId() {
        manager.add(phone2);

        int actual = phone2.getId();
        int expected = 5;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testProductName() {
        manager.add(book1);

        String actual = book1.getName();
        String expected = "Book1";

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testProductPrice() {
        manager.add(phone1);

        int actual = phone1.getPrice();
        int expected = 15_000;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testNotName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("phone8");
        Product[] expected = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSearchBy() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("Book");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(actual, expected);
    }
}

