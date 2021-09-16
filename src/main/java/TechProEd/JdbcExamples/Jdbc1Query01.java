package TechProEd.JdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.* her seyi tek seferde import etmemize olanak saglar

public class Jdbc1Query01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1)ilgili driver yükle-- tv nin calismasi icin elektrik veriyoruz

		Class.forName("oracle.jdbc.driver.OracleDriver");// ya evde yoksan firlatiyoruz

		// 2)baglanti olusturmaliyiz (netflix bagla)password ve id gir

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		// 3)SQL komutlari icin bir statament nesnesi olustur(alan olusturuldu kumanda
		// da kanal ayarlama)
		Statement st = con.createStatement();

		// 4)SQL ifadeleri yazabilir ve calistirabiliriz. (kumanda da istediğimiz komuta
		// basma. ses acma kanal degistirme)
		// (personel tablosundaki personel_id si 7369 olan personelin adini, maasini
		// sorgula)

		ResultSet isim = st.executeQuery("select personel_isim,maas from personel where personel_id=7369");

		// 5) sonuclari aldik ve isledik.Tabloda gezinziye cikiyoruz
		while (isim.next()) {
			System.out.print("Personel isim " + isim.getString("personel_isim") + " maas: " + isim.getInt("maas"));

		}
		//6 olusturulan nesneleri bellekten kaldiralim
		con.close();
		st.close();
		isim.close();
		
	}
}
