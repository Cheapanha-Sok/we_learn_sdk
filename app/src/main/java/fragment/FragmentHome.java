package fragment;

import android.os.Bundle;
import android.util.Log;
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
import java.util.List;

import ApiResponse.ScienceSubjectResponse;
import ApiResponse.SocialSciencesSubjectResponse;
import ApiResponse.YearsResponse;
import adapter.ScienceAdapter;
import adapter.SocialSciencesAdapter;
import model.ScienceModel;
import model.YearsModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    private RecyclerView science_subject;
    private RecyclerView social_sciences_subject;
    private ScienceAdapter scienceAdapter;
    private SocialSciencesAdapter socialSciencesAdapter;
    private ArrayList<ScienceModel> scienceModels;
    private ArrayList<ScienceModel> socialSciencesModels;
    private ArrayList<YearsModel> yearsModels;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home, container, false);

        // Initialize RecyclerView and data lists
        science_subject = rootView.findViewById(R.id.science_subject);
        social_sciences_subject = rootView.findViewById(R.id.socialScience_subject);
        scienceModels = new ArrayList<>();
        socialSciencesModels = new ArrayList<ScienceModel>();
        yearsModels = new ArrayList<>();

        // Set the layout manager and the adapter
        science_subject.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        scienceAdapter = new ScienceAdapter(requireContext(), scienceModels, yearsModels);
        social_sciences_subject.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        socialSciencesAdapter = new SocialSciencesAdapter(requireContext(), socialSciencesModels, yearsModels);
        science_subject.setAdapter(scienceAdapter);
        social_sciences_subject.setAdapter(socialSciencesAdapter);

        // Fetch and populate science and social sciences subject data
        populateScienceSubject();
        populateSocialSciencesSubject();

        // Fetch and populate years data
        populateYearsData();

        return rootView;
    }

    private void populateScienceSubject() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ScienceSubjectResponse> call = apiInterface.getCategoriesScience();
        call.enqueue(new Callback<ScienceSubjectResponse>() {
            @Override
            public void onResponse(Call<ScienceSubjectResponse> call, Response<ScienceSubjectResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ScienceSubjectResponse scienceSubjectResponse = response.body();
                    List<ScienceModel> data = scienceSubjectResponse.getData().getCategories();
                    if (data != null && !data.isEmpty()) {
                        // Add fetched data to the list and notify adapter
                        scienceModels.addAll(data);
                        scienceAdapter.notifyDataSetChanged();
                    }
                } else {
                    Log.e("API_CALL", "Response unsuccessful or empty body: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ScienceSubjectResponse> call, Throwable t) {
                Log.e("API_CALL", "Failed to fetch data", t);
            }
        });
    }

    private void populateSocialSciencesSubject() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<SocialSciencesSubjectResponse> call = apiInterface.getCategoriesSocialSciences();
        call.enqueue(new Callback<SocialSciencesSubjectResponse>() {
            @Override
            public void onResponse(Call<SocialSciencesSubjectResponse> call, Response<SocialSciencesSubjectResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    SocialSciencesSubjectResponse socialSciencesSubjectResponse = response.body();
                    List<ScienceModel> data = socialSciencesSubjectResponse.getData().getCategories();
                    if (data != null && !data.isEmpty()) {
                        // Add fetched data to the list and notify adapter
                        socialSciencesModels.addAll(data);
                        socialSciencesAdapter.notifyDataSetChanged();
                    }
                } else {
                    Log.e("API_CALL", "Response unsuccessful or empty body: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<SocialSciencesSubjectResponse> call, Throwable t) {
                Log.e("API_CALL", "Failed to fetch data", t);
            }
        });
    }

    private void populateYearsData() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<YearsResponse> call = apiInterface.getYear();
        call.enqueue(new Callback<YearsResponse>() {
            @Override
            public void onResponse(Call<YearsResponse> call, Response<YearsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<YearsModel> data = response.body().getData();
                    if (data != null && !data.isEmpty()) {
                        // Add fetched data to the list and notify adapter
                        yearsModels.addAll(data);
                        scienceAdapter.notifyDataSetChanged();
                        socialSciencesAdapter.notifyDataSetChanged();
                    }
                } else {
                    Log.e("API_CALL", "Response unsuccessful or empty body: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<YearsResponse> call, Throwable t) {
                Log.e("API_CALL", "Failed to fetch data", t);
            }
        });
    }
}
