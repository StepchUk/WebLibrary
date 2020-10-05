package loc.stalex.weblibrary.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Book {

    private int id;
    private String name;
    private String author;
    private String edition;
    private String description;
    private int editionYear;
}
