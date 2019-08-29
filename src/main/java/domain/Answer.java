package domain;

public class Answer {
    private int id;
    private String text;
    private int answerId;

    public Answer(int id, String text, int answerId) {
        this.id = id;
        this.text = text;
        this.answerId = answerId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getAnswerId() {
        return answerId;
    }
}
