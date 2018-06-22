/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import NativeModules  from 'react-native';
import PayModel from './modulesImport'
import { DeviceEventEmitter  } from 'react-native';
import {
  Platform,
  StyleSheet,
  Text,
  View
} from 'react-native';




DeviceEventEmitter.addListener('WeChat_Resp', resp => {
	/**
		errCode值列表：
		0	成功	展示成功页面
		-1	错误	可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。
		-2	用户取消
	*/
	PayModel.show(resp.errCode+"==="+resp,PayModel.SHORT)
	
});

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' +
    'Cmd+D or shake for dev menu',
  android: 'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

type Props = {};
export default class App extends Component<Props> {
	
	 _weiPay() {
		PayModel.Weipay("3Mm5UspPTG549PxB","wx201802281227471d687333b60035551761");
  }
  
   _aliaPay() {
		 PayModel.AliaPay("app_id=2018042302594820&biz_content=%7B%22body%22%3A%22ONENATION%E8%AE%A2%E5%8D%95%E6%94%AF%E4%BB%98%22%2C%22subject%22%3A%22ONENATION%22%2C%22out_trade_no%22%3A%222018062010272122485%22%2C%22total_amount%22%3A%220.01%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22goods_type%22%3A%221%22%7D&charset=UTF-8&format=JSON&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Fonenation.unionht.top%2Fapp%2Fv1%2Findex%2Findex%2Fop%2ForderPayAliNotify%2Fotype%2F1&sign_type=RSA2&timestamp=2018-06-21+12%3A03%3A41&version=1.0&sign=SqMoEEJhF4uQ5bIGO1VO9ISFFrTItLhpSIbQW4GGW9S2yntUrSlu%2Bubwv2O3aVMXrq6kmRpjECpiouFvzPYdQdjNlF4ZF%2FimoSq0S3dpsfyQMb%2FT1Sy6InOTIbEhKekxnH34lVMLuGLQF4mc7etNeMIZOb0VevXPWxGMdY9ykidF1TgF37I68pw0%2Fjx9eg1xRPcfdClsyHswHpts9mw05S3%2FqvD%2FV%2BBRzkVYr4FH0LzbNVHF2vp9zACg6yVVY7SA4s0m9qh5vgUSU8E%2B6wUVCfRXcgQSEy4W11ndWCAC%2Fg%2Fg7wKXVJAslb2cFkcHJ5NmimkhDyRZIsTRPj%2Fd2%2FyTWw%3D%3D",
            (result) => {
                PayModel.show("CallBack收到消息:"+result,PayModel.SHORT);
            }
        );
  }
  


	
	
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome} onPress = {
			()=>this._weiPay()
		}>
			微信支付
        </Text>
        <Text style={styles.welcome}  onPress = {
		()=>this._aliaPay()}>
			支付宝支付
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
