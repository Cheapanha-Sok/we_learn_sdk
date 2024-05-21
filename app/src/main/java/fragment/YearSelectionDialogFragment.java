package fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.we_learn.R;

import java.util.ArrayList;
import java.util.List;

import itemDetail.SubjectDetailPDF;
import model.YearsModel;

public class YearSelectionDialogFragment extends DialogFragment {

    private ArrayList<YearsModel> yearsModels;
    private int subjectId;
    private Context context;

    public YearSelectionDialogFragment(ArrayList<YearsModel> yearsModels, int subjectId, Context context) {
        this.yearsModels = yearsModels;
        this.subjectId = subjectId;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_year_selection, container, false);
        ListView listView = view.findViewById(R.id.year_list);

        List<String> yearNames = new ArrayList<>();
        for (YearsModel year : yearsModels) {
            yearNames.add(year.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, yearNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(context, SubjectDetailPDF.class);
            intent.putExtra("subjectID", subjectId);
            intent.putExtra("yearID", yearsModels.get(position).getId());
            context.startActivity(intent);
            dismiss();
        });

        return view;
    }
}
