package finalProject.musicProject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public  class Song  {

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
    private long id;

    private String songName;
    private String songType;
    private String genre;

    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"songs", "hibernateLazyInitializer", "handler"})
    private AppUser user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "song")
    private List<Comment> comments;

    public Song() {

    }

    public Song(String songName, String songType, byte[] data, String genre) {
        this.songName = songName;
        this.songType = songType;
        this.data = data;
        this.genre = genre;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
