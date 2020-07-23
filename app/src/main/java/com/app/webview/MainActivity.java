package com.app.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webview);
//        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setDomStorageEnabled(true);
//
//        //zoom
//        webView.getSettings().setSupportZoom(true);
//        webView.getSettings().setBuiltInZoomControls(true);
//        webView.getSettings().setDisplayZoomControls(true);
//
        //scroll
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());

        // add javascript
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        webView.loadUrl("http://dulursayur.com/");


        getUserAgent(webView);

    }

    void getUserAgent(WebView webView) {
        String userAgent = webView.getSettings().getUserAgentString();

        Log.d("TAG1", userAgent);
    }
}
