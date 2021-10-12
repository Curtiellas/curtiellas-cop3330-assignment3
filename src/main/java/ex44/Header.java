package ex44;

public class Header {
    private String descriptor;
    private Product[] products;

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    //Products getter that returns specific [index] value
    public Product getProducts(int x) {
        return products[x];
    }

    public static int searchProduct(String prod, int length, Product[] products) {
        int x = -1;

        for (int i = 0; i < length; i++) {
            if (products[i].getName().equalsIgnoreCase( prod )) {
                return i;
            }
        }

        return x;
    }

    public void printOutput(int found) {
        System.out.println("Name: " + getProducts(found).getName());
        System.out.printf("Price: %.2f\n", getProducts(found).getPrice());
        System.out.println("Quantity: " + getProducts(found).getQuantity());
    }
}

