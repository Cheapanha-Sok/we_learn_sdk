package fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.we_learn.R;
import com.example.we_learn.client.ApiClient;
import com.example.we_learn.client.ApiInterface;

import java.util.ArrayList;

import ApiResponse.ScholarshipResponse;
import ApiResponse.ScienceSubjectResponse;
import adapter.ScienceAdapter;
import model.ScholarshipModel;
import model.ScienceModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    RecyclerView science_subject, socialScience_subject, book;
    ScienceAdapter scienceAdapter;
    ArrayList<ScienceModel> scienceModels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home, container, false);

        scienceModels = new ArrayList<>();
        science_subject = rootView.findViewById(R.id.science_subject);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), 3, RecyclerView.HORIZONTAL, false);
//        science_subject.setLayoutManager(gridLayoutManager);

        science_subject.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        scienceAdapter = new ScienceAdapter(requireContext(), scienceModels);
        science_subject.setAdapter(scienceAdapter);

        // Fetch and populate scholarship data
        populateScienceSubject();

        // Return the root view
        return rootView;
    }

    public void populateScienceSubject() {
        ApiClient.getClient().create(ApiInterface.class).getScienceSubject().enqueue(new Callback<ScienceSubjectResponse>() {
            @Override
            public void onResponse(Call<ScienceSubjectResponse> call, Response<ScienceSubjectResponse> response) {
                if (response.isSuccessful()) {
                    // If the response is successful, parse the data and update the list
                    ScienceSubjectResponse scienceSubjectResponse = response.body();
                    if (scienceSubjectResponse != null) {
                        ArrayList<ScienceModel> data = scienceSubjectResponse.getData();
                        if (data != null) {
                            // Add the retrieved data to the list
                            scienceModels.addAll(data);
                            // Notify the adapter that the data set has changed
                            scienceAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ScienceSubjectResponse> call, Throwable t) {
                // Handle failure in fetching data from API
            }
        });
    }
}