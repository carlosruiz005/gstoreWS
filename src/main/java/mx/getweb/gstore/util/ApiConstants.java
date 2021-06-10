package mx.getweb.gstore.util;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
public class ApiConstants {

    public static final String CONTENT_TYPE_JSON_APPLICATION = "application/json";
    public static final String RESPONSE_CODE_200 = "200";
    public static final String RESPONSE_CODE_200_DESCRIPTION = "Solicitud resuelta.";
    public static final String RESPONSE_CODE_400 = "400";
    public static final String RESPONSE_CODE_400_DESCRIPTION = "Solicitud mal formada.";
    public static final String RESPONSE_CODE_404 = "404";
    public static final String RESPONSE_CODE_404_DESCRIPTION = "Recurso no encontrado.";

    public static class VentasControllerConstants {

        public static final String URL = "/ventas";
        public static final String FIND_ALL_ITEMS_URL = "/items";
        public static final String FIND_ALL_ITEMS_URL_SUMMARY = "Obtener todos los items.";
        public static final String FIND_ALL_ITEMS_URL_DESCRIPTION = "Regresa todos los items de la base de datos.";
        public static final String FIND_ITEM_BY_BARCODE_ADDRESS_URL = "/items/{barcode}";
        public static final String FIND_ITEM_BY_BARCODE_ADDRESS_URL_SUMMARY = "Obtiener item por código de barra.";
        public static final String FIND_ITEM_BY_BARCODE_ADDRESS_URL_DESCRIPTION = "Busca y regresa el item a través del código de barras.";
    }
}
