package finalProject.musicProject.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class AppUser {

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
    private long userId;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Song> songs;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "writer")
    //private List<Comment> placedComments;

    public void setUserId(long id) {
        this.userId = id;
    }

    public long getUserId() {
        return userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }


}
