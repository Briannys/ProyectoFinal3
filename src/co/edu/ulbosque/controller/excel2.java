package co.edu.ulbosque.controller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import jxl.*;
public class excel2 {
	 private File archi;
	    private List<JTable> tabla;
	    private WritableCellFormat  fomato_fila ;
	    private WritableCellFormat  fomato_columna;

	    public excel2(List<JTable> tab, File ar) throws Exception {
	        this.archi = ar;
	        this.tabla = tab;
	        if(tab.size()<0){
	            throw new Exception("ERROR");
	        }
	    }
	    public boolean export() {
	        try {
	            DataOutputStream out = new DataOutputStream(new FileOutputStream(archi));
	            WritableWorkbook w = Workbook.createWorkbook(out);
	            w.createSheet("Parqueo Astor", 0);

	            for (int index=0;index<tabla.size();index++) {
	                JTable table=tabla.get(index);

	                  WritableSheet s = w.getSheet(0);

	                for (int i = 0; i < table.getColumnCount(); i++) {
	                    for (int j = 0; j < table.getRowCount(); j++) {
	                        Object objeto = table.getValueAt(j, i);

	                        createColumna(s,table.getColumnName(i),i);//crea la columna
	                        createFilas(s,i,j,String.valueOf(objeto));//crea las filas
	                    }
	                }
	            }
	            w.write();
	            w.close();
	            out.close();
	            return true;

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (WriteException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	    }
	    @SuppressWarnings("deprecation")
		private void createColumna(WritableSheet sheet,String columna,int number_columna)throws WriteException {
	        //creamos el tipo de letra
	        WritableFont times10pt = new WritableFont(WritableFont.TAHOMA, 14);
	        // definimos el formato d ela celda
	        WritableCellFormat  times = new WritableCellFormat(times10pt);
	        // Permite si se ajusta autom�ticamente a las c�lulas
	        //times.setWrap(true);
	        // crea una negrita con subrayado
	        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.TAHOMA, 11, WritableFont.BOLD, false,UnderlineStyle.SINGLE);
	        fomato_columna = new WritableCellFormat(times10ptBoldUnderline);
	        // Permite que se ajusta autom�ticamente a las c�lulas
	        //fomato_columna.setWrap(true);
	        CellView cevell = new CellView();
	        cevell.setSize(920);
	        cevell.setDimension(70);
	        cevell.setFormat(times);
	        cevell.setFormat(fomato_columna);
	        //cevell.setAutosize(true);
	        // escribimos las columnas
	        addColumna(sheet, number_columna, 0, columna,fomato_columna);//numero de columna , 0 es la fila
	    }
	    /****************************************/
	    private void createFilas(WritableSheet sheet,int number_columna,int filas,String name_filas)throws WriteException {
	        //creamos el tipo de letra
	        WritableFont times10pt = new WritableFont(WritableFont.ARIAL, 12);
	        times10pt.setColour(Colour.GOLD);
	        // definimos el formato d ela celda
	        WritableCellFormat  times = new WritableCellFormat(times10pt);
	        times.setBorder(Border.TOP, BorderLineStyle.MEDIUM, Colour.GOLD);
	        // Permite si se ajusta autom�ticamente a las c�lulas
	        //times.setWrap(true);
	        // crea una negrita con subrayado
	        WritableFont times10ptBoldUnderline = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false,UnderlineStyle.NO_UNDERLINE);
	        fomato_fila = new WritableCellFormat(times10ptBoldUnderline);
	        // Permite que se ajusta autom�ticamente a las c�lulas
	        //fomato_fila.setWrap(true);
	        CellView cevell = new CellView();
	        cevell.setDimension(70);
	        cevell.setFormat(times);
	        cevell.setFormat(fomato_fila);
	        //cevell.setAutosize(true);
	        // escribimos las columnas
	        addFilas(sheet, number_columna, filas, name_filas,fomato_fila);
	    }
	    /***********************************/
	    private void addColumna(WritableSheet sheet, int column, int row, String s,WritableCellFormat format)throws RowsExceededException, WriteException {
	        Label label;
	        label = new Label(column, row, s, format);
	        sheet.addCell(label);
	    }
	    private void addFilas(WritableSheet sheet, int column, int row, String s,WritableCellFormat format)throws WriteException, RowsExceededException {
	        Label label;
	        label = new Label(column, row, s, format);
	        sheet.addCell(label);
	    }
	  public static JTable tablaE() {
	    	 String data[][]={ {"","",""},    
                    {"0","Briannys","780"},    
                    {"1","David","65"},
                    {"2", "Sergio", "44"}};    
	    	 String column[]={"Cliente","Nombre","Telefono"};         
	    	 JTable jt=new JTable(data,column);    
	    	 jt.setBounds(30,40,200,300);          
	    	 JScrollPane sp=new JScrollPane(jt);
	    	 return jt;
	    }
	    public static void main(String[] args) {
	    	try { 
	    	List<JTable> tb = new ArrayList<>();
            tb.add(tablaE());
            //-------------------
            excel2 excelExporter = new excel2(tb, new File("D://Briannys//book"+".xls")); // String con directorio
            if (excelExporter.export()) {
                System.out.println("TABLAS EXPORTADOS CON EXITOS!");
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
		}
}
