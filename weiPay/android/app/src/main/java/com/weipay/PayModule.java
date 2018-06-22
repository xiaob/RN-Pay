package com.weipay;

import android.content.Intent;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.union.alipay.util.PayResult;
import com.union.pay.service.OrderInfo;
import com.union.pay.service.WPayService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/20.
 */

public class PayModule extends ReactContextBaseJavaModule implements IWXAPIEventHandler {
    private static ArrayList<PayModule> modules = new ArrayList<>();
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";
    private ReactApplicationContext reactApplicationContext;
    private IWXAPI api;


    public PayModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactApplicationContext = reactContext;
    }

    @Override
    public void initialize() {
        super.initialize();
        modules.add(this);
    }

    @Override
    public String getName() {
        return "PayModel";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @Override
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        if (api != null) {
            api = null;
        }
        modules.remove(this);
    }



    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void Weipay(String nonceStr,String prepayId){
        api = WXAPIFactory.createWXAPI(reactApplicationContext, com.union.pay.Config.APP_ID);
        WPayService wPayService = new WPayService();
        OrderInfo orderInfo = new OrderInfo();
        OrderInfo.DataBean dataBean = new OrderInfo.DataBean();
        dataBean.setNonceStr(nonceStr);
        dataBean.setPrepayId(prepayId);
        orderInfo.setData(dataBean);
        wPayService.pay(api, orderInfo);
    }

    @ReactMethod
    public void AliaPay(String str,Callback callback){
        PayTask payTask = new PayTask(getCurrentActivity());
        Map<String, String> result = payTask.payV2(str, true);
        PayResult payResult = new PayResult(result);
        String resultStatus = payResult.getResultStatus();
        callback.invoke(resultStatus);
    }



    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        WritableMap map = Arguments.createMap();
        map.putInt("errCode", baseResp.errCode);
        this.getReactApplicationContext()
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("WeChat_Resp", map);
    }

    public static void handleIntent(Intent intent) {
        for (PayModule mod : modules) {
            mod.api.handleIntent(intent, mod);
        }
    }
}