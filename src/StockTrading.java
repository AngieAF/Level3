public class StockTrading {
    public static void main(String[] args) {
        Trader trader = Trader.createTrader("john", "089*", "John",
                "Smith", 456789);
        if(!trader.authenticate(trader.login, trader.psw))
            System.out.println("Wrong login or password");
        else System.out.println("Successful login");


        Account account = Account.createAccount(20000, 89045, trader.login, trader.psw,
                trader.firstName, trader.lastName, trader.traderId);
        account.set_trading();
        account.add_funds(1500);

        Order order = Order.createOrder(10000, "market", 13456);
        order.setOrderId(order.getOrderAmount(), order.getOrderType(), order.getInstrumentId());
        order.cancel(order.getOrderId());

        System.out.println("Account " + account.accountId + " has a balance of " + account.amount);

    }
}

class Trader {
    protected String login;
    protected String psw;
    protected String firstName;
    protected String lastName;
    protected int traderId;

    protected boolean authenticator = false;

    Trader(String login, String psw, String name, String surname, int trader)
    {
        this.login = login;
        this.psw = psw;
        this.firstName = name;
        this.lastName = surname;

        this.traderId = trader;
    }

    static Trader createTrader(String login, String psw, String name, String surname, int trader) {
        return new Trader(login, psw, name, surname, trader);
    }

    boolean authenticate(String login, String psw) {
        if ((this.login == login) && (this.psw == psw))
            this.authenticator = true;

        return this.authenticator;
    }
}

class Order {
    private int orderId;
    private double orderAmount;
    private String orderType;

    private int instrumentId;
    private boolean markToCancel;

    private Order(int amount, String type, int instrument)
    {
        this.orderAmount = amount;
        this.orderType = type;
        this.instrumentId = instrument;
        this.markToCancel = false;
    }

    static Order createOrder(int amount, String type, int instrument) {
        return new Order(amount, type, instrument);
    }

    void setOrderId(double amount, String type, int instrument) {

        this.orderId = (int) (instrument + amount);
    }

    void cancel(int order) {
        this.orderId = order;
        this.markToCancel = true;
    }

    double getOrderAmount() { return orderAmount; }
    String getOrderType() { return  orderType; }
    int getInstrumentId() { return instrumentId; }
    int getOrderId() { return orderId; }

}

class Account extends Trader {
    protected boolean isMargin;
    protected boolean isTradable;

    protected double amount;
    protected int accountId;

    private Account(double amount, int account, String login, String psw, String name,
                    String surname, int trader)
    {
        super(login, psw, name, surname, trader);
        this.isTradable = false;
        this.isMargin = false;
        this.amount = amount;
        this.accountId = account;
    }

    static Account createAccount(double amount, int account, String login, String psw, String name,
                                 String surname, int trader) {
        return new Account(amount, account, login, psw, name, surname, trader);
    }

    void add_funds(double funds) {
        this.amount += funds;
    }

    void withdraw_funds(double funds) {
        this.amount -= funds;
    }

    void set_trading() { this.isTradable = true; }

    void set_margin() { this.isMargin = true;}
}

class FinInstrument {
    String instrumentType;
    int lotSize;

    String companyName;
    int issuerId;

    FinInstrument(String type, int lot, String company, int issuer)
    {
        this.instrumentType = type;
        this.lotSize = lot;
        this.companyName = company;
        this.issuerId = issuer;
    }

    void setInstrumentId(String type, String company) {
        this.instrumentType = type;
        this.companyName = company;

        this.issuerId = Integer.valueOf(company + type);
    }
}