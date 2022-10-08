//Created by Campus
package sap_xep_don_hang;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.io.*;
//
class Product implements Comparable<Product>{
    private String name, code, typeCode, num;
    private int price, count, discount, total;
    public Product(Scanner sc){
        this.name = sc.nextLine();
        this.code = sc.nextLine();
        this.typeCode = this.code.substring(4);
        this.num = this.code.substring(1, 4);
        this.price = Integer.parseInt(sc.nextLine());
        this.count = Integer.parseInt(sc.nextLine());
    }
    
    private int getDiscount(){
        if(this.typeCode.compareTo("1") == 0)
            return this.price * this.count / 2;
        return 3 * this.price * this.count / 10;
    }
    private int getTotal(){
        return (this.price * this.count) - this.getDiscount();
    }
    //
    @Override
    public int compareTo(Product x){
        return this.num.compareTo(x.num);
    }
    //
    @Override
    public String toString(){
        return this.name + " " + this.code + " " + this.num + " " + this.getDiscount() + " " + this.getTotal();
    }
}
//

//
public class Sap_Xep_Don_Hang {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Product> set = new ArrayList<>();
        while(t-- > 0){
            set.add(new Product(sc));
        }
        Collections.sort(set);
        for(Product x : set){
            System.out.println(x);
        }
    }
    
}
