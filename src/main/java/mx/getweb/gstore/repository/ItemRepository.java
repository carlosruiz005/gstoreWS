package mx.getweb.gstore.repository;

import mx.getweb.gstore.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Item repository.
 *
 * @author Carlos Ruiz at getweb.mx
 */
public interface ItemRepository extends MongoRepository<Item, String> {

    public Item findByBarcodeAndDeletedIsNull(String barcode);
}
