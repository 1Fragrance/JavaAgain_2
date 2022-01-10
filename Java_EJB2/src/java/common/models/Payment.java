/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package common.models;

import common.infrastructure.ISerializable;
import common.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class Payment implements ISerializable, Serializable {
    private Date createDate;
    private double value;
    private String creditCode;

    public Payment(String creditCode, double value) {
        this.value = value;
        this.creditCode = creditCode;
        this.createDate = DateUtils.getUTCdatetimeAsDate();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFileRepresentation() {
        return "code: " + getCreditCode() + " | amount: " + getValue() + " | date: " + createDate.toString() + "\n";
    }
}

