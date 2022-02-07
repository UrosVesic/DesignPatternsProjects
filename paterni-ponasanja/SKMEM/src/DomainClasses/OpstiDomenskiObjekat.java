

package DomainClasses;



import java.sql.*;

/**
 *
 * @author UrosVesic
 */
// Operacije navedenog interfejsa je potrebno da implementira svaka od domenskih klasa,
// koja zeli da joj bude omogucena komunikacija sa Database broker klasom.
public interface OpstiDomenskiObjekat
{ String getAtrValue();
  String setAtrValue();
  String getClassName();
  String getWhereCondition();
  String getNameByColumn(int column);
  OpstiDomenskiObjekat getNewRecord(ResultSet rs) throws SQLException;
}
