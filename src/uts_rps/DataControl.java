package uts_rps;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataControl {
    
    private ArrayList<Data> list = new ArrayList();
    private String[] header = {"Id", "Nama", "Tipe PS", "Durasi","Total Bayar"};
    
    public void read(JTable tabel){
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        
        for (int i = 0; i < list.size(); i++){
            Object[] obj = new Object[5];
            obj[0] = list.get(i).getId();
            obj[1] = list.get(i).getNama();
            obj[2] = list.get(i).getTipe_PS();
            obj[3] = 0 + list.get(i).getDurasi() + " Jam";
            if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 5")){
                obj[4] ="Rp "+ 5000 * list.get(i).getDurasi();
            }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 4")){
                obj[4] ="Rp "+ 4000 * list.get(i).getDurasi();
            }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 3")){
                obj[4] ="Rp "+ 3000 * list.get(i).getDurasi();
            }else if(list.get(i).getTipe_PS().equalsIgnoreCase("psp")){
                obj[4] ="Rp "+ 2500 * list.get(i).getDurasi();
            }else if(list.get(i).getTipe_PS().equalsIgnoreCase("ps 2")){
                obj[4] ="Rp "+ 2000 * list.get(i).getDurasi();
            }else {
                obj[4] ="Rp "+ 1000 * list.get(i).getDurasi();
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
            if(data.getId() == list.get(i).getId()){
                list.set(i, data);
            }
        }
    }
    
    public void delete(int id){
        for(int i=0;i < list.size();i++){
            if(id == list.get(i).getId()){
                list.remove(i);
            }
        }
    }
    
    public void search(JTable tbl, String nama){
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        
        for(int i = 0; i < list.size(); i++){
            if(nama.equalsIgnoreCase(list.get(i).getNama())){
                Object[] obj = new Object[5];
                obj[0] = list.get(i).getId();
                obj[1] = list.get(i).getNama();
                obj[2] = list.get(i).getTipe_PS();
                obj[3] = list.get(i).getDurasi() + " Jam";
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
