package cloning;

import java.util.ArrayList;
import java.util.List;

public class CuentaApi {
    private static final long[] CLAVEAPORTE = {1011,1012,1013,1030};
    private static final long[] CLAVERETIRO = {2050};
    private static final long[] CLAVEREVERSAAPORTE = {2032};
    private static final long[] CLAVEREVERSARETIRO = {1032};
    private static final long[] CLAVEREVERSAS = {1032,2032};
    private static final long[] CLAVERETENCION = {2052};
    private static final int TOPE=20;
    
    public CuentaApi() {
        super();
    }

    public static void main(String[] args) {
        
        List<Movimiento> reversas = new ArrayList<Movimiento>();
        List<Movimiento> movimientos = new ArrayList<Movimiento>();
        Movimiento mov=new Movimiento();
        
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("1"), Long.valueOf("1013"),Long.valueOf("1"), "555");
        movimientos.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("2"), Long.valueOf("1013"),Long.valueOf("1"), "556");
        movimientos.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("3"), Long.valueOf("1013"),Long.valueOf("1"), "557");
        movimientos.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("4"), Long.valueOf("1013"),Long.valueOf("1"), "558");
        movimientos.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("5"), Long.valueOf("1032"),Long.valueOf("1"), "556");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("6"), Long.valueOf("1032"),Long.valueOf("1"), "557");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("7"), Long.valueOf("2032"),Long.valueOf("1"), "557");
        reversas.add(mov);
        encuentraMovimientoReversado(reversas,movimientos);
    }
    public static void encuentraMovimientoReversado(
    List<Movimiento> reversas , List<Movimiento> movimientos
        ){
        for(Movimiento movimiento: movimientos){
            System.out.println("movimiento cuenta:"+movimiento.getIdCuenta());
            System.out.println("movimiento getFolioDocPago:"+movimiento.getFolioDocPago());
            System.out.println("movimiento getClaveMovto:"+movimiento.getClaveMovto());
            boolean flag = encuentraMovimientoReversadoReversado(reversas,movimiento);
            System.out.println("tiene reversa de reversa? R:"+flag);
        }
            
    }
    public static boolean encuentraMovimientoReversadoReversado(
    List<Movimiento> reversas , Movimiento movimiento
        ){
        boolean flag = false;
        
        int contRev=0;
        int resto = 0;
    List<Movimiento> tipoMovimientos = new ArrayList<Movimiento>();

        for(Movimiento reversa: reversas){
            System.out.println("reversa cuenta:"+reversa.getIdCuenta());
            System.out.println("reversa getFolioDocPago:"+reversa.getFolioDocPago());
            if ((reversa.getIdCuenta().longValue()==movimiento.getIdCuenta().longValue())&&
                (reversa.getSubcuenta().longValue()==movimiento.getSubcuenta().longValue())&&
                (reversa.getFolioDocPago().equalsIgnoreCase(movimiento.getFolioDocPago()))
                ) {
                System.out.println("tiene reversa : "+reversa.getClaveMovto().longValue());
                
                for (long clave:CLAVEREVERSAS)  {
                    if(reversa.getClaveMovto().longValue() == clave) {
                    contRev++;
                    if (contRev>1) {
                        if (contRev==TOPE) {
                            break;
                        }
                        System.out.println("tiene reversa de reversa");
                        if (contRev%2==0)
                        flag=true;
                        
                    }
                    else
                    flag=false;
                      
                    }  
                }
            }        
        }
        return flag;
    }
    
}
