package main.homeTasks.extraTask.markdown;

import java.util.List;

public class Emphasis implements MarkDown {
    private String emphasis;
    private List<MarkDown> list;

    public Emphasis(List src){
        list = src;
        this.toMarkdown(new StringBuilder());
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getString());
        }
        stringBuilder.append("*");
        stringBuilder.insert(0, "*");
        emphasis = String.valueOf(stringBuilder);
    }

    @Override
    public String getString() {
        return emphasis;
    }
}
