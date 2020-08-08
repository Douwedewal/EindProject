package finalProject.musicProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Song {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long songId;

    private String name;
    private String genre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"songs", "hibernateLazyInitializer", "handler"})
    private AppUser user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "song")
    private List<Comment> comments;


    public long getId() {
        return songId;
    }

    public void setId(long id) {
        this.songId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

}
