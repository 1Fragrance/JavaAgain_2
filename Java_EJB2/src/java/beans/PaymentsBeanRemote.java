/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package beans;

import common.infrastructure.ISerializable;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author ILans
 */
@Remote
public interface PaymentsBeanRemote {
    void addPayment(ISerializable model) throws  IOException;
    ArrayList<String> getAllPayments() throws IOException;
}
