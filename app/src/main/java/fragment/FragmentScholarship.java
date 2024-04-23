package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.we_learn.R;
import com.example.we_learn.client.ApiClient;
import com.example.we_learn.client.ApiInterface;

import java.util.ArrayList;

import ApiResponse.ScholarshipResponse;
import adapter.ScholarshipAdapter;
import model.ScholarshipModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentScholarship extends Fragment {

    RecyclerView scholarship; // RecyclerView for displaying scholarships
    ScholarshipAdapter scholarshipAdapter; // Adapter for binding data to RecyclerView
    ArrayList<ScholarshipModel> scholarshipModels; // List to hold scholarship data

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment layout
        View rootView = inflater.inflate(R.layout.scholarship, container, false);

        // Initialize the ArrayList to hold scholarship data
        scholarshipModels = new ArrayList<>();

        // Find the RecyclerView from the inflated layout
        scholarship = rootView.findViewById(R.id.scholarship);

        // Set layout manager for RecyclerView
        scholarship.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));

        // Create adapter instance and set it to RecyclerView
        scholarshipAdapter = new ScholarshipAdapter(requireContext(), scholarshipModels);
        scholarship.setAdapter(scholarshipAdapter);

        // Fetch and populate scholarship data
        populateScholarships();

        // Return the root view
        return rootView;
    }

    // Method to fetch scholarship data from API
    public void populateScholarships() {
        // Call the API to get scholarship data asynchronously
        ApiClient.getClient().create(ApiInterface.class).getScholarship().enqueue(new Callback<ScholarshipResponse>() {
            @Override
            public void onResponse(Call<ScholarshipResponse> call, Response<ScholarshipResponse> response) {
                if (response.isSuccessful()) {
                    // If the response is successful, parse the data and update the list
                    ScholarshipResponse scholarshipResponse = response.body();
                    if (scholarshipResponse != null) {
                        ArrayList<ScholarshipModel> data = scholarshipResponse.getData();
                        if (data != null) {
                            // Add the retrieved data to the list
                            scholarshipModels.addAll(data);
                            // Notify the adapter that the data set has changed
                            scholarshipAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ScholarshipResponse> call, Throwable t) {
                // Handle failure in fetching data from API
            }
        });
    }
}
