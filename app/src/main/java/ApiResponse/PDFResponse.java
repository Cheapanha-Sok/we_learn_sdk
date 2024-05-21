package ApiResponse;

import com.google.gson.annotations.SerializedName;

public class PDFResponse {
    @SerializedName("statusCode")
    private int statusCode;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private Data data;

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    public static class Data {
        @SerializedName("id")
        private int id;

        @SerializedName("pdfUrl")
        private String pdfUrl;

        @SerializedName("category")
        private Category category;

        @SerializedName("examdate")
        private ExamDate examDate;

        public int getId() {
            return id;
        }

        public String getPdfUrl() {
            return pdfUrl;
        }

        public Category getCategory() {
            return category;
        }

        public ExamDate getExamDate() {
            return examDate;
        }

        public static class Category {
            @SerializedName("id")
            private int id;

            @SerializedName("name")
            private String name;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        public static class ExamDate {
            @SerializedName("id")
            private int id;

            @SerializedName("name")
            private String name;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }
    }
}
