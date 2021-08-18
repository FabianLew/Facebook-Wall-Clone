package com.fabianlewandowski.facebookwallclone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User creator;
    private String content;

    public Comment() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        this.creator = (User)authentication.getDetails();
    }
}
