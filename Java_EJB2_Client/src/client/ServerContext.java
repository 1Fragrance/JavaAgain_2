package client;

import beans.PaymentsBeanRemote;
import common.models.Payment;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ServerContext {

    PaymentsBeanRemote paymentsBean;

    public ServerContext() {
        try {
            Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
            Properties properties = new Properties();
            properties.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
            properties.setProperty("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            properties.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            InitialContext initialContext = new InitialContext(properties);

            paymentsBean = (PaymentsBeanRemote) initialContext.lookup("doPayment");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getPaymentsList()  {
        try {
            return paymentsBean.getAllPayments();
        }
        catch (IOException e) {
            System.err.println("DB error");
            e.printStackTrace();

            return new ArrayList();
        }
    }

    public void insertPayment(String value, String code) {

        try {
            double parsedValue = Double.parseDouble(value);
            paymentsBean.addPayment(new Payment(code, parsedValue));

            System.out.println("Payment info was successfully added");
        } catch(NumberFormatException e) {
            System.err.println("Incorrect data");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.err.println("Error during data insert");
            e.printStackTrace();
        }
    }
}
