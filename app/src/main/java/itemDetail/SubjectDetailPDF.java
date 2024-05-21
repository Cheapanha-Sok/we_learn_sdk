package itemDetail;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.we_learn.R;
import com.example.we_learn.client.ApiClient;
import com.example.we_learn.client.ApiInterface;

import ApiResponse.PDFResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubjectDetailPDF extends AppCompatActivity {

    private WebView webView;
    private int subjectID;
    private int yearID;
    private static final String TAG = "SubjectDetailPDF";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfweb_view); // Ensure the correct layout file is referenced

        webView = findViewById(R.id.webview);

        // Retrieve the subjectID and yearID passed via Intent
        subjectID = getIntent().getIntExtra("subjectID", -1);
        yearID = getIntent().getIntExtra("yearID", -1);

        // Log the retrieved subjectID and yearID
        Log.d(TAG, "Received subjectID: " + subjectID);
        Log.d(TAG, "Received yearID: " + yearID);

        // Ensure subjectID and yearID are valid
        if (subjectID != -1 && yearID != -1) {
            fetchPDFUrl(subjectID, yearID);
        } else {
            Toast.makeText(this, "Invalid Subject or Year ID", Toast.LENGTH_SHORT).show();
            finish(); // Close the activity if IDs are invalid
        }
    }

    private void fetchPDFUrl(int subjectID, int yearID) {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<PDFResponse> call = apiInterface.getPDF(yearID, subjectID); // Pass yearID first as examdate_id
        call.enqueue(new Callback<PDFResponse>() {
            @Override
            public void onResponse(Call<PDFResponse> call, Response<PDFResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PDFResponse pdfResponse = response.body();
                    String pdfUrl = pdfResponse.getData().getPdfUrl();

                    Log.d(TAG, "PDF URL: " + pdfUrl); // Add this line to check the PDF URL

                    // Load the PDF URL in WebView
                    WebSettings webSettings = webView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    webSettings.setBuiltInZoomControls(false);
                    webSettings.setDisplayZoomControls(false);

                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + pdfUrl);
                } else {
                    Toast.makeText(SubjectDetailPDF.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Response unsuccessful or empty body: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PDFResponse> call, Throwable t) {
                Toast.makeText(SubjectDetailPDF.this, "Don't have PDF yet", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Failed to fetch data", t);
            }
        });
    }
}
