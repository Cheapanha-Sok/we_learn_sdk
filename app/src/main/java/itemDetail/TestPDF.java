////package itemDetail;
////
////import android.os.Bundle;
////import android.webkit.WebView;
////import android.webkit.WebViewClient;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import com.example.we_learn.R;
////
////public class TestPDF extends AppCompatActivity {
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_test_pdf);
////        String url = getIntent().getStringExtra("pdf_url");
////        WebView webView = findViewById(R.id.testPDF);
////        webView.setWebViewClient(new WebViewClient());
////        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + url);
////
////
////
////
////    }
////}
//package itemDetail;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.os.AsyncTask;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.we_learn.R;
//import com.github.barteksc.pdfviewer.PDFView;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class TestPDF extends AppCompatActivity {
//
//    private PDFView pdfView;
//    private Context context;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test_pdf);
//
//        pdfView = findViewById(R.id.testPDF);
//        context = this;
//
//        String url = getIntent().getStringExtra("pdf_url");
//        new DownloadFile(context).execute(url);
//    }
//
//    private static class DownloadFile extends AsyncTask<String, Void, File> {
//
//        private Context context;
//
//        public DownloadFile(Context context) {
//            this.context = context;
//        }
//
//        @Override
//        protected File doInBackground(String... strings) {
//            String fileUrl = strings[0];
//            File pdfFile = new File(context.getCacheDir(), "downloaded.pdf");
//
//            try {
//                URL url = new URL(fileUrl);
//                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                urlConnection.connect();
//
//                InputStream inputStream = urlConnection.getInputStream();
//                FileOutputStream fileOutputStream = new FileOutputStream(pdfFile);
//                byte[] buffer = new byte[1024];
//                int bufferLength;
//
//                while ((bufferLength = inputStream.read(buffer)) > 0) {
//                    fileOutputStream.write(buffer, 0, bufferLength);
//                }
//                fileOutputStream.close();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//            return pdfFile;
//        }
//
//        @Override
//        protected void onPostExecute(File file) {
//            if (file != null) {
//                PDFView pdfView = ((AppCompatActivity) context).findViewById(R.id.testPDF);
//                pdfView.fromFile(file)
//                        .load();
//            } else {
//                Toast.makeText(context, "Failed to download PDF", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//}
