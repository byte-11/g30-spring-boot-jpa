package uz.pdp.g30springjpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.g30springjpa.config.auditing.EntityAuditing;

@Entity
@Getter
@Setter
public class Comment extends EntityAuditing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;

    private String text;

}
