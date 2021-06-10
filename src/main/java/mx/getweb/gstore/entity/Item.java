package mx.getweb.gstore.entity;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Item entity.
 *
 * @author Carlos Ruiz at getweb.mx
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "items")
public class Item {

    @Id
    private String id;
    private String name;
    private String description;
    private String barcode;
    private Double price;
    private Date created;
    private Date updated;
    private Date deleted;
}
