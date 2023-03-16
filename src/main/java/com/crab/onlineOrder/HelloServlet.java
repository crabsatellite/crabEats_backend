package com.crab.onlineOrder;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;

import com.crab.onlineOrder.entity.Customer;
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        String customer = request.getParameter("customer");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Hello " + customer + "</h1>");
//        out.println("</body></html>");

        response.setContentType("application/json");

        // Hello
//        JSONObject customer = new JSONObject();
//        customer.put("name", "John");
//        customer.put("age", 30);
//        response.getWriter().print(customer);

        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = new Customer();
        customer.setEmail("example@gmail.com");
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setPassword("123456");

        response.getWriter().print(objectMapper.writeValueAsString(customer));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
//        String name = jsonRequest.getString("name");
//        int age = jsonRequest.getInt("age");
//
//        System.out.println("name: " + name);
//        System.out.println("age: " + age);
//
//        response.setContentType("application/json");
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("name", name);
//        jsonResponse.put("age", age);
//        response.getWriter().print(jsonResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(request.getReader(), Customer.class);
        System.out.println("email: " + customer.getEmail());
        System.out.println("firstName: " + customer.getFirstName());
        System.out.println("lastName: " + customer.getLastName());
        System.out.println("password: " + customer.getPassword());

        response.setContentType("application/json");
        response.getWriter().print(objectMapper.writeValueAsString(customer));
    }

    public void destroy() {
    }
}