package judy.ieeecompute;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        WebView wv = (WebView) findViewById(R.id.wView);
        WebSettings webSetting = wv.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);
        wv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.loadUrl("file:///android_asset/book.htm");
        wv.setWebViewClient(new WebViewClient());

    }
    private class WebViewClient extends android.webkit.WebViewClient
    {

        @Override
        public void onPageFinished(WebView view, String url) {

            getSupportActionBar().show();
            findViewById(R.id.iView).setVisibility(View.GONE);
            //show webview
            findViewById(R.id.wView).setVisibility(View.VISIBLE);
        }
    }

}
