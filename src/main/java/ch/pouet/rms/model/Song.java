package ch.pouet.rms.model;


import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "song")
@NoArgsConstructor
public class Song {
    @Id
    private Long id;
    @NonNull
    @lombok.NonNull
    private String link;
    @Nullable
    private String name;
    @Nullable
    private String submittedBy;
    @NonNull
    @lombok.NonNull
    private Instant submission = Instant.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Song song = (Song) o;
        return id != null && Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
