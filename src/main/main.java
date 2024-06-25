/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import crud.koneksi;

/**
 *
 * @author User
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        koneksi myObject = new koneksi();
        
//        myObject.Createkecamatan("1","tanjung pagar");
//        myObject.Createnmasjid("1","alfurqan","jami","jl.mahatama","1","1.jpg");
//        myObject.Readkecamatan("1");
//        myObject.Updatekecamatan("1", "banjarmasin selatan");
//        myObject.Deletekecamatan("1");
//        myObject.GetRecordkecamatan();
        System.out.println("Jumlah Data : " + myObject.JumlahRecordkecamatan());
    }
    
}