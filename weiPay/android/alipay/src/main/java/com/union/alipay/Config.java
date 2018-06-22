package com.union.alipay;

/**
 * Created by Administrator on 2017/6/2.
 */

public class Config {
    /** 支付宝支付业务：入参app_id */
    public static final String APPID = "2018010201518472";

    /** 支付宝账户登录授权业务：入参pid值 */
    public static final String PID = "2088921115537927";
    /** 支付宝账户登录授权业务：入参target_id值 */
    public static final String TARGET_ID = String.valueOf(System.currentTimeMillis());
    /** 商户私钥，pkcs8格式 */
    /** 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个 */
    /** 如果商户两个都设置了，优先使用 RSA2_PRIVATE */
    /** RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议使用 RSA2_PRIVATE */
    /** 获取 RSA2_PRIVATE，建议使用支付宝提供的公私钥生成工具生成， */
    /** 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1 */
    public static final String RSA2_PRIVATE = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCC+PWr/SkMP0VcPpStldN2IX+xl/KKrl4hKT5Q+ZxIQ+WJ0BjLPqqV9QNgraQVUI0xN6z+Znh7fsv9+Ud9CYuyi7uFQGodi5hxPneV+HX5mnCeqymRj1wRImnglYCzFDn6wYjvRjg20wo4DZhApQyt+m+CS1U/PkuIH03WcIYpqp3UsNjmEALzFM0iiPHTJYVSuW59StFQSXBJKc76dhc288TJ1jk85uMhux9sw7ldbnyyzkbSKk6cdkjxT+dmdHYsc4blj4EinC3uyKwZG88ghKyjlERKhKoFCMckpbpCD+yrkLq6anEfSx48NGEFs9jvBsax/JAKP5fWXvuJgF3XAgMBAAECggEAOgZoeTEovWdOqGaFYj5NuDlxJFIoP26u/0wRcriTl6SVDjBmu6zg0J0DSRLE7jiIxTRgbTkiybvMTpHhLTFMdebYRlnaaYqOGCXPv16bjeDxYip8uSNla6XueHRj13LvmPujWjam8wserOTA/mrhKjcYrgYIF4PW3NDZoFar6cstrSCz86b80VrZcq5+mbXDGYUNNvGXnhB0EKWgpZCZePjCxKWOeBkAXQGaa8tjdn6pr1frVOH1R+pUnIe3tYaF1aCWkfK4LWRAsfO8UI/lAG4cn25nMIcAgPextyLkIzvfmTjU+wzp2V/6TiXQw+0LwWYBTX1KHQTA3wdCZlUxSQKBgQDByyYYh6GhB2M5VQrpw/dlFvZHROhmCEpOtBST8EMSpl91KzAPJ5oQVSXvn/o44NpDT/lEB+Z9oJglucsXGzWFeeISewXvNmSTkuAbYwqePZNJdx2E4T6XyMAfFehdy3SapxSILUaWKC8SuKJzdhle1r5GyRdXor60Q7E66P8LzQKBgQCtA4jI2P7+b6Ij/8jgREFHKqW0+qih3HSo8HAheBCoafEBf3y0wlibjVbP13URjYhqrDgQNhNx9Lh5yquz/UjNn1Wu1R90/Aox5yIO5899reGs1aAjRcZmztHXlRiEZOb2YdXNYwE7aUpfPRGUmapMHpAfUNVIZUGemZTL9dkUMwKBgGmgmcYa/zzu8uVH9ifOWWTvLBNSer1KXX4iZ2jvNw/OQQ9zF8Ha2v11+7RtZQxlenHgAERVbgshYmyFpS2V9gknktJx3Z0x74YEM0SaKipv83zCgQNxZhWDJTyMS1f8UjUNRoKm8udbRbUVj+4Q++kWcSXR63gny3wjvVEXuBQtAoGAF7ToRT0Wk56QRQaDa9duamX5lrbR7HvcsFlhw/RDtA/wKhhh6hLHOWlAf/Ix5FnUW2mFtRLzzyWNMYMHy/3kv+gZQX+Kc+klLHlTPV+eGsZ8qcYLz0l8ShIExtlzJpD85L27Ig1y2cUvn6Uqh4YWw59ceC4HS4g0WZsJvHjPaekCgYAeuMz17KrLnlH9CzvQzvlPMahYmkA0D+Q0cmh1hyWT0WSHvDECE0ZR+r5yTwCr6re23aSCXwsZ4jrfhszvGXTLpNbT6yjQSMqTVYf3u6xHL4fuouwFzSqZ/Xyw//SiwMqn2iI6aUIZugxwpy5grf/PeHb4BJU2cCBHz87N5bfC9g==";
    public static final String RSA_PRIVATE = "";

    public static final String ORDERNOTIFY_URL = "http://47.104.96.31:8081/order/alipay/callBack";
    public static final String ORDERYJ_URL = "http://47.104.96.31:8081/order/alipayDeposit/callBack";
    public static final String Reward_URL = "http://47.104.96.31:8081/order/alipayReward/callBack";

    public static final int SDK_PAY_FLAG = 1;
    public static final int SDK_AUTH_FLAG = 2;



}
