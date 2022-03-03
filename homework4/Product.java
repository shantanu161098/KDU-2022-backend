import java.util.List;
import java.util.*;
import java.util.stream.*;

import javax.print.DocFlavor.STRING;

import java.util.Optional;
import java.util.Comparator;

class Product{
    public String name;
    public Double price;

    Product(String name,Double price){
        this.name = name;
        this.price = price;
    }

    public String get_name(){
        return name;
    }

    public double get_price(){
        return price;
    }
}

class Main{
    public static void main(String[] args) {
        
        ArrayList<Product> list_of_product = new ArrayList<>();
        list_of_product.add(new Product("rice",10.0));
        list_of_product.add(new Product("roti",20.0));
        list_of_product.add(new Product("sambar",40.0));
        list_of_product.add(new Product("water",50.0));
        list_of_product.add(new Product("Dal",30.0));

        double max_price = list_of_product.stream().max((p1,p2) -> p1.price.compareTo(p2.price)).get().price;
        System.out.println("Max price " + max_price);
        System.out.println();

        double min_price = list_of_product.stream().min((p1,p2) -> p1.price.compareTo(p2.price)).get().price;
        System.out.println("Min price " + min_price);
        System.out.println();
        // Any match => any uppercase 1st character in product name.

        boolean is_upper = list_of_product.stream().anyMatch(p -> Character.isUpperCase(p.name.charAt(0)));
        System.out.println("Answer of anymatch is " + is_upper);
        System.out.println();
        // All match => all defined 1st character in product name.

        boolean all_upper = list_of_product.stream().allMatch(p -> Character.isDefined(p.name.charAt(0)));
        System.out.println("Answer of all match is " + all_upper);
        System.out.println();
        // filtering the values dividible by 20.
        System.out.println("These are product which price are divisible by 20");
        System.out.println();
        list_of_product.stream().filter(p -> p.price.intValue() % 20 == 0).forEach(p -> System.out.println(p.name));
        System.out.println();
        List<Product> sorted_list =  list_of_product.stream().sorted((p1,p2) -> p1.price.compareTo(p2.price)).collect(Collectors.toList());
        System.out.println();
        System.out.println("After sorting");
        System.out.println();
        for(Product p: sorted_list){
            System.out.println(p.name + " " +p.price);
        }
        System.out.println();
        
        Map<String,Double> grouping_by_list = list_of_product.stream().collect(
                Collectors.groupingBy(Product::get_name, Collectors.summingDouble(Product::get_price)));


        System.out.println("Using grouping by " + grouping_by_list);
        System.out.println();
        Double average_price = list_of_product.stream().collect(Collectors.averagingDouble(Product :: get_price));
        System.out.println("Average price is " + average_price);
        System.out.println();
        list_of_product.stream().forEach(product -> product.price = product.price*1.25);
        Double average_price_after_increment = list_of_product.stream().collect(Collectors.averagingDouble(Product :: get_price));
        System.out.println();
        System.out.println("Average price after increment is " + average_price_after_increment);
        

    }
}