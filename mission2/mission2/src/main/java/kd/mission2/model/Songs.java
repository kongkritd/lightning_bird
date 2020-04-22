package kd.mission2.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Songs {
    private Integer songId;
    private String songName;
    private String songArtist;
    private String songYear;
}
