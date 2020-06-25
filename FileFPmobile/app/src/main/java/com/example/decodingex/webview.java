package com.example.decodingex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView web = (WebView) findViewById(R.id.web_view);
        web.loadUrl("https://fisik.id/");
        web.setWebViewClient(new WebViewClient());
    }
}
