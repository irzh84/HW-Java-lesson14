import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    Product item1 = new Product(1, "Хлеб", 100);
    Product item2 = new Product(2, "Молоко", 200);
    Product item3 = new Product(3, "Сыр", 300);

    @Test
    public void removeByIdSuccess() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Product[] expected = {item1, item3};
        Product[] actual = repo.removeById(2);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdSuccessNot() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }
}