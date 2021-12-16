import DatabaseAccess.*;
import Model.Customer;
import Model.Store;
import Products.*;
import Exception.InvalidInputException;
import Exception.NotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        store.getDateFromServer();
        store.getCustomerDataFromServer();
        Customer customer = new Customer();
        Database database=new Database();
        DbProduct dbProduct = new DbProduct();
        DbTv dbTv = new DbTv();
        DbRadio dbRadio = new DbRadio();
        DbShoes dbShoes = new DbShoes();
        DbBook dbBook = new DbBook();
        DbMagezine dbMagezine = new DbMagezine();
        DbCustomer dbCustomer = new DbCustomer();
        int barcode = 0;
        int count = 0;
        String input = new String();
        String number = new String();
        boolean check = true;
        do {
            try {
                do {
                    System.out.println("1.admin\n2.customer\n3.exit");
                    input = scanner.next();
                    if (!input.matches("^([1-3])$")){
                        throw new InvalidInputException("Please Enter Valid Number Between 1-3");
                    }
                    switch (input) {
                        case "1":
                            do {
                                System.out.println("1.increase count\n2.decrease count\n3.add tv\n4.add radio\n" +
                                        "5.add shoes\n6.add book\n7.add magezine\n8.exit");
                                number = scanner.next();
                                if (!number.matches("^([1-8])$")) {
                                    throw new InvalidInputException("Please Enter Valid Number Between 1-8");
                                }
                                switch (number) {
                                    case "1":
                                        System.out.println("please enter barcode of product & count of it ");
                                        barcode = scanner.nextInt();
                                        count = scanner.nextInt();
                                        store.increaseCount(barcode, count);
                                        dbProduct.increase("product", barcode, count);
                                        break;
                                    case "2":
                                        System.out.println("please enter barcode of product& number of it ");
                                        barcode = scanner.nextInt();
                                        count = scanner.nextInt();
                                        store.decreaseCount(barcode, count);
                                        dbProduct.decrease("product", barcode, count);
                                        break;
                                    case "3":
                                        System.out.println("please enter id,name,cost,count,feature,brand," +
                                                "inch,quality of tv");
                                        store.addTv(scanner.nextInt(), scanner.next(), scanner.nextInt(),
                                                scanner.nextInt(), scanner.next(), scanner.next(),
                                                scanner.nextInt(), scanner.next());
                                        dbTv.add((Television) store.getProduct().get(store.getProduct().size() - 1));

                                        break;
                                    case "4":

                                        System.out.println("please enter id,name,cost,count,feature,brand,radioWave,sourceEnergyType of radio");
                                        store.addRadio(scanner.nextInt(), scanner.next(), scanner.nextInt(),
                                                scanner.nextInt(), scanner.next(), scanner.next(),
                                                scanner.next(), scanner.next());
                                        dbRadio.add((Radio) store.getProduct().get(store.getProduct().size() - 1));
                                        break;
                                    case "5":
                                        System.out.println("please enter id,name,cost,count,feature,size,material");
                                        store.addShoes(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next());
                                        dbShoes.add((Shoes) store.getProduct().get(store.getProduct().size() - 1));
                                        break;
                                    case "6":
                                        System.out.println("please enter id,name,cost,count,feature,typeCover,language,publisher,format,page");
                                        store.addBook(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.nextInt());
                                        dbBook.add((Book) store.getProduct().get(store.getProduct().size() - 1));
                                        break;
                                    case "7":
                                        System.out.println("please enter id,name,cost,count,feature,typeCover," +
                                                "language,publisher,type,periodPublish,magazineType");
                                        store.addMagezine(scanner.nextInt(), scanner.next(), scanner.nextInt(),
                                                scanner.nextInt(), scanner.next(), scanner.next(), scanner.next(),
                                                scanner.next(), scanner.next(), scanner.next(), scanner.next());
                                        dbMagezine.add((Magazine) store.getProduct().get(store.getProduct().size() - 1));
                                        break;
                                    case "8":
                                        break;
                                }
                            } while (!number.equals("8"));
                        break;
                        case "2":
                            do {
                                System.out.println("please enter your personalId");
                                int personalId = scanner.nextInt();
                                if (dbCustomer.findCustomer(personalId) == 0) {
                                    String add = new String();
                                    do {
                                        System.out.println("1.add customer\n2. exit ");
                                        add = scanner.next();
                                        if (!add.matches("^([1-2])$")) {
                                            throw new InvalidInputException("Please Enter Valid Number Between 1-2");
                                        }
                                        if (add.equals("1")) {
                                            System.out.println("please enter personalId, name, balance,telephone");
                                            customer = new Customer(scanner.nextInt(), scanner.next(), scanner.nextInt(),
                                                    scanner.nextLong());
                                            store.getCustomers().add(customer);
                                            dbCustomer.addCustomer(customer);
                                        }

                                    } while (!add.equals("2"));
                                } else {
                                    System.out.println(" 1.addProductToCart\n2. deleteProductFromCart\n3.showCart\n" +
                                            "4.showTotalCost\n5.confirm\n6.exit");
                                    number = scanner.next();
                                    if (!number.matches("^([1-6])$")) {
                                        throw new InvalidInputException("Please Enter Valid Number Between 1-6");
                                    }
                                    customer = store.findCustomer(personalId);
                                    switch (number) {
                                        case "1":
                                            System.out.println(" 1.addBook\n2. addElectronic\n3.addMagazine\n" +
                                                    "4.addRadio\n5.addShoes\n6.addTV");
                                            String addCart=new String();
                                            addCart=scanner.next();
                                            if (!addCart.matches("^([1-6])$")) {
                                                throw new InvalidInputException("Please Enter Valid Number Between 1-6");
                                            }
                                            switch (addCart){
                                                case "1":
                                                    database.showProduct("book");
                                                    break;
                                                case "2":
                                                    database.showProduct("electronic");
                                                    break;
                                                case "3":
                                                    database.showProduct("magazine");
                                                    break;
                                                case "4":
                                                    database.showProduct("radio");
                                                    break;
                                                case "5":
                                                    database.showProduct("shoes");
                                                    break;
                                                case "6":
                                                    database.showProduct("TV");
                                                    break;

                                            }
                                            System.out.println("please enter barcode");
                                            barcode = scanner.nextInt();
                                            customer.addProductToCart(barcode,store);
                                            dbCustomer.addProductToOrder(customer);
                                            break;
                                        case "2":
                                            System.out.println("please enter barcode");
                                            barcode = scanner.nextInt();
                                            customer.deleteProductFromCart(barcode);
                                            dbCustomer.deleteProduct(barcode, customer.getId());
                                            break;
                                        case "3":
                                            customer.showCart();
                                            break;
                                        case "4":
                                            customer.showTotalCost();
                                            break;
                                        case "5":
                                            customer.confirm(database);
                                            break;
                                        case "6":
                                            break;

                                    }

                                }
                            } while (!number.equals("6"));
                            break;
                        case "3":
                            check = false;
                            break;


                    }
                }while (!input.equals("3")) ;
            } catch (InvalidInputException ex){
                System.out.println(ex.getMessage());
            }catch (NotFoundException ex){
                System.out.println(ex.getMessage());
            }
        } while (check != false);
    }
}
