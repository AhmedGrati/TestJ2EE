package metier;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Article {
    private int id;
    private String code;
    private String name;
    private String description;
    private double price;
}
