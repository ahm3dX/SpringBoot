package TN.CompanyManagement.Entity.Event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import TN.CompanyManagement.Entity.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "participant")
public class participant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @ManyToOne
    @JsonIgnore
    Event event;

    @ManyToOne
    @JsonIgnore
    private User usersP;



}
