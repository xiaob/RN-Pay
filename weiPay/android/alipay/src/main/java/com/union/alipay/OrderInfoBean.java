package com.union.alipay;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 
 * 订单信息
 * 
 */
public class OrderInfoBean implements Parcelable
{
	private String partner;
	private String seller;
	private String rsa_private;


	private String orderId;
	private String orderNo;
	private String orderDes;
	private String totalFee;
	private String couponFlag;
	private String cartDotNum;
	private String couponNum;
	private String msg;

	private String appid;
	private boolean rsa2;
	private String  pid;
	private String  rsa2_private;

	private String notify_url;
	private String  out_trade_no;
	private String  timeout_express="30m";
	private String  product_code="QUICK_MSECURITY_PAY";
	private String  total_amount;
	private String  subject="1";
	//    pcredit,moneyFund,debitCardExpress credit_group
	private String  disable_pay_channels;//禁止支付渠道
	private String  body;
	private String biz_content;



	public void setDisable_pay_channels(String disable_pay_channels) {
		this.disable_pay_channels = disable_pay_channels;
	}

	public String getDisable_pay_channels() {
		return disable_pay_channels;
	}


	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTimeout_express() {
		return timeout_express;
	}

	public void setTimeout_express(String timeout_express) {
		this.timeout_express = timeout_express;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getRsa2_private() {
		return rsa2_private;
	}

	public void setRsa2_private(String rsa2_private) {
		this.rsa2_private = rsa2_private;
	}

	public String getBiz_content() {
		return biz_content;
	}

	public void setBiz_content(String biz_content) {
		this.biz_content = biz_content;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public boolean isRsa2() {
		return rsa2;
	}

	public void setRsa2(boolean rsa2) {
		this.rsa2 = rsa2;
	}

	public static Creator<OrderInfoBean> getCREATOR() {
		return CREATOR;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getRsa_private() {
		return rsa_private;
	}

	public void setRsa_private(String rsa_private) {
		this.rsa_private = rsa_private;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public OrderInfoBean setNotify_url(String notify_url) {
		this.notify_url = notify_url;
		return this;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	
	public String getMsg()
	{
		return msg;
	}
	
	public void setCouponNum(String couponNum) {
		this.couponNum = couponNum;
	}
	
	public String getCouponNum() {
		return couponNum;
	}
	
	public void setCartDotNum(String cartDotNum)
	{
		this.cartDotNum = cartDotNum;
	}
	
	public String getCartDotNum()
	{
		return cartDotNum;
	}
	
	public String getCouponFlag()
	{
		return couponFlag;
	}
	
	public void setCouponFlag(String couponFlag)
	{
		this.couponFlag = couponFlag;
	}
	
	public OrderInfoBean()
	{
	}
	
	public String getOrderId()
	{
		return orderId;
	}
	
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}
	
	public String getOrderNo()
	{
		return orderNo;
	}
	
	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}
	
	public String getOrderDes()
	{
		return orderDes;
	}
	
	public void setOrderDes(String orderDes)
	{
		this.orderDes = orderDes;
	}
	
	public String getTotalFee()
	{
		return totalFee;
	}
	
	public String showTotalFee()
	{
		return totalFee;
	}
	
	public void setTotalFee(String totalFee)
	{
		this.totalFee = totalFee;
	}
	
	@Override
	public String toString()
	{
		return "OrderInfoBean [orderId=" + orderId + ", orderNo=" + orderNo + ", orderDes=" + orderDes + ", totalFee=" + totalFee
				+ ",couponFlag=" + couponFlag + ",partner="+ partner +",seller="+ seller +",rsa_private="+ rsa_private+"]";

	}
	
	@Override
	public int describeContents()
	{
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel out, int flags)
	{
		out.writeString(orderId);
		out.writeString(orderNo);
		out.writeString(orderDes);
		out.writeString(totalFee);
		out.writeString(couponFlag);
		out.writeString(cartDotNum);
		out.writeString(notify_url);
		out.writeString(partner);
		out.writeString(seller);
		out.writeString(rsa_private);
	}
	
	public static final Creator<OrderInfoBean> CREATOR = new Creator<OrderInfoBean>()
	{
		@Override
		public OrderInfoBean[] newArray(int size)
		{
			return new OrderInfoBean[size];
		}
		
		@Override
		public OrderInfoBean createFromParcel(Parcel in)
		{
			return new OrderInfoBean(in);
		}
	};
	
	public OrderInfoBean(Parcel in)
	{
		orderId = in.readString();
		orderNo = in.readString();
		orderDes = in.readString();
		totalFee = in.readString();
		couponFlag = in.readString();
		cartDotNum = in.readString();
		notify_url = in.readString();
		partner = in.readString();
		seller = in.readString();
		rsa_private = in.readString();
	}
}
