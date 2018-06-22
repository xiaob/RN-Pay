package com.union.pay.service;

import android.annotation.SuppressLint;
import android.util.Log;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.union.pay.Config;
import com.union.pay.utils.MD5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/15.
 */

public class WPayService {
    public void pay(IWXAPI api, OrderInfo orderInfo){
        PayReq req = new PayReq();
        //req.appId = "wxf8b4f85f3a794e77";  // 测试用appId
        req.appId			= Config.APP_ID;
        req.partnerId		= Config.MCH_ID;
        req.prepayId		= orderInfo.getData().getPrepayId();
        req.nonceStr		= orderInfo.getData().getNonceStr();
        req.timeStamp		= String.valueOf(genTimeStamp());
        req.packageValue	= "Sign=WXPay";
        List<Map<String,String>> signParams = new LinkedList<>();
        signParams.add(getMap("appid", req.appId));
        signParams.add(getMap("noncestr", req.nonceStr));
        signParams.add(getMap("package", req.packageValue));
        signParams.add(getMap("partnerid", req.partnerId));
        signParams.add(getMap("prepayid", req.prepayId));
        signParams.add(getMap("timestamp", req.timeStamp));
        req.sign			= genAppSign(signParams);
        // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
        api.sendReq(req);
    }

    private long genTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    @SuppressLint("DefaultLocale")
    private String genAppSign(List<Map<String,String>> signParams) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < signParams.size(); i++) {
            sb.append(signParams.get(i).get("name"));
            sb.append('=');
            sb.append(signParams.get(i).get("value"));
            sb.append('&');
        }
        sb.append("key=");
        sb.append(Config.API_KEY);
//        sb.append("sign str\n" + sb.toString() + "\n\n");
        String appSign = MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();

        Log.i("grage", "genAppSign: "+appSign);
        return appSign;
    }

    public Map<String,String> getMap(String key,String value){
        Map<String,String> map = new HashMap<>();
        map.put("name",key);
        map.put("value",value);
        return map;
    }
}
