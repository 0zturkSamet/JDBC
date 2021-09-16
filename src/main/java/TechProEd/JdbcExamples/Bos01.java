package TechProEd.JdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bos01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement st = con.createStatement();

		/*
		 * ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini ve
		 * maaslarini, bolum ve maas sirali listeleyiniz. NOT:calisani olmasa bile bolum
		 * ismi gosterilmelidir.
		 */

		String b = "select maas,bolum_isim,personel_isim"// alt satira gecince bosluk birakmayi unutma.
				+ " from bolumler b" + " left join personel p" + " on b.bolum_id=p.bolum_id"
				+ " order by bolum_isim,maas";
		ResultSet tablo3 = st.executeQuery(b);
		while (tablo3.next()) {
			// System.out.println(tablo3.getInt(1)+ " "+ tablo3.getString(2)+"
			// "+tablo3.getString(3));
			System.out.printf("%-10d %-10s %-10s\n", tablo3.getInt(1), tablo3.getString(2), tablo3.getString(3));

			// int d, String s alt alta\n float f , sola yatirma icin (-) kullanilir.(+)
			// yerine virgül kullan.

		}
	}
}
