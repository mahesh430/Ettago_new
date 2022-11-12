package com.ettago.Ettago;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Support extends AppCompatActivity {

    ProgressBar progressBar;
    WebView webView;

    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        webView = findViewById(R.id.webview_bookings);
        progressBar = findViewById(R.id.progressBar_bookings);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation_bookings);

        url="https://book.ettago.com/CustomerSupport";
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        // WebSettings.ZoomDensity zoomDensity = WebSettings.ZoomDensity.FAR;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setDomStorageEnabled(true);
        // webView.getSettings().setDefaultZoom(zoomDensity);
        //webView.getSettings().setSupportZoom(true);
        //webView.getSettings().setBuiltInZoomControls(true);
        webView.requestFocus(View.FOCUS_DOWN);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        webView.setWebChromeClient(webChromeClient);
        webView.setWebViewClient(this.getWebViewClient());
        progressBar.setProgress(0);
        progressBar.setVisibility(View.VISIBLE);
        webView.loadUrl(url);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch(menuItem.getItemId()){
                            case R.id.home:
                                Intent intent2=new Intent(Support.this,Home.class);
                                startActivity(intent2);
                                return true;
                            case R.id.support:


                                return true;
                            case R.id.offers:
                                Intent intent1=new Intent(Support.this,Offers.class);
                                startActivity(intent1);

                                return  true;

                            case R.id.aboutus:
                                Intent intent=new Intent(Support.this,AboutUs.class);
                                startActivity(intent);
                                return true;
                        }
                        return true;
                    }
                }
        ) ;
        MenuItem item = bottomNavigationView.getMenu().findItem(R.id.support);
        item.setChecked(true);

    }
    WebChromeClient webChromeClient=new WebChromeClient(){
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);
        }
    };


    public WebViewClient getWebViewClient() {

        return new WebViewClient() {

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                progressBar.setVisibility(View.VISIBLE);

                //Some checks
                if (url.contains("load.elsewhere.com")) {
                    //If you want to handle where load.elsewhere.com is loaded, say in another external browser
                    progressBar.setIndeterminate(true);

                    //startActivity to load elsewhere

                    return true;
                }

                return super.shouldOverrideUrlLoading(view, url);
            }
        };

    }

}

