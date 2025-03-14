package za.ac.tut.web;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import za.ac.tut.entity.Product;
import za.ac.tut.session.ProductBean;

@Path("/product")
public class ProductRessource {
    ProductBean service;
    @PostConstruct
    public void initialise() {
        try {
            InitialContext context = new InitialContext();
            service = (ProductBean) context.lookup("za.ac.tut.session.ProductBean");
        } catch (NamingException ex) {
            Logger.getLogger(ProductRessource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public String storeProduct(Product product) {
        service.addProduct(product);
        return "Product added: " + product.getName() + " is inserted";
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/store")
    public String addProduct(Product product) {
        service.addProduct(product);
        return "Product added: " + product.getName() + " is inserted";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{productID}")
    public Product findProduct(@PathParam("productID") int id) {
        return service.getProduct(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/get/all/xml")
    public List<Product> getAllProducts() {
        return service.getAllProduct();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public String updateProduct(Product product) {
        service.updateProduct(product);
        return "Product updated: " + product.getName();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete/{productID}")
    public String deleteProduct(@PathParam("productID") int id) {
        service.deleteProduct(id);
        return "Product with ID " + id + " deleted";
    }
}
