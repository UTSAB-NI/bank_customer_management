

public class Customer {
    private int id;
    private String customer_name;
    private String address;
    private Long contact_no;
    private double available_balance;
    private int PIN;
    private String password;


    public Customer(){

    }


    public Customer(int id, String customer_name, String address, Long contact_no, double available_balance, int PIN, String password) {
        this.id = id;
        this.customer_name = customer_name;
        this.address = address;
        this.contact_no = contact_no;
        this.available_balance = available_balance;
        this.PIN = PIN;
        this.password = password;
    }

    @Override
    public String toString() {
        return "customer{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                ", address='" + address + '\'' +
                ", contact_no=" + contact_no +
                ", available_balance=" + available_balance +
                ", PIN=" + PIN +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContact_no() {
        return contact_no;
    }

    public void setContact_no(Long contact_no) {
        this.contact_no = contact_no;
    }

    public double getAvailable_balance() {
        return available_balance;
    }

    public void setAvailable_balance(double available_balance) {
        this.available_balance = available_balance;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
