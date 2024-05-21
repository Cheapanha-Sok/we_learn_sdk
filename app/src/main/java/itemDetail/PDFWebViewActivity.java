//package itemDetail;
//
//import android.os.Bundle;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.we_learn.R;
//
//public class PDFWebViewActivity extends AppCompatActivity {
//
//    private WebView webView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pdfweb_view);
//
//        webView = findViewById(R.id.webview);
//
//        String pdfUrl = getIntent().getStringExtra("pdfUrl");
//
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setBuiltInZoomControls(true);
//        webSettings.setDisplayZoomControls(false);
//
//        webView.setWebViewClient(new WebViewClient());
//
//        // Load the PDF URL
//        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + pdfUrl);
//    }
//}
//
//
////package itemDetail;
////
////import android.os.Bundle;
////import android.webkit.WebSettings;
////import android.webkit.WebView;
////import android.webkit.WebViewClient;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import com.example.we_learn.R;
////
////public class PDFWebViewActivity extends AppCompatActivity {
////
////    private WebView webView;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_pdfweb_view);
////
////        webView = findViewById(R.id.webview);
////
////        // Test with a static PDF URL
////        String pdfUrl = "https://res.cloudinary.com/di45ckqml/image/upload/v1716150125/pdf/omwgwtjolu2uae8jqoch.pdf";
////
////        WebSettings webSettings = webView.getSettings();
////        webSettings.setJavaScriptEnabled(true);
////        webSettings.setBuiltInZoomControls(true);
////        webSettings.setDisplayZoomControls(false);
////
////        webView.setWebViewClient(new WebViewClient());
////        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + pdfUrl);
////    }
////}
