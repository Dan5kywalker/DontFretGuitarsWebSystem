package com.DontFretGuitarsWebSystem.controller.admin;

import com.DontFretGuitarsWebSystem.model.Product;
import com.DontFretGuitarsWebSystem.service.ProductService;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * Created by danielwalker on 02/05/2016.
 */

// Controller for admin actions relating to the product model
@Controller
@RequestMapping("/admin")
public class AdminProduct {

    // Define the path variable for the product image
    private Path path;

    // Define bean for injection of dependencies and use of productService interface actions
    @Autowired
    private ProductService productService;

    // Controller action for adding a new product and giving the product default values
    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setProductCategory("Acoustic Guitar");
        product.setProductCondition("New");
        product.setProductStatus("Active");

        model.addAttribute("product", product);

        return "addProduct";
    }

    // Controller action to add the product to the db through a post method
    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {
        if (result.hasErrors()) { // If there are errors, return the addProduct page
            return "addProduct";
        }

        productService.addProduct(product);

        // Upload the product image by getting the path from the project resources file
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }

        }

        return "redirect:/admin/productInventory";
    }

    // Controller action for returning the edit product page
    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);

        return "editProduct";
    }

    // Controller action for posting the changes made to the product to the db
    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                  HttpServletRequest request) {
        if (result.hasErrors()) { // if there are errors, return the editProduct page
            return "editProduct";
        }

        // Fetch the product image through the same way used in the addProduct POST controller method
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//" + product.getProductId() + ".png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    // Controller action to remove the product from the dbm, including the image from the resources folder
    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }

    //  Controller action to view a PDF report of the priduct table through Dynamic Reports and JasperReports
    @RequestMapping("/product/productReport")
    public String viewProductReport() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JasperReportBuilder report = DynamicReports.report(); // A new report

        StyleBuilder boldStyle = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle  = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);



        report
                .setColumnTitleStyle(columnTitleStyle)
                .highlightDetailEvenRows()
                .columns(
                        Columns.column("Id", "productId", DataTypes.integerType()),
                        Columns.column("Manufacturer", "productManufacturer", DataTypes.stringType()),
                        Columns.column("Name", "productName", DataTypes.stringType()),
                        Columns.column("Category", "productCategory", DataTypes.stringType()),
                        Columns.column("Price(£)", "productPrice", DataTypes.doubleType()),
                        Columns.column("Condition", "productCondition", DataTypes.stringType()),
                        Columns.column("Unit's In Stock", "unitInStock", DataTypes.integerType()))
                .title( //title of the report
                        Components.text("Product Report")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                                .setStyle(boldCenteredStyle))
                .pageFooter(Components.pageXofY().setStyle(boldCenteredStyle)) //Show page number on the page footer
                .setDataSource("SELECT productId, productManufacturer, productName, productCategory, productPrice, productCondition, unitInStock FROM product", connection);

        try {
            // Show the report
            report.show();

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //export the report to a pdf file
            report.toPdf(new FileOutputStream("c:/report.pdf"));
        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "productReport";
    }
}



