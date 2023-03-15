import java.util.ArrayList;

import java.util.Scanner;
import javax.swing.JOptionPane;

import model.DinosDao;
import model.Hadrosaurios;


public class App {
    public static void main(String[] args) throws Exception {

        Scanner entradaEscaner = new Scanner(System.in);     
        DinosDao model = new DinosDao();

        String menu = JOptionPane.showInputDialog("CRUD \n" + "1 - Insertar Información\n" + "2 - Seleccionar Información\n" + "3 - Actualizar Información\n" + "4 - Eliminar Información\n" + "5 - Salir\n");
        int seleccion = Integer.parseInt(menu);

        switch(seleccion){
            case 1 :
                Hadrosaurios hadrosaurios = new Hadrosaurios();

                
                System.out.print("Por favor introduzca su nombre : ");
                hadrosaurios.setNombre(entradaEscaner.nextLine());
                System.out.print("Por favor introduzca su familia : ");
                hadrosaurios.setFamilia(entradaEscaner.nextLine());
                System.out.print("Por favor introduzca su genero : ");
                hadrosaurios.setGenero(entradaEscaner.nextLine());
                System.out.print("Por favor introduzca su era : ");
                hadrosaurios.setEra(entradaEscaner.nextLine());
                System.out.print("Por favor introduzca su altura : ");
                hadrosaurios.setAltura(entradaEscaner.nextLine());
                System.out.print("Por favor introduzca su peso : ");
                hadrosaurios.setPeso(entradaEscaner.nextLine());
                System.out.print("Por favor introduzca su longitud : ");
                hadrosaurios.setLongitud(entradaEscaner.nextLine());
                System.out.print("Por favor introduzca su dieta : ");
                hadrosaurios.setDieta(entradaEscaner.nextLine());

                if (model.addDino(hadrosaurios)){
                    System.out.println("Datos almacenados correctamente");
                }else{
                    System.out.println("Datos no guardados");
                }
            break;
            
            case 2:

                ArrayList<String> data = new ArrayList<>();
                data.add("");
                data.add(""); 
                
                ArrayList<Hadrosaurios> list = model.selecHadrosaurios("Todo", null);

                for (int i = 0; i < list.size(); i++){

                    System.out.println(list.get(i).getId() + " " + list.get(i).getNombre() + " " + list.get(i).getGenero());

                }

            break;

            case 3:

                hadrosaurios = new Hadrosaurios();

                hadrosaurios.setId(entradaEscaner.nextInt());
                hadrosaurios.setNombre(entradaEscaner.nextLine());
                hadrosaurios.setFamilia(entradaEscaner.nextLine());
                hadrosaurios.setGenero(entradaEscaner.nextLine());
                hadrosaurios.setEra(entradaEscaner.nextLine());
                hadrosaurios.setAltura(entradaEscaner.nextLine());
                hadrosaurios.setPeso(entradaEscaner.nextLine());
                hadrosaurios.setLongitud(entradaEscaner.nextLine());
                hadrosaurios.setDieta(entradaEscaner.nextLine());
                
                if (model.updateDino(hadrosaurios)){
                    System.out.println("Datos actualizados correctamente");
                }else{
                    System.out.println("Los datos no han podido ser actualizados");
                }
                
            break;

            case 4:
                int confirmacion = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el registro\n"+"No podra volver a recuperarlos");
                if (confirmacion == JOptionPane.YES_OPTION){
                    if (model.deleteDino(2)){
                        System.out.println("Los Datos han sido Eliminados de forma correcta");
                    }else {
                        System.out.println("No se pudo eliminar la Información");
                    }

                }
            break;
            
            case 5:
                System.out.println("Saliendo del sistema.");
                System.out.println("Gracias por usar mi programa. Proceso finalizado");
            break;

        } 
        
    }
}
