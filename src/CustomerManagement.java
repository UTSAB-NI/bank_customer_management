
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;


public class CustomerManagement {


    public void createCustomer() {
        Customer c = new Customer();
        Scanner sc = new Scanner(System.in);
        //adding data in Customer
        System.out.println("Enter id:");
        int id = sc.nextInt();
        System.out.println("Enter Customer Name:");
        String name = sc.next();
        System.out.println("Enter Address:");
        String address = sc.next();
        System.out.println("Enter Contact Number:");
        Long contact = sc.nextLong();
        System.out.println("Enter Available Balance:");
        double balance = sc.nextDouble();
        System.out.println("Enter PIN code");
        int PIN = sc.nextInt();
        System.out.println("Enter Password");
        String password = sc.next();


        c.setId(id);
        c.setCustomer_name(name);
        c.setAddress(address);
        c.setContact_no(contact);
        c.setAvailable_balance(balance);
        c.setPIN(PIN);
        c.setPassword(password);
        System.out.println(c);

        //adding connection to sql and running query
        try {
            Connection con = DBConnection.getConnection();
            String query = "insert into customer_details values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getCustomer_name());
            ps.setString(3, c.getAddress());
            ps.setLong(4, c.getContact_no());
            ps.setDouble(5, c.getAvailable_balance());
            ps.setInt(6, c.getPIN());
            ps.setString(7, c.getPassword());
            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println("Customer created successfully ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }


    public void customerDetail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name:");
        String userName = sc.next();
        System.out.println("Enter Password:");
        String password = sc.next();


        try {
            Connection con = DBConnection.getConnection();
            String query = "select ID, `Customer Name`,Address,`Contact Number`,`Available Balance` from customer_details where `Customer Name`='" + userName + "' and  Password='" + password + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {


                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "" + rs.getLong(4) + "  " + rs.getDouble(5));
            } else {
                System.out.println("Credential not matched");
            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }


    public void addBalance() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name:");
        String userName = sc.next();
        System.out.println("Enter PIN");
        int pin = sc.nextInt();
        try {
            Connection con = DBConnection.getConnection();

            String query = "select  * from customer_details where `Customer Name`='" + userName + "' and  PIN='" + pin + "'";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //show current balance
                System.out.println("Your current balance is: ");
                String currentBalance = "select `Available Balance` from customer_details where `Customer Name`='" + userName + "' and  PIN='" + pin + "'";
                PreparedStatement ps1 = con.prepareStatement(currentBalance);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    System.out.println(rs1.getDouble(1));
                }
                //add new balance
                String addAmount = "update customer_details set `Available Balance`=`Available Balance`+ ? where `Customer Name`='" + userName + "' and  PIN='" + pin + "'";
                PreparedStatement ps2 = con.prepareStatement(addAmount);
                System.out.println("Enter amount to add");
                double amount = sc.nextDouble();
                ps2.setDouble(1, amount);
                int i = ps2.executeUpdate();
                if (i != 0) {
                    System.out.println("Successfully added ");
                } else {
                    System.out.println("Something went wrong!!");
                }
                //show new balance
                System.out.println("Your New balance is: ");
                String newBalance = "select `Available Balance` from customer_details where `Customer Name`='" + userName + "' and  PIN='" + pin + "'";
                PreparedStatement ps3 = con.prepareStatement(newBalance);
                ResultSet rs3 = ps3.executeQuery();
                if (rs3.next()) {
                    System.out.println(rs3.getDouble(1));
                }
            } else {
                System.out.println("Credential not matched");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void withdrawBalance() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name:");
        String userName = sc.next();
        System.out.println("Enter PIN");
        int pin = sc.nextInt();
        try {
            Connection con = DBConnection.getConnection();

            String query = "select  * from customer_details where `Customer Name`='" + userName + "' and  PIN='" + pin + "'";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //show current balance
                System.out.println("Your current balance is: ");
                String currentBalance = "select `Available Balance` from customer_details where `Customer Name`='" + userName + "' and  PIN='" + pin + "'";
                PreparedStatement ps1 = con.prepareStatement(currentBalance);
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    System.out.println(rs1.getDouble(1));
                }
                //withdraw  balance
                String addAmount = "update customer_details set `Available Balance`=`Available Balance`- ?" +
                        " where `Customer Name`='" + userName + "' and  PIN='" + pin + "'";
                PreparedStatement ps2 = con.prepareStatement(addAmount);
                System.out.println("Enter amount to withdraw");
                double withdrawAmount = sc.nextDouble();
                ps2.setDouble(1, withdrawAmount);
                int i = ps2.executeUpdate();
                if (i != 0) {
                    System.out.println("Successfully withdrawn");
                } else {
                    System.out.println("Something went wrong!!");
                }

                //show new balance

                System.out.println("Your New balance is: ");
                String newBalance = "select `Available Balance` from customer_details where `Customer Name`='" + userName + "' and  PIN='" + pin + "'";
                PreparedStatement ps3 = con.prepareStatement(newBalance);
                ResultSet rs3 = ps3.executeQuery();
                if (rs3.next()) {
                    System.out.println(rs3.getDouble(1));
                }


            } else {
                System.out.println("Credential not matched");
            }


        } catch (Exception e) {
            System.out.println(e);
        }


    }


}
