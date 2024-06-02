package study.java.opencsv.bean;

import com.opencsv.bean.CsvBindByName;

public class Bean implements Comparable<Bean> {
    @CsvBindByName(column = "Category")
    private String category;

    @CsvBindByName(column = "Subcategory")
    private String subcategory;

    @CsvBindByName(column = "Topic")
    private String topic;

    @CsvBindByName(column = "Question")
    private String question;

    @CsvBindByName(column = "Answer")
    private String answer;

    // Getters and setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "category='" + category + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", topic='" + topic + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public int compareTo(Bean other) {
        return this.category.compareTo(other.category);
    }
}