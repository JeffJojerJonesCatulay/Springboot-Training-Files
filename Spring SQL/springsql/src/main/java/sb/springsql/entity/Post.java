package sb.springsql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data // Create getter and setter
@AllArgsConstructor // Create parametized constructor
@NoArgsConstructor // empty constructor
@Entity
@Table( name = "posts", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title"})
}) // to rename table

public class Post{
    // specifying that the field id is primary key and auto generated
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column( name = "title" , nullable = false)
    private String title;
    @Column ( name = "description" , nullable = false)
    private String description;
    @Column ( name = "content" , nullable = false)
    private String content;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Comment> comment = new HashSet<>();
}
