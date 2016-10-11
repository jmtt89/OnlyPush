package com.ogangi.onlypush;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ogangi.messangi.android.sdk.Messangi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here the Credentials sent to you in the Email
        Messangi.getInstance().setAppName("App name on Email");
        Messangi.getInstance().setClientId("");
        Messangi.getInstance().setApiClientPrivateKey("");
        // GCM Credentials
        Messangi.getInstance().setGcmApiKey(getString(R.string.gcm_api_key));
        Messangi.getInstance().setGcmProjectId(getString(R.string.gcm_defaultSenderId));

        Messangi.getInstance().init(this);
        Messangi.getInstance().requestReadSMSPermission(this);
        Messangi.getInstance().requestLocationPermissions(this);
//        Messangi.getInstance().addMessangiListener(Listener.getIntance());
        Messangi.getInstance().registerDialog(this, this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        try {
            Messangi.getInstance().onRequestPermissionsResult(requestCode,permissions,grantResults);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
