package main.homeTasks.extraTask;

import main.homeTasks.extraTask.markdown.MarkDown;

public class Text implements MarkDown {
    public String src;

    Text(String src){
        this.src = src;
    }

    @Override
    public String getString() {
        return src;
    }
}
