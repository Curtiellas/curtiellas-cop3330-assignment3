package ex44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeaderTest {

    @Test
    void searchProduct() {
        Product[] products = new Product[3];

        products[0] = new Product("thing", 15.00, 5);
        products[1] = new Product("doodad", 5.00, 10);
        products[2] = new Product("Widget", 25.00, 5);

        assertTrue(Header.searchProduct("thing", 3, products) < 3
                            && Header.searchProduct("thing", 3, products) > -1);
    }

}