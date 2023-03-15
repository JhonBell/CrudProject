package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DinosDao {

    private PreparedStatement sentenciaPreparada;
    private ResultSet resultadosDelSet;
    
    public boolean addDino(Hadrosaurios hadrosaurios){

        boolean state = false;
        Connection connect = null;

        try{
            connect = ConnectionPool.getInstance().getConnection();
            if (connect != null){

                String sql = "Insert INTO hadrosaurios (nombre, familia, genero, era, altura, peso, longitud, dieta ) VALUES (?,?,?,?,?,?,?,?)";
                sentenciaPreparada = connect.prepareStatement(sql);
                sentenciaPreparada.setString(1, hadrosaurios.getNombre());
                sentenciaPreparada.setString(2, hadrosaurios.getFamilia());
                sentenciaPreparada.setString(3, hadrosaurios.getGenero());
                sentenciaPreparada.setString(4, hadrosaurios.getEra());
                sentenciaPreparada.setString(5, hadrosaurios.getAltura());
                sentenciaPreparada.setString(6, hadrosaurios.getPeso());
                sentenciaPreparada.setString(7, hadrosaurios.getLongitud());
                sentenciaPreparada.setString(8, hadrosaurios.getDieta());

                int resultado = sentenciaPreparada.executeUpdate();    
                state = (resultado > 0);

            } else{
                System.out.println("Conexion fallida");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try {
                ConnectionPool.getInstance().closeConnection(connect); 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return state;
    }

    public ArrayList<Hadrosaurios> selecHadrosaurios(String filtro, ArrayList<String> data){
        ArrayList<Hadrosaurios> list = new ArrayList<>();
        Hadrosaurios hadrosaurios;

        Connection connect = null;

        try{
            connect = ConnectionPool.getInstance().getConnection();
            if (connect != null){

                String sql = "";

                switch(filtro){
                    case "Nombre":
                        sql = "SELECT * FROM hadrosaurios WHERE nombre REGEXP ? AND genero REGEXP ?";
                        sentenciaPreparada = connect.prepareStatement(sql);
                        sentenciaPreparada.setString(1, data.get(0));
                        sentenciaPreparada.setString(2, data.get(0));
                    break;
                    case "Id":
                        sql = "SELECT * FROM hadrosaurios WHERE id=?";
                        sentenciaPreparada = connect.prepareStatement(sql);
                        sentenciaPreparada.setInt(1, Integer.parseInt(data.get(0)));
                    break;

                    default:
                        sql = "SELECT * FROM hadrosaurios WHERE 1";
                        sentenciaPreparada = connect.prepareStatement(sql);
                    break;
                }

                resultadosDelSet =  sentenciaPreparada.executeQuery();
                
                while(resultadosDelSet.next()){

                    hadrosaurios = new Hadrosaurios();

                    hadrosaurios.setId(resultadosDelSet.getInt("id"));
                    hadrosaurios.setNombre(resultadosDelSet.getString("nombre"));
                    hadrosaurios.setFamilia(resultadosDelSet.getString("familia"));
                    hadrosaurios.setGenero(resultadosDelSet.getString("genero"));
                    hadrosaurios.setEra(resultadosDelSet.getString("era"));
                    hadrosaurios.setAltura(resultadosDelSet.getString("altura"));
                    hadrosaurios.setPeso(resultadosDelSet.getString("peso"));
                    hadrosaurios.setLongitud(resultadosDelSet.getString("longitud"));
                    hadrosaurios.setDieta(resultadosDelSet.getString("dieta"));
                    
                    list.add(hadrosaurios);

                }

            } else{
                System.out.println("Conexion fallida");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try {
                ConnectionPool.getInstance().closeConnection(connect); 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        return list;

    }

    public boolean updateDino(Hadrosaurios hadrosaurios){

        boolean state = false; 
        Connection connect = null;

        try {
            
            connect = ConnectionPool.getInstance().getConnection();
            if (connect != null){

                String sql = "UPDATE hadrosaurios SET nombre=?, familia=?, genero=?, era=?, altura=?, peso=?, longitud=?, dieta=? WHERE id=?";

                sentenciaPreparada = connect.prepareStatement(sql);
                sentenciaPreparada.setString(1, hadrosaurios.getNombre());
                sentenciaPreparada.setString(2, hadrosaurios.getFamilia());
                sentenciaPreparada.setString(3, hadrosaurios.getGenero());
                sentenciaPreparada.setString(4, hadrosaurios.getEra());
                sentenciaPreparada.setString(5, hadrosaurios.getAltura());
                sentenciaPreparada.setString(6, hadrosaurios.getPeso());
                sentenciaPreparada.setString(7, hadrosaurios.getLongitud());
                sentenciaPreparada.setString(8, hadrosaurios.getDieta());
                sentenciaPreparada.setInt(9, hadrosaurios.getId());

                int resultado = sentenciaPreparada.executeUpdate();

                state = resultado > 0 ;

            }else {
                System.out.println("Conexión Fallida");
            }


        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } finally{
            try {
                ConnectionPool.getInstance().closeConnection(connect);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return state;

    }

    public boolean deleteDino(int id){

        boolean state = false;
        Connection connect = null;

        try {
            
            connect = ConnectionPool.getInstance().getConnection();

            if (connect != null) {

                String sql = "DELETE FROM hadrosaurios WHERE id=?";

                sentenciaPreparada = connect.prepareStatement(sql);
                sentenciaPreparada.setInt(1, id);

                int resultado = sentenciaPreparada.executeUpdate();

                state = resultado > 0;
                
            } else {
                System.out.println("Conexion Fallida");
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            try {
                ConnectionPool.getInstance().closeConnection(connect);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        return state;

    }

}
