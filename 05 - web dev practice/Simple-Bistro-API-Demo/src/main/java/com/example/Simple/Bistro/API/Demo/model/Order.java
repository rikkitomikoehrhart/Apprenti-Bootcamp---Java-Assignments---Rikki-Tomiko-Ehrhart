package com.example.Simple.Bistro.API.Demo.model;

import java.math.BigDecimal;

public class Order {
    private Integer orderID;
    private BigDecimal subtotal;
    private BigDecimal tip;
    private BigDecimal tax;
    private BigDecimal total;

    public Order() {}

    public Order(Integer orderID, BigDecimal subtotal, BigDecimal tip, BigDecimal tax, BigDecimal total) {
        this.orderID = orderID;
        this.subtotal = subtotal;
        this.tip = tip;
        this.tax = tax;
        this.total = total;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTip() {
        return tip;
    }

    public void setTip(BigDecimal tip) {
        this.tip = tip;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{orderID=" + orderID + ", subtotal=" + subtotal + ", tip=" + tip + ", tax=" + tax + ", total=" + total + "}";
    }
}
