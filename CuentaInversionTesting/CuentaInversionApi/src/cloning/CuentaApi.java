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
    private static final int TOPE=6;
    
    public CuentaApi() {
        super();
    }

    public static void main(String[] args) {
        
        List<Movimiento> reversas = new ArrayList<Movimiento>();
        List<Movimiento> movimientos = new ArrayList<Movimiento>();
        //List<Movimiento> movimientosFinal = new ArrayList<Movimiento>();
        Movimiento mov=new Movimiento();
        
        //movimiento sin reversa 555
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("1"), Long.valueOf("1013"),Long.valueOf("1"), "555");
        movimientos.add(mov);
        //movimiento con 1 reversa 556
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("2"), Long.valueOf("1013"),Long.valueOf("1"), "556");
        movimientos.add(mov);
        //movimiento con 2 reversa 557
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("3"), Long.valueOf("1013"),Long.valueOf("1"), "557");
        movimientos.add(mov);
        //movimiento con 5 reversas 558
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("4"), Long.valueOf("1013"),Long.valueOf("1"), "558");
        movimientos.add(mov);
        //movimiento con 6 reversas 559
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("4"), Long.valueOf("1013"),Long.valueOf("1"), "559");
        movimientos.add(mov);
        //movimiento con una reversa 556
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("5"), Long.valueOf("1032"),Long.valueOf("1"), "556");
        reversas.add(mov);
        //movimiento con 2 reversa 557
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("6"), Long.valueOf("1032"),Long.valueOf("1"), "557");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("7"), Long.valueOf("2032"),Long.valueOf("1"), "557");
        reversas.add(mov);
        //movimiento con 3 reversa 558
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("8"), Long.valueOf("1032"),Long.valueOf("1"), "558");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("9"), Long.valueOf("2032"),Long.valueOf("1"), "558");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("10"), Long.valueOf("1032"),Long.valueOf("1"), "558");
        reversas.add(mov);
        //mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("11"), Long.valueOf("2032"),Long.valueOf("1"), "558");
        //reversas.add(mov);
        //mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("12"), Long.valueOf("1032"),Long.valueOf("1"), "558");
        //reversas.add(mov);
        //movimiento con 7 reversa 559
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("1"), Long.valueOf("1032"),Long.valueOf("1"), "559");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("2"), Long.valueOf("2032"),Long.valueOf("1"), "559");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("3"), Long.valueOf("1032"),Long.valueOf("1"), "559");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("4"), Long.valueOf("2032"),Long.valueOf("1"), "559");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("5"), Long.valueOf("1032"),Long.valueOf("1"), "559");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("6"), Long.valueOf("2032"),Long.valueOf("1"), "559");
        reversas.add(mov);
        mov=new Movimiento(Long.valueOf("98891"),Long.valueOf("9"), Long.valueOf("7"), Long.valueOf("1032"),Long.valueOf("1"), "559");
        reversas.add(mov);
        for(Movimiento movimiento: movimientos){
            System.out.println("movimiento cuenta:"+movimiento.getIdCuenta());
            System.out.println("movimiento getFolioDocPago:"+movimiento.getFolioDocPago());
        }
        movimientos= encuentraMovimientoReversadoReversado(reversas,movimientos);
        for(Movimiento movimiento: movimientos){
            System.out.println("movimiento reversa cuenta:"+movimiento.getIdCuenta());
            System.out.println("reversa getFolioDocPago:"+movimiento.getFolioDocPago());
        }
    }
    /*public static List<Movimiento> encuentraMovimientoReversado(
    List<Movimiento> reversas , 
        ){
        
            System.out.println("movimiento cuenta:"+movimiento.getIdCuenta());
            System.out.println("movimiento getFolioDocPago:"+movimiento.getFolioDocPago());
            System.out.println("movimiento getClaveMovto:"+movimiento.getClaveMovto());
            boolean flag = encuentraMovimientoReversadoReversado(reversas,movimiento);
            System.out.println("tiene reversa de reversa? R:"+flag);
        }
            
    }*/
    public static List<Movimiento> encuentraMovimientoReversadoReversado(
    List<Movimiento> reversas , List<Movimiento> movimientos
        ){
        List<Movimiento> movimientosFinal = new ArrayList<Movimiento>();
        //si no hay reversas retornamos los movimientos
        if(reversas == null || reversas.isEmpty())
            return movimientos;
        
    for(Movimiento movimiento: movimientos){
        boolean flag = false;
        int contRev=0;
        int resto = 0;   
        Movimiento reversafinal = new Movimiento();
        //recorremos las reversas buscando la cuenta,subcuenta y folio del movimiento
        for(Movimiento reversa: reversas){
            if ((reversa.getIdCuenta().longValue()==movimiento.getIdCuenta().longValue())&&
                (reversa.getSubcuenta().longValue()==movimiento.getSubcuenta().longValue()) &&
                (reversa.getFolioDocPago().equalsIgnoreCase(movimiento.getFolioDocPago()))
                ) {
                //buscamos que sea reversa abono o retiro
                for (long clave:CLAVEREVERSAS)  {
                    if(reversa.getClaveMovto().longValue() == clave) {
                    contRev++;
                    if (contRev>1) {
                        if (contRev>=TOPE) {
                            flag=true;
                            break;
                        }
                        //si tiene mas de una reversa,buscamos reversa de reversa
                        if (contRev%2==0)
                        flag=true;
                        else
                        flag=false;
                        
                    }
                    else
                    flag=false;
                    reversafinal = reversa;  
                    }  
                }
                if (contRev>=TOPE) {
                    break;
                }
            }        
        }
        //se añade si efectivamente tiene 
        if (!flag){ 
             movimientosFinal.add(movimiento);
        }
    }
        return movimientosFinal;
    }
}
