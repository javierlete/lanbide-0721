package com.ipartek.formacion.uf1845.pruebas;

import com.paypal.core.*;

public class Credentials {
	static String clientId = "AaFce3GSUi8_VReV_xuhFLU9QCTFlvKe7z75z75M8G7BxCPKJ73BZQ-Ca_hs07Y1xZFJR6faQxRPdA6v";
	static String secret = "EL5oCJyVI6ZFZ_2q-5V9lbL3KM3THmm94D0sEOgWVyA8uriE-Om3axYjhlmQ4LWszo4Wz3fgCfxZVBrI";

	// Creating a sandbox environment
	private static PayPalEnvironment environment = new PayPalEnvironment.Sandbox(clientId, secret);

	// Creating a client for the environment
	static PayPalHttpClient client = new PayPalHttpClient(environment);

}
