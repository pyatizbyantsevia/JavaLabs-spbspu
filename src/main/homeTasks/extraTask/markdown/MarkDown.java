package main.homeTasks.extraTask.markdown;

public interface MarkDown {
    default void toMarkdown(StringBuilder stringBuilder){
    }
    default String getString(){
        return null;
    }
}
