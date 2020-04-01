package com.example.covid_19infodemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;






import androidx.annotation.Nullable;

public class worldstat extends Activity {
    private WebView webView;
    private ProgressBar progressBar;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worldstat);























        progressBar=(ProgressBar)findViewById(R.id.progressbarworldstat);


        webView=findViewById(R.id.webviewworldstat);
        webView.setWebViewClient(new WebViewClient());

        webView.clearCache(true);


        webView.loadUrl("https://www.worldometers.info/coronavirus/");

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                setTitle("Loading....");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                setTitle(view.getTitle());
            }
        });











        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webView.setInitialScale(0);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(true);












    }

    @Override
    public void onBackPressed() {

        if(webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }

    }

}
