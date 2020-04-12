package org.martynas.blogapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "posts")
public class Post {

    private static final int MIN_TITILE_LENGTH = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = MIN_TITILE_LENGTH, message = "Title must be at least " + MIN_TITILE_LENGTH + " characters long")
    @NotEmpty(message = "Please enter the title")
    private String title;

    @NotEmpty
    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(insertable = false, nullable = false, updatable = false)
    private Date creationDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Collection<Comment> comments;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", creationDate=" + creationDate +
                ", comments=" + comments.stream().map(Comment::toString).collect(Collectors.joining(",")) +
                '}';
    }
}
