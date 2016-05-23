package com.DontFretGuitarsWebSystem.controller.admin;

import com.DontFretGuitarsWebSystem.model.Customer;
import com.DontFretGuitarsWebSystem.service.CustomerService;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * Created by danielwalker on 18/05/2016.
 */

// Controller actions for the admin performing methods with the customer list

@Controller
@RequestMapping("/admin")
public class AdminCustomer {

    @Autowired
    CustomerService customerService;    //Mark this for dependency injection from the customer service

    // Controller method to edit the customer on the list by fetching the id
    @RequestMapping("/customer/editCustomer/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);

        return "editCustomer";
    }

    // Controller POST method to make the changes to the customer details
    @RequestMapping(value = "/customer/editCustomer", method = RequestMethod.POST)
    public String editCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
                                  HttpServletRequest request ) {
        if(result.hasErrors()) {
            return "editCustomer";
        }

        customerService.editCustomer(customer);

        return "redirect:/admin/customer";
    }

    // Controller action to view a PDF report of the customer table through Dynamic Reports and JasperReports
    @RequestMapping("/customer/customerReport")
    public String viewCustomerReport() {
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
                        Columns.column("Id", "customerId", DataTypes.integerType()),
                        Columns.column("First Name", "firstName", DataTypes.stringType()),
                        Columns.column("SecondName", "secondName", DataTypes.stringType()),
                        Columns.column("Email Address", "email", DataTypes.stringType()),
                        Columns.column("Phone No", "phoneNo", DataTypes.stringType()),
                        Columns.column("Street Name", "streetName", DataTypes.stringType()),
                        Columns.column("House Name", "houseName", DataTypes.stringType()),
                        Columns.column("City", "city", DataTypes.stringType()),
                        Columns.column("County", "county", DataTypes.stringType()),
                        Columns.column("Postcode", "postCode", DataTypes.stringType()))
                .title( //title of the report
                        Components.text("Customer Report")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                                .setStyle(boldCenteredStyle))
                .pageFooter(Components.pageXofY().setStyle(boldCenteredStyle)) //Show page number on the page footer
                .setDataSource("SELECT customerId, firstName, secondName, email, phoneNo, streetName, houseName, city, county, postCode FROM customer", connection);

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

        return "customerReport";
    }


}
