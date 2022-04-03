package mx.getweb.gstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.getweb.gstore.entity.Item;
import mx.getweb.gstore.service.ItemService;
import mx.getweb.gstore.util.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Ventas controller. APIs para el control de las ventas.
 *
 * @author Carlos Ruiz at getweb.mx
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(ApiConstants.VentasControllerConstants.URL)
@ApiResponses(
        value = {
            @ApiResponse(
                    responseCode = ApiConstants.RESPONSE_CODE_200,
                    description = ApiConstants.RESPONSE_CODE_200_DESCRIPTION,
                    content = {
                        @Content(mediaType = ApiConstants.CONTENT_TYPE_JSON_APPLICATION),}
            ),
            @ApiResponse(
                    responseCode = ApiConstants.RESPONSE_CODE_404,
                    description = ApiConstants.RESPONSE_CODE_404_DESCRIPTION,
                    content = @Content
            ),}
)
public class VentasController {

    private static final Logger LOG = Logger.getLogger(
            VentasController.class.getName()
    );

    @Autowired
    private ItemService itemService;

    @GetMapping(ApiConstants.VentasControllerConstants.FIND_ALL_ITEMS_URL)
    @Operation(
            summary = ApiConstants.VentasControllerConstants.FIND_ALL_ITEMS_URL_SUMMARY,
            description = ApiConstants.VentasControllerConstants.FIND_ALL_ITEMS_URL_DESCRIPTION
    )
    @ApiResponse(
            content = {
                @Content(schema = @Schema(implementation = Item.class))}
    )
    public ResponseEntity<List<Item>> findAllItems() {
        return new ResponseEntity(this.itemService.findAll(), HttpStatus.OK);
    }

    @GetMapping(
            ApiConstants.VentasControllerConstants.FIND_ITEM_BY_BARCODE_ADDRESS_URL
    )
    @Operation(
            summary = ApiConstants.VentasControllerConstants.FIND_ITEM_BY_BARCODE_ADDRESS_URL_SUMMARY,
            description = ApiConstants.VentasControllerConstants.FIND_ITEM_BY_BARCODE_ADDRESS_URL_DESCRIPTION
    )
    @ApiResponse(
            content = {
                @Content(mediaType = ApiConstants.CONTENT_TYPE_JSON_APPLICATION),}
    )
    public ResponseEntity<Item> findItemByBarcode(
            @PathVariable("barcode") String barcode
    ) {
        LOG.log(Level.INFO, "Consulta por codigo de barra: " + barcode);
        Item item = this.itemService.findByBarcode(barcode);
        if (item == null) {
            LOG.log(Level.WARNING, "Código no encontrado: " + barcode);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No exite el item con código: " + barcode
            );
        }
        LOG.log(Level.INFO, "item: " + item);
        item.setCreated(null);
        item.setUpdated(null);
        return new ResponseEntity(item, HttpStatus.OK);
    }

    @GetMapping("/alive")
    public ResponseEntity<Map> alive() {
        Map<String, String> m = new HashMap();
        m.put("valor", "alive");
        return ResponseEntity.ok(m);
    }
}
