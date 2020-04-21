package org.martynas.blogapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "posts")
@SequenceGenerator(name = "post_seq_gen", sequenceName = "post_seq", initialValue = 10, allocationSize=1)
public class Post {

    private static final int MIN_TITLE_LENGTH = 7;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_gen")
    private Long id;

    @NotNull
    @Length(min = MIN_TITLE_LENGTH, message = "Title must be at least " + MIN_TITLE_LENGTH + " characters long")
    @NotEmpty(message = "Please enter the title")
    private String title;

    @NotEmpty
    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;

    @NotNull
    @ManyToOne
    private BlogUser user;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", creationDate=" + creationDate +
//                ", comments=" + comments.stream().map(Comment::toString).collect(Collectors.joining(",")) +
                '}';
    }
}
