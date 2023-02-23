package chapter08;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Ingredient {
    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
    @Id
    private final String id;
    private final String name;
    private final Type type;
}
