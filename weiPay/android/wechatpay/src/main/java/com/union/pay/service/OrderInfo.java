package com.union.pay.service;

/**
 * Created by Administrator on 2017/11/15.
 */

public class OrderInfo {


    /**
     * message : 微信统一下单成功
     * data : {"prepayId":"wx201802281227471d687333b60035551761","nonceStr":"3Mm5UspPTG549PxB"}
     * status : 1
     */

    private String message;
    private DataBean data;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * prepayId : wx201802281227471d687333b60035551761
         * nonceStr : 3Mm5UspPTG549PxB
         */

        private String prepayId;
        private String nonceStr;

        public String getPrepayId() {
            return prepayId;
        }

        public void setPrepayId(String prepayId) {
            this.prepayId = prepayId;
        }

        public String getNonceStr() {
            return nonceStr;
        }

        public void setNonceStr(String nonceStr) {
            this.nonceStr = nonceStr;
        }
    }
}
