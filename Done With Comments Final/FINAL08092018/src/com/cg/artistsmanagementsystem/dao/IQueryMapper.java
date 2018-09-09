/**
 * 
 */
package com.cg.artistsmanagementsystem.dao;

/**
 * @author ibajaj
 *
 */
public interface IQueryMapper {
	public static final String LOGIN="SELECT User_Type FROM User_Master WHERE User_id=? AND User_Password=?";
	public static final String USER_LOGIN="SELECT User_password FROM User_Master WHERE User_id=? AND User_type='U'";
	public static final String COMPOSER_SEARCH="SELECT C.Composer_id,C.Composer_Name,C.Composer_BornDate,C.Composer_DiedDate,C.Composer_CaeipiNumber,C.Composer_MusicSocietyID,C.Created_By,C.Created_On,C.Updated_By,C.Updated_On,M.Composer_MusicSocietyName FROM Composer_Master C,MusicSociety_Master M WHERE C.Composer_id=? AND M.Composer_MusicSocietyID=C.Composer_MusicSocietyID";
	public static final String ADD_COMPOSER="INSERT INTO Composer_Master VALUES(C_Seq.nextVal,?,TO_DATE(?,'dd/mm/yyyy'),NVL2(?,TO_DATE(?,'dd/mm/yyyy'),NULL),?,?,?,SYSDATE,?,SYSDATE,?)";
	public static final String ARTIST_SEARCH = "SELECT * FROM Artist_Master WHERE Artist_id=?";
	public static final String ADD_ARTIST = "INSERT INTO Artist_Master VALUES(A_Seq.nextVal,?,?,TO_DATE(?,'dd/mm/yyyy'),NVL2(?,TO_DATE(?,'dd/mm/yyyy'),NULL),?,SYSDATE,?,SYSDATE,?)";
	public static final String UPDATE_COMPOSER_NAME="UPDATE Composer_Master SET Composer_Name=?, Updated_By=?, Updated_On=SYSDATE WHERE Composer_id=?";
	public static final String UPDATE_COMPOSER_BORNDATE = "UPDATE Composer_Master SET Composer_BornDate=TO_DATE(?,'dd/mm/yyyy'), Updated_By=?, Updated_On=SYSDATE WHERE Composer_id=?";
	public static final String UPDATE_COMPOSER_DIEDDATE = "UPDATE Composer_Master SET Composer_DiedDate=NVL2(?,TO_DATE(?,'dd/mm/yyyy'),NULL), Updated_By=?,Updated_On=SYSDATE WHERE Composer_id=?";
	public static final String UPDATE_COMPOSER_CAEIPINUMBER = "UPDATE Composer_Master SET Composer_CaeipiNumber=?, Updated_By=?, Updated_On=SYSDATE WHERE Composer_id=?";
	public static final String UPDATE_COMPOSER_MUSICSOCIETYID = "UPDATE Composer_Master SET Composer_MusicSocietyId=?,Updated_By=?,Updated_On=SYSDATE WHERE Composer_Id=?";
	public static final String UPDATE_ARTIST_NAME = "UPDATE Artist_Master SET Artist_Name=?,Updated_By=?,Updated_On=SYSDATE WHERE Artist_id=?";
	public static final String UPDATE_ARTIST_TYPE = "UPDATE Artist_Master SET Artist_Type=?,Updated_By=?,Updated_On=SYSDATE WHERE Artist_id=?";
	public static final String UPDATE_ARTIST_BORNDATE = "UPDATE Artist_Master SET Artist_BornDate=TO_DATE(?,'dd/mm/yyyy'),Updated_By=?,Updated_On=SYSDATE WHERE Artist_id=?";
	public static final String UPDATE_ARTIST_DIEDDATE = "UPDATE Artist_Master SET Artist_DiedDate=NVL2(?,TO_DATE(?,'dd/mm/yyyy'),NULL), Updated_By=?,Updated_On=SYSDATE WHERE Artist_id=?";
	public static final String SEARCH_SONG="SELECT Song_Name FROM Song_Master WHERE Song_id=?";
	public static final String ASSOSCIATE_SONG_COMPOSER = "INSERT INTO Composer_Song_Assoc VALUES(?,?,?,SYSDATE,?,SYSDATE)";
	public static final String ASSOSCIATE_SONG_ARTIST = "INSERT INTO Artist_Song_Assoc VALUES(?,?,?,SYSDATE,?,SYSDATE)";
	public static final String SELECT_COMPOSER_ID = "SELECT C_Seq.currVal FROM Dual";
	public static final String SELECT_ARTIST_ID = "SELECT A_Seq.currVal FROM Dual";
	
	public static final String SEARCH_COMPOSER_SONGASSOC="SELECT S.Song_id, S.Song_Name, S.Song_Duration FROM SONG_MASTER S, Composer_Song_Assoc C WHERE S.Song_id=C.Song_id AND C.Composer_id=?";
	public static final String SEARCH_ARTIST_SONGASSOC = "SELECT S.Song_id, S.Song_Name, S.Song_Duration FROM SONG_MASTER S, Artist_Song_Assoc A WHERE S.Song_id=A.Song_id AND A.Artist_id=?";
	public static final String GET_COMPOSER_LIST = "SELECT Composer_id from Composer_Master";
	public static final String GET_ARTIST_LIST = "SELECT Artist_id from Artist_Master";
}

