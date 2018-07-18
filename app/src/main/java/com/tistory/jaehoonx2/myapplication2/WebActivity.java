package com.tistory.jaehoonx2.myapplication2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    int selectedIndex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.tistory.jaehoonx2.myapplication2.R.layout.activity_web);
        setTitle("My Fruit");

        webView = (WebView) findViewById(com.tistory.jaehoonx2.myapplication2.R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.addJavascriptInterface(new WebInterface(this), "Android");
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(com.tistory.jaehoonx2.myapplication2.R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == com.tistory.jaehoonx2.myapplication2.R.id.change){
            if(selectedIndex == 1)
                selectedIndex = 2;
            else
                selectedIndex = 1;

            webView.loadUrl("javascript:changeFruit(" + selectedIndex + ")");   // web과 통신
        }
        return super.onOptionsItemSelected(item);
    }
}
