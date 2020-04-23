package org.martynas.blogapp.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "posts")
@SequenceGenerator(name = "post_seq_gen", sequenceName = "post_seq", initialValue = 10, allocationSize = 1)
public class Post {

    private static final int MIN_TITLE_LENGTH = 7;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_gen")
    @Column(name = "id")
    private Long id;

    @Length(min = MIN_TITLE_LENGTH, message = "Title must be at least " + MIN_TITLE_LENGTH + " characters long")
    @NotEmpty(message = "Please enter the title")
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty(message = "Write something for the love of Internet...")
    @Column(name = "body", columnDefinition = "TEXT", nullable = false)
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Collection<Comment> comments;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private BlogUser user;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", creationDate=" + creationDate +
//                ", comments=" + comments +
//                ", comments=" + comments.stream().map(Comment::toString).collect(Collectors.joining(",")) +
//                ", username=" + user.getUsername() +
//                ", user=" + user + // this way it is making the inf loop
                '}';
    }
}
