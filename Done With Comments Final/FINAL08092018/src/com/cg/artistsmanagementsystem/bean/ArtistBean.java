/**
 * 
 */
package com.cg.artistsmanagementsystem.bean;

/**
 * @author ibajaj
 *
 */
public class ArtistBean {
	private int artistId;
	private String artistName;
	private String artistType;
	private String artistBornDate;
	private String artistDiedDate;
	private int createdBy;
	private String createdOn;
	private int updatedBy;
	private String updatedOn;
	private char artistDeletedFlag;
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getArtistType() {
		return artistType;
	}
	public void setArtistType(String artistType) {
		this.artistType = artistType;
	}
	public String getArtistBornDate() {
		return artistBornDate;
	}
	public void setArtistBornDate(String artistBornDate) {
		this.artistBornDate = artistBornDate;
	}
	public String getArtistDiedDate() {
		return artistDiedDate;
	}
	public void setArtistDiedDate(String artistDiedDate) {
		this.artistDiedDate = artistDiedDate;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public int getUpdateBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public char getArtistDeletedFlag() {
		return artistDeletedFlag;
	}
	public void setArtistDeletedFlag(char artistDeletedFlag) {
		this.artistDeletedFlag = artistDeletedFlag;
	}
	public ArtistBean(int artistId, String artistName, String artistType,
			String artistBornDate, String artistDiedDate, int createdBy,
			String createdOn, int updatedBy, String updatedOn,
			char artistDeletedFlag) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.artistType = artistType;
		this.artistBornDate = artistBornDate;
		this.artistDiedDate = artistDiedDate;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
		this.artistDeletedFlag = artistDeletedFlag;
	}
	public ArtistBean() {
		super();
		
	}
	@Override
	public String toString() {
		return " --------------------------ARTIST DETAILS--------------------------\n ArtistId: " + artistId + "\n Artist Name: "
				+ artistName + "\n Artist Type: " + artistType
				+ "\n Artist Born Date: " + artistBornDate.substring(0, 10) + "\n Artist Died Date: "
				+ artistDiedDate.substring(0, 10) + "\n Created By: " + createdBy + "\n Created On: "
				+ createdOn + "\n Updated By: " + updatedBy + "\n Updated On: "
				+ updatedOn;
	}
	
	
	

}
