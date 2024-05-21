//package itemDetail;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.bumptech.glide.Glide;
//import com.example.we_learn.databinding.ActivitySubjectDetailPdfBinding;
//
//public class ScholarshipDetail extends AppCompatActivity {
//
//    ActivitySubjectDetailPdfBinding binding;
//
//    String title , desc , price , image;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivitySubjectDetailPdfBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        if (getIntent() != null) {
//            image = getIntent().getStringExtra("img");
//            title = getIntent().getStringExtra("title");
//            desc = getIntent().getStringExtra("desc");
//            price = getIntent().getStringExtra("price");
//
//            Glide.with(this).load(image).into(binding.profileImage);
//            binding.txtName.setText(title);
//            binding.txtDescription.setText(desc);
//            binding.txtPrice.setText(String.valueOf(price));
//        } else {
//            Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//}