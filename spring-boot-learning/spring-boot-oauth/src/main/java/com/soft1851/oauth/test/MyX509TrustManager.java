package com.soft1851.oauth.test;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class MyX509TrustManager implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        //不需要对客户端进行认证，因此我们只需要执行默认的信任管理器的这个方法
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        //简单不做任何处理，即一个空的函数体，由于不会抛出异常，它就会信任任何证书。
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        //返回受信任的X509证书数组。
        return new X509Certificate[0];
    }
}
