package com.example.we_learn;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.we_learn.client.ApiClient;
import com.example.we_learn.client.ApiInterface;
import com.example.we_learn.databinding.ActivityMainBinding;
import java.util.ArrayList;
import ApiResponse.ScienceSubjectResponse;
import adapter.ScienceAdapter;
import fragment.FragmentHome;
import fragment.FragmentProfile;
import fragment.FragmentScholarship;
import fragment.FragmentTest;
import itemDetail.TestPDF;
import model.ScienceModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//MainActivity class definition
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding; // Binding for the main activity layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Button button = findViewById(R.id.testPDF);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TestPDF.class);
                intent.putExtra("pdf_url", "https://antilogicalism.com/wp-content/uploads/2018/03/short-history-world.pdf");
                startActivity(intent);
            }

        });


        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Inflate the main activity layout using view binding
        setContentView(binding.getRoot()); // Set the content view to the root view of the inflated layout

        replaceFragment(new FragmentHome()); // Replace the initial fragment with the FragmentHome

        // Set the background of the bottom navigation view to null to remove the default background
        binding.bottomNavigationView.setBackground(null);

        // Set listener for the bottom navigation view item selection
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId(); // Get the ID of the selected item

            // Replace the fragment based on the selected item
            if (itemId == R.id.home) {
                replaceFragment(new FragmentHome());
            } else if (itemId == R.id.scholarship) {
                replaceFragment(new FragmentScholarship());
            } else if (itemId == R.id.test) {
                replaceFragment(new FragmentTest());
            } else if (itemId == R.id.profile) {
                replaceFragment(new FragmentProfile());
            }

            return true; // Return true to indicate the item selection is handled
        });
    }
     // Method to replace the current fragment with a new fragment
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager(); // Get the fragment manager
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // Begin a new fragment transaction
        fragmentTransaction.replace(R.id.frame_layout, fragment); // Replace the frame layout with the new fragment
        fragmentTransaction.commit(); // Commit the transaction
    }

}
// End of MainActivity class





// MainActivity class definition
//public class MainActivity extends AppCompatActivity {
//
//    RecyclerView science_subject, socialScience_subject, book;
//    ScienceAdapter scienceAdapter;
//    ArrayList<ScienceModel> scienceModels;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home);
//
//        // Initialize RecyclerViews and Adapters
//        initializeRecyclerViews();
//
//        // Populate science subjects
//        populateScienceSubjects();
//
//        // Initialize bottom navigation
//        initializeBottomNavigation();
//    }
//
//    private void initializeRecyclerViews() {
//        scienceModels = new ArrayList<>();
//        science_subject = findViewById(R.id.science_subject);
//        socialScience_subject = findViewById(R.id.socialScience_subject);
//        book = findViewById(R.id.book);
//
//        // Set Layout Managers
//        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
//        science_subject.setLayoutManager(horizontalLayoutManager);
//        socialScience_subject.setLayoutManager(horizontalLayoutManager);
//        book.setLayoutManager(horizontalLayoutManager);
//
//        // Set Adapters
//        scienceAdapter = new ScienceAdapter(MainActivity.this, scienceModels);
//        science_subject.setAdapter(scienceAdapter);
//        socialScience_subject.setAdapter(new ScienceAdapter(MainActivity.this, new ArrayList<>()));
//        book.setAdapter(new ScienceAdapter(MainActivity.this, new ArrayList<>()));
//    }
//
//    private void populateScienceSubjects() {
//        ApiClient.getClient().create(ApiInterface.class).getScienceSubject().enqueue(new Callback<ScienceSubjectResponse>() {
//            @Override
//            public void onResponse(Call<ScienceSubjectResponse> call, Response<ScienceSubjectResponse> response) {
//                if (response.isSuccessful()) {
//                    ScienceSubjectResponse subjectResponse = response.body();
//                    if (subjectResponse != null && subjectResponse.getData() != null) {
//                        scienceModels.addAll(subjectResponse.getData());
//                        scienceAdapter.notifyDataSetChanged();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ScienceSubjectResponse> call, Throwable t) {
//                // Handle failure
//            }
//        });
//    }
//
//    private void initializeBottomNavigation() {
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        bottomNavigationView.setBackground(null);
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            Fragment selectedFragment = null;
//
//            switch (item.getItemId()) {
//                case R.id.home:
//                    selectedFragment = new FragmentHome();
//                    break;
//                case R.id.scholarship:
//                    selectedFragment = new FragmentScholarship();
//                    break;
//                case R.id.test:
//                    selectedFragment = new FragmentTest();
//                    break;
//                case R.id.profile:
//                    selectedFragment = new FragmentProfile();
//                    break;
//            }
//
//            if (selectedFragment != null) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectedFragment).commit();
//                return true;
//            } else {
//                return false;
//            }
//        });
//    }
//}

