package uts_rps;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataControl {
    
    private ArrayList<Data> list = new ArrayList();
    private String[] header = {"No KTP", "Nama", "Tipe PS", "Durasi","Total Bayar"};
    
    public void read(JTable tabel){
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        
        for (int i = 0; i < list.size(); i++){
            Object[] obj = new Object[5];
            obj[0] = list.get(i).getNo_KTP();
            obj[1] = list.get(i).getNama();
            obj[2] = list.get(i).getTipe_PS();
            obj[3] = 0 + list.get(i).getDurasi() + " Hari";
            if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 5")){
                obj[4] ="Rp "+ 50000 * list.get(i).getDurasi();
            }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 4")){
                obj[4] ="Rp "+ 40000 * list.get(i).getDurasi();
            }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 3")){
                obj[4] ="Rp "+ 30000 * list.get(i).getDurasi();
            }else if(list.get(i).getTipe_PS().equalsIgnoreCase("psp")){
                obj[4] ="Rp "+ 25000 * list.get(i).getDurasi();
            }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 2")){
                obj[4] ="Rp "+ 20000 * list.get(i).getDurasi();
            }else {
                obj[4] ="Rp "+ 10000 * list.get(i).getDurasi();
            } 
            dtm.addRow(obj);
        }
        
        tabel.setModel(dtm);
    }
    
    public void create(Data data){
        list.add(data);
        JOptionPane.showMessageDialog(null, "Berhasil Menambah Data!");
    }
    
    public void update(Data data){
        for(int i = 0; i < list.size();i++){
            if(data.getNo_KTP() == list.get(i).getNo_KTP()){
                list.set(i, data);
            }
        }
    }
    
    public void delete(int id){
        for(int i=0;i < list.size();i++){
            if(id == list.get(i).getNo_KTP()){
                System.out.println(list.get(i).getNo_KTP());
                System.out.println(list.get(i).getNama());
                System.out.println(list.get(i).getDurasi());
                list.remove(i);
            }
        }
    }
    
    public void search(JTable tbl, int IdBrng){
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        
        for(int i = 0; i < list.size(); i++){
            if(IdBrng == list.get(i).getNo_KTP()){
                Object[] obj = new Object[5];
                obj[0] = list.get(i).getNo_KTP();
                obj[1] = list.get(i).getNama();
                obj[2] = list.get(i).getTipe_PS();
                obj[3] = list.get(i).getDurasi();
                if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 5")){
                    obj[4] ="Rp "+ 50000 * list.get(i).getDurasi();
                }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 4")){
                    obj[4] ="Rp "+ 40000 * list.get(i).getDurasi();
                }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 3")){
                    obj[4] ="Rp "+ 30000 * list.get(i).getDurasi();
                }else if(list.get(i).getTipe_PS().equalsIgnoreCase("psp")){
                    obj[4] ="Rp "+ 25000 * list.get(i).getDurasi();
                }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 2")){
                    obj[4] ="Rp "+ 20000 * list.get(i).getDurasi();
                }else {
                    obj[4] ="Rp "+ 10000 * list.get(i).getDurasi();
                } 
                dtm.addRow(obj);
            }
        }
        tbl.setModel(dtm);
    }
    
    
}
