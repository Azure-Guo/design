package com.axin.design.pay.pojo;

public class PayBody {
    // 账户名
    private String account;
    // 支付类型
    private int type;
    // 产品信息
    private String product;
    // 价格
    private int amount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
