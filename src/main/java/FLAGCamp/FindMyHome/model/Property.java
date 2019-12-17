package FLAGCamp.FindMyHome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double utilityCost;
    private double maintenanceCost;
    private String name;
    private String category;
    private double price;
    private String description;
    private int area;
    private int noBedroom;
    private int noBathroom;

    @ManyToOne
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "viewerId")
    private Viewer viewer;

    @ManyToOne
    @JoinColumn(name = "favById")
    private Viewer favBy;

    @OneToOne(mappedBy = "property", cascade=CascadeType.ALL)
    private Address address;

}
