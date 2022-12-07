package cloning;

public class Movimiento {
    
    private Long idCuenta = null;
    private Long subcuenta = null;
    private Long secuencia = null;
    private Long claveMovto = null;
    private Long idFondo = null;
    private String folioDocPago = null;
    
    public Movimiento (Long idCuenta,Long subcuenta,Long secuencia,Long claveMovto,Long idFondo,String folioDocPago) {
        this.idCuenta= idCuenta;
        this.subcuenta= subcuenta;
        this.secuencia= secuencia;
        this.claveMovto= claveMovto;
        this.idFondo = idFondo;
        this.folioDocPago= folioDocPago;
    }
    public Movimiento () {
    }
    public Long getIdCuenta() {
            return this.idCuenta;
    }
    /**
     * Asigna idCuenta
     * @param p_idCuenta de tipo Long
     */
    public void setIdCuenta(Long p_idCuenta) {
            this.idCuenta = p_idCuenta;
    }

    /**
     * Obtiene subcuenta
     * @return subcuenta de tipo Long
     */
    public Long getSubcuenta() {
            return this.subcuenta;
    }
    /**
     * Asigna subcuenta
     * @param p_subcuenta de tipo Long
     */
    public void setSubcuenta(Long p_subcuenta) {
            this.subcuenta = p_subcuenta;
    }

    /**
     * Obtiene secuencia
     * @return secuencia de tipo Long
     */
    public Long getSecuencia() {
            return this.secuencia;
    }
    /**
     * Asigna secuencia
     * @param p_secuencia de tipo Long
     */
    public void setSecuencia(Long p_secuencia) {
            this.secuencia = p_secuencia;
    }

    /**
     * Obtiene claveMovto
     * @return claveMovto de tipo Long
     */
    public Long getClaveMovto() {
            return this.claveMovto;
    }
    /**
     * Asigna claveMovto
     * @param p_claveMovto de tipo Long
     */
    public void setClaveMovto(Long p_claveMovto) {
            this.claveMovto = p_claveMovto;
    }

    /**
     * Obtiene idFondo
     * @return idFondo de tipo Long
     */
    public Long getIdFondo() {
            return this.idFondo;
    }
    /**
     * Asigna idFondo
     * @param p_idFondo de tipo Long
     */
    public void setIdFondo(Long p_idFondo) {
            this.idFondo = p_idFondo;
    }

    /**
     * Obtiene folioDocPago
     * @return folioDocPago de tipo String
     */
    public String getFolioDocPago() {
            return this.folioDocPago;
    }
    /**
     * Asigna folioDocPago
     * @param p_folioDocPago de tipo String
     */
    public void setFolioDocPago(String p_folioDocPago) {
            this.folioDocPago = p_folioDocPago;
    }
}
