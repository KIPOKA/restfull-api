/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.session;

import java.util.List;
import javax.ejb.Remote;
import za.ac.tut.entity.Product;

/**
 *
 * @author ladyk
 */
@Remote
public interface ProductInterface {
    public void addProduct(Product product);
    public Product getProduct(int id);
    public List<Product> getAllProduct();
    public void updateProduct(Product product);
    public void deleteProduct(int id);
}
