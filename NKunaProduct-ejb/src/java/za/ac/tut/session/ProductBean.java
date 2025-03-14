/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.session;

 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext; 
import javax.persistence.Query;
import za.ac.tut.entity.Product;

/**
 *
 * @author ladyk
 */
@Stateless
public class ProductBean implements ProductInterface {

    @PersistenceContext(unitName ="productUnit")
    private EntityManager manager;

    @Override
    public void addProduct(Product product) {
        manager.persist(product);
    }

    @Override
    public Product getProduct(int id) { 
    return manager.find(Product.class, id);
    }

    @Override
    public List<Product> getAllProduct() {
        String sql= "select product from Product product";
        
        Query query = manager.createQuery(sql);
         List <Product> list = (List<Product>) query.getResultList();
        return list;
    }

    @Override
    public void updateProduct(Product product) {
        if (getProduct(product.getId())!=null) {
            manager.merge(product);
        }
    
    }

    @Override
    public void deleteProduct(int id)
    {
         if (getProduct(id)!=null) {
            manager.remove(id);
        }
    }
     
}
