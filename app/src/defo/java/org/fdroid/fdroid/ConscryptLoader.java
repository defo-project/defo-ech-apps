package org.fdroid.fdroid;

import android.util.Log;

import org.conscrypt.Conscrypt;

import java.security.Provider;
import java.security.Security;

public class ConscryptLoader {
    public static final String TAG = "ConscryptLoader";

    public static void installConscrypt() {
        Security.insertProviderAt(Conscrypt.newProviderBuilder().defaultTlsProtocol("TLSv1.3").build(), 1);

        Security.removeProvider("AndroidOpenSSL");
        for (Provider provider : Security.getProviders()) {
            Log.i(TAG, "TLS Provider: " + provider);
        }
        Conscrypt.checkAvailability();
    }
}