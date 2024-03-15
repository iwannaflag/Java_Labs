package Labs.Lab02;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Product p1 = new Product("方便面", 5.5);
        Product p2 = new Product("火腿肠", 2.2);
        Product p3 = new Product("矿泉水", 1.0);
        Product p4 = new Product("饮料", 3.5);
        Product[] Products = {p1, p2, p3, p4};
        Scanner r = new Scanner(System.in);
        User user = new User(r.next(), r.nextDouble(), r.next());
        int n = r.nextInt();
        Item[] items = new Item[n];
        for(int i=0; i<n; i++){
            String product_name = r.next();
            int product_number = r.nextInt();
            for(Product p: Products){
                if(product_name.equals(p.getProduct_name())){
                    items[i] = new Item(p, product_number);
                }
            }
        }
        Order order = new OrderService().addOrder(user, items);
        if(order != null){
            System.out.printf("购买商品总额：%.2f\n", order.getExpenditure());
            System.out.printf("用户余额：%.2f\n", order.getUser().getBalance());
            System.out.println("地址：" + order.getUser().getAddress());
        }
        else {
            System.out.println("用户余额不足\n");
        }
    }

    public static class User{
        String username,address;
        double balance;

        public User(String username, double balance, String address) {
            this.username = username;
            this.balance = balance;
            this.address = address;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }
    public static class Product{
        String product_name;
        double value;

        public Product(String product_name, double value) {
            this.product_name = product_name;
            this.value = value;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
    public static class Item{
        Product product;
        int numbers;

        public Item(Product product, int numbers) {
            this.product = product;
            this.numbers = numbers;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getNumbers() {
            return numbers;
        }

        public void setNumbers(int numbers) {
            this.numbers = numbers;
        }
    }
    public static class Order{
        User user;
        Item[] products;
        double expenditure;

        public Order(User user, Item[] products) {
            this.user = user;
            this.products = products;
            this.expenditure = 0;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Item[] getProducts() {
            return products;
        }

        public void setProducts(Item[] products) {
            this.products = products;
        }

        public double getExpenditure() {
            return expenditure;
        }

        public void setExpenditure(double expenditure) {
            this.expenditure = expenditure;
        }
    }
    public static class OrderService{
        public Order addOrder(User user, Item[] Items){
            Order order = new Order(user, Items);
            double expenditure = 0;
            for(Item item : Items){
                expenditure += (item.getProduct().getValue()*item.getNumbers());
            }
            if(user.getBalance() < expenditure){
                return null;
            }
            else {
                order.setExpenditure(expenditure);
                user.setBalance(user.getBalance()-expenditure);
                return order;
            }
        }
    }
}
