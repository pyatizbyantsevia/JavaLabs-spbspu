package main.homeTasks.extraTask;

public class Text implements MarkDown{

    public String src;

    Text(String src){
        this.src = src;
        this.toMarkdown(new StringBuilder());
    }

    @Override
    public String getString() {
        return src;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {

    }
}
