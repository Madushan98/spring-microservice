package user.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Data
@Builder
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Long id;
    private String fullName ;
    private String userName;
    private String mobileNo;
    private String password;


}
