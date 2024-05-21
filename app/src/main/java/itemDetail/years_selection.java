//package itemDetail;
//
//import android.os.Bundle;
//import android.widget.Toast;
//import androidx.appcompat.app.AppCompatActivity;
//import com.example.we_learn.databinding.ActivitySubjectDetailPdfBinding;
//
//public class years_selection extends AppCompatActivity {
//
//    ActivitySubjectDetailPdfBinding binding;
//
//    int yearID, subjectID;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivitySubjectDetailPdfBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        if (getIntent() != null) {
//            yearID = getIntent().getIntExtra("yearID", -1);
//            subjectID = getIntent().getIntExtra("subjectID", -1);
//
//            binding.years_show.setText("Year ID: " + yearID + " | Subject ID: " + subjectID);
//
//        } else {
//            Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
