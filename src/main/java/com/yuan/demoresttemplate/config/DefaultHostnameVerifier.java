package com.yuan.demoresttemplate.config;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * @author mac
 */
public class DefaultHostnameVerifier implements HostnameVerifier {

	@Override
	public boolean verify(String hostname, SSLSession session) {
		return true;
	}

}
