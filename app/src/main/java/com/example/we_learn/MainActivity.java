package com.example.we_learn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.we_learn.databinding.ActivityMainBinding;

import fragment.FragmentHome;
import fragment.FragmentProfile;
import fragment.FragmentScholarship;
import fragment.FragmentTest;

// MainActivity class definition
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding; // Binding for the main activity layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
} // End of MainActivity class
