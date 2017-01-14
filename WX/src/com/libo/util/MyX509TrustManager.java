package com.libo.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/**
 * 信任管理�?
 * 
 * @author liufeng
 * @date 2013-04-10
 */
public class MyX509TrustManager implements X509TrustManager {

	// �?查客户端证书
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	// �?查服务器端证�?
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	// 返回受信任的X509证书数组
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}