package TechProEd.JdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2Query02 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement st = con.createStatement();
		// ornek1: Bolumler tablosundaki tüm kayitlari listeleyen bir sorgu yaziniz.
		// select * from bolumler;
		ResultSet tablo1 = st.executeQuery("select * from bolumler");// Sorguyu calistir=execute query
		while (tablo1.next()) {
			System.out.println(tablo1.getInt(1) + " " + tablo1.getString(2) + " " + tablo1.getString(3));
		}
//number int (1) varchar(2)String varchar(3)String
		System.out.println("----------------------------------------------------------------");
		/*
		 satis ve muhasebe bolumlerinde calisan personelin isimlerini ve  maaslarini,
		 maas ters sirali olarak listele
		 */
		String a = "select personel_isim,maas"
				+ " from personel "
				+ " where bolum_id in (10,30)"
				+ " order by maas desc ";
		ResultSet tablo2 = st.executeQuery(a);
		while(tablo2.next()) {
			System.out.println(tablo2.getString(1)+"    \t"+ tablo2.getInt(2));
			
		}
		
		/*  ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini
		  ve maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa
		  bile bolum ismi gosterilmelidir.   */
		
		String b= "select bolum_isim,personel_isim,maas"
				+ " from bolumler b"
				+ " left join personel p"
				+ " on b.bolum_id=p.bolum_id"
				+ " order by bolum_isim,maas";
		ResultSet tablo3 = st.executeQuery(b);
		while(tablo3.next()) {
		System.out.println(tablo3.getString(1)+ " "+ tablo3.getString(2)+" "+tablo3.getInt(3));
			
			
		}
		//ornek4: maasi en yüksek 10 kisinin bölümünü adini ve maasini listeleyiniz.
		ResultSet tablo4 = st.executeQuery(" select bolum_isim,personel_isim,maas"
				+ "  from personel p"
				+ "  full join bolumler b"
				+ "  on b.bolum_id=p.bolum_id"
				+ "  order by maas desc"
				+ "  fetch next 10 rows only");
		while(tablo3.next()) {
			System.out.println(tablo4.getString(1) +" " +tablo4.getString(2)+"     "+tablo4.getInt(3));
		}
		
		
		con.close();
		st.close();
		tablo1.close();
		tablo2.close();
		tablo3.close();
		tablo4.close();
		
		
		//isigi söndürmeyi unutma ;) 
		
		
		
		
		
		
		
		
		
	}
}
