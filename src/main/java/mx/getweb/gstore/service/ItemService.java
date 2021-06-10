package mx.getweb.gstore.service;

import java.util.List;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import mx.getweb.gstore.entity.Item;
import mx.getweb.gstore.repository.ItemRepository;
import org.springframework.stereotype.Service;

/**
 * Item service.
 *
 * @author Carlos Ruiz at getweb.mx
 */
@Service
@RequiredArgsConstructor
public class ItemService {

    private static final Logger LOG = Logger.getLogger(ItemService.class.getName());

    private final ItemRepository itemRepository;

    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }

    public Item findByBarcode(String barcode) {
        return this.itemRepository.findByBarcodeAndDeletedIsNull(barcode);
    }
}
