package TechProEd.JdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc4DMLInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from bolumler");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

		}
		/*
		 * ornek1: bolumler tablosuna yeni bir kayit(80,'ARGE','ISTANBUL') ekleyelim ve
		 * eklenen kayditeyit icin sorgulayalim.
		 * 
		 */

		// st.execute("insert into bolumler values(80,'ARGE','ISTANBUL')");
		// System.out.println("güncellendi");

		// ornek2: bolumler tablosuna birden fazla yeni kayit ekleyelim
		/*
		 * 1.YÖNTEM ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin
		 * yavas yapilamsina yol acar. uzun soluklu islemlerde tercih edilmez
		 */

//		String[] sorgular = { "INSERT INTO bolumler VALUES(95, 'YEMEKHANE', 'ISTANBUL')",
//				"INSERT INTO bolumler VALUES(85, 'OFIS','ANKARA')", "INSERT INTO bolumler VALUES(75, 'OFIS2', 'VAN')" };
//
//		for (String w : sorgular) {
//			st.executeUpdate(w);
//
//		}
//
//		System.out.println("calisti");

		// 2.YONTEM (addBath ve excuteBatch() metotlari ile)
		//Bilmek zorunda olmadigimiz bir yöntem daha 
		// ----------------------------------------------------
		// addBatch metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()
		// metodu ile veritabanina bir kere gonderilebilir.
		// excuteBatch() metodu bir int [] dizi dondurur. Bu dizi her bir ifade sonucunda 
		// etkilenen satir sayisini gosterir. 
		
		String [] sorgular1 = {"INSERT INTO bolumler VALUES(81, 'YEMEKHANE2', 'MUS')",
                "INSERT INTO bolumler VALUES(82, 'OFIS3','ORDU')",
                "INSERT INTO bolumler VALUES(83, 'OFIS4', 'MUGLA')"};
		for (String string : sorgular1) {
			st.addBatch(string);
		}
		// 3. YONTEM
	       //-----------------------------------------------------
	       // batch metoduyla birlikte PreparedStatement kullanmak en efektif yontemdir.
	       // bir sonraki ornekte bunu gerceklestirecegiz.Bir sonraki class a gidiniz---------->>>>
			st.executeBatch();	
			con.close();
			st.close();
			rs.close();
	}

}
