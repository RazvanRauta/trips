package ro.scoalainformala.trips.entitys;



import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Table(name = "TRIP")
public class Trip {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "TITLE")
    private String title;
    @NotNull
    @Column(columnDefinition = "text", length = 10485760, name = "DESCRIPTION")
    private String description;

    @NotNull
    @Column(name = "START_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @Column(name = "END_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @NotNull
    @Column(name = "LOCATION")
    private String location;

    @NotNull
    @Lob
    @Column(name = "FILEPATH")
    private byte[] filePath;

    @NotNull
    @Lob
    @Column(name = "FILEPATH2")
    private byte[] filePath2;

    public byte[] getFilePath() {
        return filePath;
    }

    public void setFilePath(byte[] filePath) {
        this.filePath = filePath;
    }

    public byte[] getFilePath2() {
        return filePath2;
    }

    public void setFilePath2(byte[] filePath2) {
        this.filePath2 = filePath2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
