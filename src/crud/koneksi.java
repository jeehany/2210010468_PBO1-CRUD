/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author USER
 */
public class koneksi {
    private String database_name = "2210010468";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public koneksi(){
        try {
            String lokasi = "jdbc:mysql://localhost/" + database_name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            
            System.out.println("Database Terkoneksi");
        } catch (Exception e) {            
            System.out.println(e.getMessage());
        }
    }
    
    public void Createkecamatan(String id_kecamatan, String kecamatan){
        try {
            String sql = "INSERT INTO kecamatan (id_kecamatan, kecamatan) VALUE (?,?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, id_kecamatan);
            perintah.setString(2, kecamatan);
            
            perintah.execute();
            System.out.println("Database Disimpan");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Readkecamatan(String id_kecamatan){
        try {
            String sql = "SELECT * FROM kecamatan where id_kecamatan=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, id_kecamatan);
            ResultSet data = perintah.executeQuery();
            while (data.next()){
                System.out.println("ID_kecamatan: " + data.getString("id_kecamatan"));
                System.out.println("Kecamatan: " + data.getString("kecamatan"));
            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    public void Updatekecamatan(String id_kecamatan, String kecamatan){
        try {
            String sql = "UPDATE kecamatan SET kecamatan=? where id_kecamatan=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, kecamatan);
            perintah.setString(2, id_kecamatan);
            
            perintah.execute();
            System.out.println("Database Diubah");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Deletekecamatan(String id_kecamatan){
        try {
            String sql = "DELETE FROM kecamatan where id_kecamatan=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, id_kecamatan);
            
            perintah.execute();
            System.out.println("Database Dihapus");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public int JumlahRecordkecamatan(){
        int jumlah = 0;
        try {
            String sql = "SELECT * FROM kecamatan ORDER BY id_kecamatan ASC";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()){
                jumlah = jumlah + 1;
            }
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        return jumlah;
    }
    
    public void GetRecordkecamatan(){
        try {
            String sql = "SELECT * FROM kecamatan order by id_kecamatan asc";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()){
                System.out.println(
                data.getString("id_kecamatan") + " | " +
                data.getString("kecamatan")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    public void Createmasjid(String id_masjid, String nama_masjid, String jenis_masjid, 
            String alamat_masjid, String id_kecamatan, String foto){
              
        try {
            String sql = "INSERT INTO data_masjid (id_masjid, nama_masjid, jenis_masjid, "
                    + "alamat_masjid, id_kecamatan, foto) VALUE (?,?,?,?,?,?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, id_masjid);
            perintah.setString(2, nama_masjid);
            perintah.setString(3, jenis_masjid);
            perintah.setString(4, alamat_masjid);
            perintah.setString(5, id_kecamatan);
            perintah.setString(6, foto);
            
            perintah.execute();
            System.out.println("Database Disimpan");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Readmasjid(String id_masjid){
        try {
            String sql = "SELECT * FROM data_masjid where id_masjid=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, id_masjid);
            ResultSet data = perintah.executeQuery();
            while (data.next()){
                System.out.println("ID Masjid: " + data.getString("id_masjid"));
                System.out.println("Nama Masjid: " + data.getString("nama_masjid"));
                System.out.println("Jenis Masjid: " + data.getString("jenis_masjid"));
                System.out.println("Alamat Masjid: " + data.getString("alamat_masjid"));
                System.out.println("ID Kecamatan: " + data.getString("id_masjid"));
                System.out.println("Foto: " + data.getString("foto"));
            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    public void Updatemasjid(String id_masjid, String nama_masjid, String jenis_masjid, 
            String alamat_masjid, String id_kecamatan, String foto){
        try {
            String sql = "UPDATE data_masjid SET nama_masjid=?, jenis_masjid=?,"
                    + "alamat_masjid=?, id_kecamatan=?, foto=? where id_masjid=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama_masjid);
            perintah.setString(2, jenis_masjid);
            perintah.setString(3, alamat_masjid);
            perintah.setString(4, id_kecamatan);
            perintah.setString(5, foto);
            perintah.setString(6, id_masjid);
            
            perintah.execute();
            System.out.println("Database Diubah");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Deletemasjid(String id_masjid){
        try {
            String sql = "DELETE FROM data_masjid where id_masjid=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, id_masjid);
            
            perintah.execute();
            System.out.println("Database Dihapus");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public int JumlahRecordmasjid(){
        int jumlah = 0;
        try {
            String sql = "SELECT * FROM data_masjid ORDER BY id_masjid ASC";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()){
                jumlah = jumlah + 1;
            }
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        return jumlah;
    }
    
    public void GetRecordmasjid(){
        try {
            String sql = "SELECT * FROM data_masjid order by id_masjid asc";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()){
                System.out.println(
                data.getString("id_masjid") + " | " +
                data.getString("nama_masjid") + " | " +
                data.getString("jenis_masjid") + " | " +
                data.getString("alamat_masjid") + " | " +
                data.getString("id_kecamatan") + " | " +
                data.getString("foto")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    public void CreateJadwal(int id_jadwal, String tgl_ceramah, int id_mubaligh, int id_ceramah, int id_masjid) {
        try {
            String sql = "INSERT INTO jadwal_ceramah (id_jadwal, tgl_ceramah, id_mubaligh, id_ceramah, id_masjid) VALUES (?,?,?,?,?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setInt(1, id_jadwal);
            perintah.setString(2, tgl_ceramah);
            perintah.setInt(3, id_mubaligh);
            perintah.setInt(4, id_ceramah);
            perintah.setInt(5, id_masjid);

            perintah.execute();
            System.out.println("Database Disimpan");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void Readjadwal(String id_jadwal){
        try {
            String sql = "SELECT * FROM jadwal where id_jadwal=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, id_jadwal);
            ResultSet data = perintah.executeQuery();
            while (data.next()){
                System.out.println("ID Jadwal: " + data.getString("id_jadwal"));
                System.out.println("Tanggal Ceramah: " + data.getString("tgl_ceramah"));
                System.out.println("ID Mubaligh: " + data.getString("id_mubaligh"));
                System.out.println("ID Ceramah: " + data.getString("id_ceramah"));
                System.out.println("ID Masjid: " + data.getString("id_masjid"));
            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    public void UpdateJadwal(int id_jadwal, String tgl_ceramah, int id_mubaligh, int id_ceramah, int id_masjid) {
        try {
            String sql = "UPDATE jadwal_ceramah SET tgl_ceramah=?, id_mubaligh=?, id_ceramah=?, id_masjid=? WHERE id_jadwal=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setString(1, tgl_ceramah);
            perintah.setInt(2, id_mubaligh);
            perintah.setInt(3, id_ceramah);
            perintah.setInt(4, id_masjid);
            perintah.setInt(5, id_jadwal);

            perintah.execute();
            System.out.println("Database Diubah");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void DeleteJadwal(int id_jadwal) {
        try {
            String sql = "DELETE FROM jadwal_ceramah WHERE id_jadwal=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setInt(1, id_jadwal);

            perintah.execute();
            System.out.println("Database Dihapus");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public int JumlahRecordjadwal(){
        int jumlah = 0;
        try {
            String sql = "SELECT * FROM jadwal ORDER BY id_jadwal ASC";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()){
                jumlah = jumlah + 1;
            }
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        return jumlah;
    }
    
    public void GetRecordjadwal(){
        try {
            String sql = "SELECT * FROM jadwal order by id_jadwal asc";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()){
                System.out.println(
                data.getString("id_jadwal") + " | " +
                data.getString("tgl_ceramah") + " | " +
                data.getString("id_mubaligh") + " | " +
                data.getString("id_ceramah") + " | " +
                data.getString("id_masjid")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
    
    public void CreateCeramah(int id_ceramah, String judul_ceramah) {
        try {
            String sql = "INSERT INTO ceramah (id_ceramah, judul_ceramah) VALUES (?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setInt(1, id_ceramah);
            perintah.setString(2, judul_ceramah);

            perintah.execute();
            System.out.println("Database Disimpan");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void Readceramah(String id_ceramah){
        try {
            String sql = "SELECT * FROM topik_ceramah where id_ceramah=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, id_ceramah);
            ResultSet data = perintah.executeQuery();
            while (data.next()){
                System.out.println("ID Ceramah: " + data.getString("id_ceramahl"));
                System.out.println("Judul Ceramah: " + data.getString("judul_ceramah"));
            }
        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }

    public void UpdateCeramah(int id_ceramah, String judul_ceramah) {
        try {
            String sql = "UPDATE ceramah SET judul_ceramah=? WHERE id_ceramah=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setString(1, judul_ceramah);
            perintah.setInt(2, id_ceramah);

            perintah.execute();
            System.out.println("Database Diubah");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void DeleteCeramah(int id_ceramah) {
        try {
            String sql = "DELETE FROM ceramah WHERE id_ceramah=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setInt(1, id_ceramah);

            perintah.execute();
            System.out.println("Database Dihapus");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public int JumlahRecordceramah(){
        int jumlah = 0;
        try {
            String sql = "SELECT * FROM topik_ceramah ORDER BY id_ceramah ASC";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()){
                jumlah = jumlah + 1;
            }
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
        return jumlah;
    }
    
    public void GetRecordceramah(){
        try {
            String sql = "SELECT * FROM topik_ceramah order by id_ceramah asc";
            Statement perintah = koneksiDB.createStatement();
            
            ResultSet data = perintah.executeQuery(sql);
            
            while(data.next()){
                System.out.println(               
                data.getString("id_ceramah") + " | " +         
                data.getString("judul_ceramah") 

                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
