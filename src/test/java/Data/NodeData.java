package Data;

/**
 * Created by orozumniuk on 6/29/2016.
 */
public class NodeData {
    
    private String question;

    public String getQuestion() {
        return question;
    }

    public NodeData withQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NodeData withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public NodeData withAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    private String description;
    private String answer;
    
}
