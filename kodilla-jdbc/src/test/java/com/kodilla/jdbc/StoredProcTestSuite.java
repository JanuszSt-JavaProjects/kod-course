package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";

        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        // When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        String prepareBestsellerStatus = "update BOOKS SET BESTSELLER=FALSE";
        String queryBefore      = "select * from RENTS group by BOOK_ID having count(READER_ID) > 2";
        String queryAfter       = "select *  from BOOKS where BESTSELLER = TRUE ";
        String callProcedure    = "CALL UpdateBestsellers()";

        Statement smt = dbManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        smt.executeUpdate(prepareBestsellerStatus);

        //When
        ResultSet resultSet1 = smt.executeQuery(queryBefore);
        resultSet1.last();
        int resultsByCount = resultSet1.getRow();

        smt.execute(callProcedure);

        ResultSet resultSet2 = smt.executeQuery(queryAfter);
        resultSet2.last();
        int resultsByStatus = resultSet2.getRow();

        //Then
        assertEquals(resultsByCount, resultsByStatus);
    }

}