package main.homeTasks.extraTask;

import java.util.List;

public class Paragraph implements MarkDown{

    private List<MarkDown> list;

    Paragraph(List src) {
        list = src;
    }

    @Override
    public void toMarkdown(StringBuilder stringBuilder) {
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getString());
        }
        System.out.println(stringBuilder);
    }

    @Override
    public String getString() {
        return null;
    }
}
