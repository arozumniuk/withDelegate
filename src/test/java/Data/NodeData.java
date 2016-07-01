package Data;

/**
 * Created by orozumniuk on 6/29/2016.
 */
public class NodeData {
    
    private String question;
    private String description;
    private String answer;
    private Boolean isPageBreak;
    private Boolean isShowConfirmation;
    private int minValue;
    private int maxValue;
    private NodeType nodeType;

    public NodeData (String question){
        this.question = question;
    }
    
    public String getQuestion() {
        return question;
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

    public Boolean getPageBreak() {
        return isPageBreak;
    }

    public NodeData withPageBreak(Boolean pageBreak) {
        isPageBreak = pageBreak;
        return this;
    }

    public Boolean getShowConfirmation() {
        return isShowConfirmation;
    }

    public NodeData withShowConfirmation(Boolean showConfirmation) {
        isShowConfirmation = showConfirmation;
        return this;
    }

    public int getMinValue() {
        return minValue;
    }

    public NodeData withMinValue(int minValue) {
        this.minValue = minValue;
        return this;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public NodeData withMaxValue(int maxValue) {
        this.maxValue = maxValue;
        return this;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public NodeData withNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
        return this;
    }
}
