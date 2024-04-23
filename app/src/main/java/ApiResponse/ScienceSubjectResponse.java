package ApiResponse;

import java.util.ArrayList;

import model.ScholarshipModel;
import model.ScienceModel;

public class ScienceSubjectResponse {
    private boolean status;
    private String message;
    private ArrayList<ScienceModel> data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<ScienceModel> getData() {
        return data;
    }
}

