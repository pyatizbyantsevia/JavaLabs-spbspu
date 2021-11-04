package main.homeTasks.extraTask;

import java.util.List;

public class Strong implements MarkDown{

    public String strong;
    public List<MarkDown> list;

    Strong(List src){
        list = src;
        this.toMarkdown(new StringBuilder());
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getString());
        }
        stringBuilder.append("__");
        stringBuilder.insert(0, "__");
        strong = String.valueOf(stringBuilder);
    }

    @Override
    public String getString() {
        return strong;
    }
}
