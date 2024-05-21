package ApiResponse;

import java.util.List;

import model.ScienceModel;

public class SocialSciencesSubjectResponse {
    private int statusCode;
    private String message;
    private ScienceSubjectResponse.ResponseData data;

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ScienceSubjectResponse.ResponseData getData() {
        return data;
    }

    public void setData(ScienceSubjectResponse.ResponseData data) {
        this.data = data;
    }

    public static class ResponseData {
        private int id;
        private String name;
        private List<ScienceModel> categories;

        // Getters and Setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ScienceModel> getCategories() {
            return categories;
        }

        public void setCategories(List<ScienceModel> categories) {
            this.categories = categories;
        }
    }
}