package TechProEd.JdbcExamples;

import java.sql.*;
public class Jdbc3DDL {
	/*her sorguda öncekileri yoruma al hata vermesin
	 * 
	   A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) 
	      dondurmeyen metotlar kullanilmalidir.(executeQuery kullanamayız) Bunun icin JDBC'de 2 alternatif bulunmaktadir.  
	       1) execute() metodu 
	       2) excuteUpdate() metodu.  
	       
	 x  B) - execute() metodu hertur SQL ifadesiyle kullanilabilen genel bir komuttur.
	      - execute(), Boolean bir deger dondurur. DDL islemlerin false dondururken, 
	        DML islemlerinde true deger dondurur. 
	      - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi 
	        durumlarda tercih edilmektedir.  
	        
	  x C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
	      - bu islemlerde islemden etkilenen satir sayisini dondurur.
	      - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
	      x = gereksiz bilgi, vielleich für das Interview 
	*/

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement st = con.createStatement();
		
		/*
		 ornek1: isciler adinda bir tablo olusturunuz id NUMBER(3), 
													birim VARCHAR2(10), 
													maas NUMBER(5)
		 */
//	st.execute("create table isciler"
//				+ " (id NUMBER(3),"
//			+ " birim VARCHAR2(10),"
//			+ " maas NUMBER(5))");
//	System.out.println("isciler tablosu olusturuldu mu acaba :D");
//		System.out.println("Evet olusmus ;)");
//		
////-------------------------------------------------------------------------------------		
//		//Ornek2: isciler tablosunu kalici olarak siliniz.
//		
////		st.executeUpdate("drop table isciler purge");
////		System.out.println("isciler tablosu silindi");
////-------------------------------------------------------------------------------------
//		// ornek3:isim tablosuna yeni bir sutun (isim varchar2(20) ekleyiniz.)
//		st.executeUpdate("alter table isciler add isim varchar2(20)");
//		System.out.println("kacak kat ciktik");
		
//		//ornek4: isciler tablosundaki soyisim sütununu siliniz.
//		st.execute("alter table isciler drop column maas");
//		System.out.println("sutun silindi");
//		
		
		//isciler tablosunun adini calisanlar olarak degistiriniz.
		st.execute("alter table isciler rename to calisanlar");
		System.out.println("isim degistirildi");
		//NOT: commit i ne olur ne olmaz hata almayalim diye yaziyoruz.
		

	}

}
