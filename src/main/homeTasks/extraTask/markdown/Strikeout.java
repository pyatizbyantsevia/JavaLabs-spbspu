package main.homeTasks.extraTask.markdown;

import java.util.List;

public class Strikeout implements MarkDown {
    private String strikeout;
    private List<MarkDown> list;

    public Strikeout(List src){
        list = src;
        this.toMarkdown(new StringBuilder());
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getString());
        }
        stringBuilder.append("~");
        stringBuilder.insert(0, "~");
        strikeout = String.valueOf(stringBuilder);
    }

    @Override
    public String getString() {
        return strikeout;
    }
}
