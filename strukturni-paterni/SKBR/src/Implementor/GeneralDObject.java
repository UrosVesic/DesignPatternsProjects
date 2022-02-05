

package Implementor;



import java.sql.*;

/**
 *
 * @author UrosVesic
 */

// Operacije navedenog interfejsa je potrebno da implementira svaka od domenskih klasa,
// koja zeli da joj bude omogucena komunikacija sa Database broker klasom.
public interface GeneralDObject  // Implementor
{ String getAtrValue();
  String setAtrValue();
  String getClassName();
  String getWhereCondition();
  String getNameByColumn(int column);
  GeneralDObject getNewRecord(ResultSet rs) throws SQLException;
}
