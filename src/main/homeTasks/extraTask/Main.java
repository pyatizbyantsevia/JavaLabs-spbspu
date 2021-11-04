package main.homeTasks.extraTask;

import main.homeTasks.extraTask.markdown.Strong;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Paragraph paragraph = new Paragraph(List.of(
                new Text("q"),
                new Strong(List.of(
                        new Text("1")
                ))
        ));
        paragraph.toMarkdown(new StringBuilder());
    }
}
