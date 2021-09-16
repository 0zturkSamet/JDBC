package TechProEd.JdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Jdbc5CRUD {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement st = con.createStatement();

		// tercih nedenleri
		// 1: hızlıdır, çoklu sorguları bir seferde yollar
//  2: hazırlanan deyimlerin en önemli avantajı SQL enjeksiyon saldırılarını önlemeye yardımcı olmasıdır. SQL enjeksiyonu, SQL ifadelerinde istemci tarafından sağlanan verileri kullanan
//  uygulamalardan kötü niyetli olarak yararlanma tekniğidir. Saldırganlar, özel hazırlanmış dize girişi sağlayarak SQL motorunu istenmeyen komutları yürütmesi için kandırır,
//  böylece kısıtlı verileri görüntülemek veya işlemek için bir veritabanına yetkisiz erişim elde eder. SQL enjeksiyon tekniklerinin tümü, uygulamadaki tek bir güvenlik açığından yararlanır
//   Yanlış doğrulanmış veya doğrulanmamış dize değişmezleri, dinamik olarak oluşturulmuş bir SQL ifadesinde birleştirilir ve SQL motoru tarafından kod olarak yorumlanır. 
//  Hazırlanan ifadeler, müşteri tarafından sağlanan verileri her zaman bir parametrenin içeriği olarak ele alır ve asla bir SQL ifadesinin parçası olarak kabul etmez.

		// ORNEK1: urunler adinda bir tablo olusturalim id(NUMBER(3),
		// isim VARCHAR2(10) fiyat NUMBER(7,2)

//	st.execute("create table urunler("
//			+ " id number(3),"
//			+ " isim varchar2(10),"
//			+ " fiyat number(7,2))");
//	System.out.println("Tablo olusturuldu.");
//	
		// ORNEK1: urunler adinda bir tablo olusturalim id(NUMBER(3),
		// isim VARCHAR2(10) fiyat NUMBER(7,2)

		List<Urun> kayitlar = new ArrayList<>();// hata gitmesi icin diamond icine class ismi olan Urun de yazabilirdik
		kayitlar.add(new Urun(101, "laptop", 6500));
		kayitlar.add(new Urun(102, "PC", 4500));
		kayitlar.add(new Urun(103, "Telefon", 4500));
		kayitlar.add(new Urun(104, "Anakart", 1500));
		kayitlar.add(new Urun(105, "Klavye", 200));
		kayitlar.add(new Urun(106, "Fare", 100));

		PreparedStatement pStatement = con.prepareStatement("insert into urunler values(?,?,?)");
		for (Urun w : kayitlar) {
			pStatement.setInt(1, w.getId());
			pStatement.setString(2, w.getIsimString());
			pStatement.setDouble(3, w.getFiyat());
		}
		pStatement.executeBatch();
		System.out.println("kayitlar eklendi");// islem basarili ;)
		ResultSet rs = st.executeQuery("select * from urunler");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3));

		}
		st.close();
		con.close();
		pStatement.close();

	}
}
