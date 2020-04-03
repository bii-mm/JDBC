package br.mack.ps2;
import java.sql.*;
public class App {
    public static void main( String[] args ) {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String db = "registro_frequencia";
            String url = "jdbc:mysql://192.168.99.100:32771/" + db;
            String user = "root";
            String psw = "root";

            conn = DriverManager.getConnection(url,user,psw);

            //Inserindo dados na tabela:
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO aluno VALUES (idaluno, '31936873', '12:30:09', '13:00:13');");
            st.executeUpdate("INSERT INTO aluno VALUES (idaluno, '31988767', '14:45:00', '15:27:15');");
            st.executeUpdate("INSERT INTO aluno VALUES (idaluno, '31856587', '13:12:18', '13:00:00');");
            st.executeUpdate("INSERT INTO aluno VALUES (idaluno, '41590887', '20:30:45', '23:34:12');");

            //Lendo os registros da tabela:
            String sql = "SELECT * FROM aluno;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(); //registro

            while(rs.next()){
                int idaluno = rs.getInt("idaluno");
                int tia = rs.getInt("tia");
                String hr_entrada = rs.getString("hr_entrada");
                String hr_saida =  rs.getString("hr_saida");
                System.out.println("Aluno #"+ idaluno + " - TIA: " + tia + " Entrada: " + hr_entrada + " - Saída: " + hr_saida);
            }
            rs.close();
            conn.close();
        }catch (IllegalAccessException er){
            er.printStackTrace();
        } catch (InstantiationException er){
            er.printStackTrace();
        } catch(ClassNotFoundException er){
            er.printStackTrace();
        } catch(SQLException er){
            er.printStackTrace();
        }
    }
}
