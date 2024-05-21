//package itemDetail;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//
//
//public class Years extends AppCompatActivity {
//
//    ActivityYearsBinding binding; // Use the correct binding class
//
//    String years;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityYearsBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        if (getIntent() != null) {
//            years = getIntent().getStringExtra("years");
//            binding.year.setText(years);
//
//        } else {
//            Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
