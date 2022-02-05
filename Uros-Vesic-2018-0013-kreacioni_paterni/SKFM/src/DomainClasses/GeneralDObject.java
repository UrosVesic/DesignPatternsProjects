/* GeneralDObject.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package DomainClasses;



import java.sql.*;

/**
 *
 * @author UrosVesic
 */

public interface GeneralDObject
{ String getAtrValue();
  String setAtrValue();
  String getClassName();
  String getWhereCondition();
  String getNameByColumn(int column);
  GeneralDObject getNewRecord(ResultSet rs) throws SQLException;
}
