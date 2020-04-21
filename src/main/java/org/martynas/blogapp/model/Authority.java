package org.martynas.blogapp.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "authorities")
@SequenceGenerator(name = "authority_seq_gen", sequenceName = "authority_seq", initialValue = 10, allocationSize=1)
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "authority_seq_gen")
    private Long id;

    @Column(name = "authority", unique = true)
    private String authority;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authorities")
    private Collection<BlogUser> users;

}
