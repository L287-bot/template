package com.tencent.scfspringbootjava8.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "todos")
public class TodoItem {
    @Id
    @Column(name = "`todo_key`")
    private String key;
    private String content;
    private boolean done;

    // Getter Setter 必须有
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }
}
